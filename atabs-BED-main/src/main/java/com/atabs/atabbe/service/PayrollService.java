package com.atabs.atabbe.service;

import com.atabs.atabbe.dao.*;
import com.atabs.atabbe.entity.*;
import com.atabs.atabbe.exception.NotFoundException;
import com.atabs.atabbe.model.PayrollBenefit;
import com.atabs.atabbe.model.PayrollDeductible;
import com.atabs.atabbe.model.Payroll;
import com.atabs.atabbe.model.PayrollDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.List;

@Service
public class PayrollService {

    @Autowired
    private PayrollDao payrollDao;
    @Autowired
    private PayrollDetailDao payrollDetailDao;
    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private EmployeeSalaryDao salaryDao;
    @Autowired
    private PayrollDeductibleDao payrollDeductibleDao;
    @Autowired
    private PayrollBenefitDao payrollBenefitDao;
    @Autowired
    private BirTaxDao birTaxDao;

    public List<PayrollEntity> getAllByPeriod(LocalDate period){
        return payrollDao.getPayrollByPeriod(this.getPeriodStart(period), this.getPeriodEnd(period));
    }

    public List<EmployeeEntity> getEmployeePayrollStatus(LocalDate periodStart, LocalDate periodEnd){
        List<EmployeeEntity> employees = employeeDao.findAll();
        for (EmployeeEntity employee : employees) {
            PayrollEntity payroll = payrollDao.getEmployeePayrollByPeriod(employee.getId(), periodStart, periodEnd);
            if (payroll != null){
                employee.setReviewed(true);
            }
        }
        return employees;
    }

    @Transactional
    public PayrollEntity createPayroll(Payroll payroll) throws NotFoundException {
        //check if employee exist
        EmployeeEntity employee =  employeeDao.findById(payroll.getEmployeeId()).orElse(null);
        if(employee == null){
            throw new NotFoundException("Employee not found");
        }
        //check if payroll already exist
        PayrollEntity entity = payrollDao.getEmployeePayrollByPeriod(
                payroll.getEmployeeId(),
                payroll.getPeriodStart(),
                payroll.getPeriodEnd()
        );
        if(entity == null) {
            entity = new PayrollEntity();
        }
        //Save payroll
        entity.setPeriodStart(payroll.getPeriodStart());
        entity.setPeriodEnd(payroll.getPeriodEnd());
        entity.setPaymentMethod(payroll.getPaymentMethod());
        entity.setPaymentDate(payroll.getPaymentDate());
        entity.setEmployee(employee);
        payrollDao.save(entity);
        payroll.setId(entity.getId());
        //Save items
        List<PayrollDetails> items = payroll.getItems();
        for (PayrollDetails item: items) {
            PayrollDetailEntity detailEntity = payrollDetailDao.getByDate(entity.getId(), item.getDate());
            if(detailEntity == null){
                detailEntity = new PayrollDetailEntity();
                detailEntity.setPayrollId(entity.getId());
            }
            detailEntity.setDate(item.getDate());
            detailEntity.setRegular(item.getRegular());
            detailEntity.setOt(item.getOt());
            detailEntity.setTardiness(item.getTardiness());
            detailEntity.setVacation(item.getVacation());
            detailEntity.setSick(item.getSick());
            payrollDetailDao.save(detailEntity);
            item.setId(detailEntity.getId());
            item.setPayrollId(entity.getId());
        }
        return calculatePays(entity.getId());
    }

    @Transactional
    private PayrollEntity calculatePays(long payrollId) throws NotFoundException {
        int regularHours = 8;
        double overTimeRate = 1.25;

        double regularWorkHours = 0;
        double otHours = 0;
        double totalTardiness = 0;
        double vacationDays = 0;
        double sickDays = 0;

        double regularPay = 0;
        double overTimePay = 0;
        double tardinessDeduction = 0;
        double vacationPay = 0;
        double sickPay = 0;
        PayrollEntity payroll = payrollDao.findById(payrollId).orElse(null);
        if (payroll == null) {
            throw new NotFoundException("Payroll not found");
        }
        EmployeeSalaryEntity salary = salaryDao.getSalaryByEmployeeId(payroll.getEmployee().getId());
        if (salary == null) {
            throw new NotFoundException("Employee Salary not found");
        }
        List<PayrollDetailEntity> details = payrollDetailDao.getByPeriod(payrollId, payroll.getPeriodStart(), payroll.getPeriodEnd());
        for (PayrollDetailEntity detail: details) {
            regularWorkHours += detail.getRegular();
            otHours += detail.getOt();
            totalTardiness += detail.getTardiness();
            vacationDays += detail.getVacation();
            sickDays += detail.getSick();
        }

        // Calculate Pays
        regularPay = calculateRegularPay(regularWorkHours, salary.getDailyBasic() / regularHours);
        overTimePay = calculateOtPay(otHours, salary.getDailyBasic() / regularHours, overTimeRate);
        tardinessDeduction = calculateTardiness(totalTardiness, salary.getDailyBasic() / regularHours);
        vacationPay = calculateVacationPay(vacationDays, salary.getDailyBasic());
        sickPay = calculateSickPay(sickDays, salary.getDailyBasic());

        //update payroll
        payroll.setTotalWorkHours(regularWorkHours);
        payroll.setOverTimeRate((salary.getDailyBasic() / regularHours) * overTimeRate);
        payroll.setTotalOtHours(otHours);
        payroll.setTotalTardinessHours(tardinessDeduction);
        payroll.setTotalVacationDays(vacationDays);
        payroll.setTotalSickDays(sickDays);

        payroll.setRegularPay(formatDecimal(regularPay));
        payroll.setOverTimePay(formatDecimal(overTimePay));
        payroll.setTardinessDeduction(formatDecimal(tardinessDeduction));
        payroll.setVacationPay(formatDecimal(vacationPay));
        payroll.setSickPay(formatDecimal(sickPay));
        payroll.setGrossPay(formatDecimal(regularPay + overTimePay + vacationPay + sickPay - tardinessDeduction));
        payrollDao.save(payroll);
        return payroll;
    }

    @Transactional
    public PayrollEntity saveBenefit(List<PayrollBenefit> benefits) throws NotFoundException {
        Long payrollId = null;
        double totalBenefits = 0;
        double taxableIncome = 0;
        double withholdingTax = 0;
        double incomeExcess = 0;
        double netPay = 0;
        for (PayrollBenefit benefit : benefits) {
            PayrollBenefitEntity benefitEntity = payrollBenefitDao.getExistingBenefit(benefit.getPayrollId(),benefit.getBenefitType());
            if(benefitEntity == null) {
                benefitEntity = new PayrollBenefitEntity();
                benefitEntity.setPayrollId(benefit.getPayrollId());
            }
            benefitEntity.setBenefitType(benefit.getBenefitType());
            benefitEntity.setContributionAmount(benefit.getContributionAmount());
            payrollBenefitDao.save(benefitEntity);
            benefit.setId(benefitEntity.getId());

            totalBenefits += benefitEntity.getContributionAmount();
            payrollId = benefit.getPayrollId();
        }

        assert payrollId != null;
        PayrollEntity payroll = payrollDao.findById(payrollId).orElse(null);
        if (payroll == null) {
            throw new NotFoundException("Cannot save Benefits, Payroll not found");
        }
        taxableIncome = payroll.getGrossPay() - totalBenefits;

        payroll.setTotalBenefitContributions(formatDecimal(totalBenefits));
        payroll.setTaxableIncome(formatDecimal(taxableIncome));

        BirTaxEntity taxes = birTaxDao.getTaxBySalaryRange(payroll.getGrossPay());
        if(taxes == null){
            payroll.setWithholdingTax(withholdingTax);
//            uncomment below code if they will use the BIR taxes table and remove the line above
//            throw new NotFoundException("Tax table not found");
        } else {
            incomeExcess = taxableIncome - taxes.getMinimum();
            withholdingTax = taxes.getFixTax() + (incomeExcess * taxes.getTaxRateOnExcess());
        }
        payroll.setWithholdingTax(formatDecimal(withholdingTax));

        if (withholdingTax == 0) {
            netPay = taxableIncome;
        } else {
            netPay = taxableIncome - withholdingTax;
        }
        payroll.setNetPay(formatDecimal(netPay));
        return payrollDao.save(payroll);
    }

    @Transactional
    public PayrollEntity saveDeductible(List<PayrollDeductible> deductibles) throws NotFoundException {
        Long payrollId = null;
        double totalDeductions = 0;
        double netPay = 0;
        for (PayrollDeductible deductible : deductibles) {
            PayrollDeductibleEntity deductibleEntity = payrollDeductibleDao.getExistingDeductible(deductible.getPayrollId(),deductible.getDescription());
            if(deductibleEntity == null) {
                deductibleEntity = new PayrollDeductibleEntity();
                deductibleEntity.setPayrollId(deductible.getPayrollId());
            }
            deductibleEntity.setDescription(deductible.getDescription());
            deductibleEntity.setValue(deductible.getValue());
            payrollDeductibleDao.save(deductibleEntity);

            totalDeductions += deductibleEntity.getValue();
            payrollId = deductible.getPayrollId();
        }

        assert payrollId != null;
        PayrollEntity payroll = payrollDao.findById(payrollId).orElse(null);
        if (payroll == null) {
            throw new NotFoundException("Cannot save Deductibles, Payroll not found");
        }
        netPay = payroll.getNetPay();
        payroll.setOtherDeductions(formatDecimal(totalDeductions));
        payroll.setTotalDeductions(formatDecimal(totalDeductions + payroll.getTardinessDeduction()));
        payroll.setNetPay(formatDecimal(netPay - totalDeductions));
        return payrollDao.save(payroll);
    }

    public  List<PayrollEntity> getEmployeePayrollByPeriod(Long empId, LocalDate periodStart, LocalDate periodEnd) {
        return getPayroll(empId, periodStart, periodEnd);
    }

    public  List<PayrollEntity> getAllEmployeesPayrollByPeriod(LocalDate periodStart, LocalDate periodEnd) {
        long empId = 0;
        return getPayroll(empId, periodStart, periodEnd);
    }

    private List<PayrollEntity> getPayroll(Long empId, LocalDate periodStart, LocalDate periodEnd) {
        List<PayrollEntity> payrolls;
        if (empId == 0) {
            payrolls = payrollDao.getPayrollByPeriod(periodStart, periodEnd);
        }else {
            payrolls = payrollDao.getEmployeePayroll(empId, periodStart, periodEnd);
        }
        return payrolls;
    }

    private double calculateRegularPay(double hoursWorked, double hourlyRate) {
        double regularPay;
        regularPay = hoursWorked * hourlyRate;
        return regularPay;
    }

    private double calculateOtPay(double otHours, double hourlyRate, double overTimeRate) {
        double overTimePay;
        overTimePay = otHours * (hourlyRate * overTimeRate);
        return overTimePay;
    }

    private double calculateTardiness(double tardiness, double hourlyRate) {
        double tardinessDeduction = 0;
        double tardinessRate = 0.8; // can be change to fix rate
        tardinessDeduction = tardiness * (hourlyRate * tardinessRate);
        return tardinessDeduction;
    }

    private double calculateVacationPay(double vacation, double dailyRate) {
        double vacationPay = 0;
        vacationPay = vacation * dailyRate;
        return vacationPay;
    }

    private double calculateSickPay(double sick, double dailyRate) {
        double sickPay = 0;
        sickPay = sick * dailyRate;
        return sickPay;
    }

    private double formatDecimal(double value) {
        DecimalFormat df = new DecimalFormat("#.##");
        String formattedValue = df.format(value);
        return Double.parseDouble(formattedValue);
    }

    private LocalDate getPeriodStart(LocalDate period) {
        LocalDate start = null;
        if (period.getDayOfMonth() < 15) {
            start = period.withDayOfMonth(1);
        }else if (period.getDayOfMonth() > 15) {
            start = period.withDayOfMonth(16);
        }
        return start;
    }

    private LocalDate getPeriodEnd(LocalDate period) {
        LocalDate end = null;
        if (period.getDayOfMonth() < 15) {
            end = period.withDayOfMonth(15);
        }else if (period.getDayOfMonth() > 15) {
            end = period.withDayOfMonth(period.lengthOfMonth());
        }
        return end;
    }
}
