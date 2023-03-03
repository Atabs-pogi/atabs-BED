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

import javax.persistence.Transient;
import javax.transaction.Transactional;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
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

    public List<EmployeeEntity> getEmployeePayrollStatus(LocalDate period){
        List<EmployeeEntity> employees = employeeDao.findAll();
        List<PayrollEntity> payrolls = payrollDao.findAll();
        //payrollDao.getEmployeesPeriod(this.getPeriodStart(period), this.getPeriodEnd(period));
        for (EmployeeEntity employee : employees) {
            for (PayrollEntity payroll: payrolls) {
                if (payroll.getEmployee().getId() == employee.getId()){
                    employee.setReviewed(true);
                }
            }
        }
        return employees;
    }

    @Transactional
    public Payroll saveEmployeePayroll(Payroll payroll) throws NotFoundException {
        double withholdingTax = 0;
        double incomeExcess = 0;
        double netPay = 0;
        EmployeeEntity employee =  employeeDao.findById(payroll.getEmployeeId()).orElse(null);
        if(employee == null){
            throw new NotFoundException("Employee not found");
        }
        PayrollEntity entity = payrollDao.getEmployeePayrollByPeriod(
                payroll.getEmployeeId(),
                payroll.getPeriodStart(),
                payroll.getPeriodEnd()
        );
        if(entity == null) {
            entity = new PayrollEntity();
        }
        EmployeeSalaryEntity salary = salaryDao.getSalaryByEmployeeId(payroll.getEmployeeId());
        if (salary == null) {
            throw new NotFoundException("Employee Salary not found");
        }
        payroll.setDailyBasic(salary.getDailyBasic());
        payroll.setMonthlyBasic(salary.getMonthlyBasic());

        BirTaxEntity taxes = birTaxDao.getTaxBySalaryRange(payroll.getGrossPay());
        if(taxes == null){
            payroll.setWithholdingTax(withholdingTax);
//            uncomment if they will use the BIR taxes table and remove the line above
//            throw new NotFoundException("Tax table not found");
        } else {
            incomeExcess = payroll.getTaxableIncome() - taxes.getMinimum();
            withholdingTax = taxes.getFixTax() + (incomeExcess * taxes.getTaxRateOnExcess());
        }
        payroll.setWithholdingTax(formatDecimal(withholdingTax));
        if (withholdingTax == 0) {
            netPay = payroll.getTaxableIncome() - payroll.getTotalDeductions();
        } else {
            netPay = (payroll.getTaxableIncome() - payroll.getWithholdingTax()) - payroll.getTotalDeductions();
        }
        payroll.setNetPay(formatDecimal(netPay));
        //Save payroll
        entity.setPeriodStart(payroll.getPeriodStart());
        entity.setPeriodEnd(payroll.getPeriodEnd());
        entity.setTotalGrossPay(payroll.getGrossPay());
        entity.setTotalBenefitContributions(payroll.getTotalBenefitContributions());
        entity.setTotalDeductions(payroll.getTotalDeductions());
        entity.setNetPay(payroll.getNetPay());
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
        //Save benefits contribution
        List<PayrollBenefit> benefits = payroll.getBenefits();
        for (PayrollBenefit benefit : benefits) {
        PayrollBenefitEntity benefitEntity = payrollBenefitDao.getExistingBenefit(entity.getId(),benefit.getBenefitType());
        if(benefitEntity == null) {
            benefitEntity = new PayrollBenefitEntity();
            benefitEntity.setPayrollId(entity.getId());
        }
        benefitEntity.setBenefitType(benefit.getBenefitType());
        benefitEntity.setContributionAmount(benefit.getContributionAmount());
        payrollBenefitDao.save(benefitEntity);
        benefit.setId(benefitEntity.getId());
        benefit.setPayrollId(entity.getId());
        }
        //Save deductibles
        List<PayrollDeductible> deductibles = payroll.getDeductibles();
        for (PayrollDeductible deductible : deductibles) {
            PayrollDeductibleEntity deductibleEntity = payrollDeductibleDao.getExistingDeductible(entity.getId(),deductible.getDescription() );
            if(deductibleEntity == null) {
                deductibleEntity = new PayrollDeductibleEntity();
                deductibleEntity.setPayrollId(entity.getId());
            }
            deductibleEntity.setDescription(deductible.getDescription());
            deductibleEntity.setValue(deductible.getValue());
            payrollDeductibleDao.save(deductibleEntity);
            deductible.setId(deductibleEntity.getId());
            deductible.setPayrollId(entity.getId());
        }
        return payroll;
    }

//    public  List<PayrollEntity> getAllEmployeesPayrollByPeriod(LocalDate periodStart, LocalDate periodEnd) {
//        long empId = 0;
//        return getPayroll(empId, periodStart, periodEnd);
//    }
//
//    public  List<PayrollEntity> getEmployeePayrollByPeriod(Long empId, LocalDate periodStart, LocalDate periodEnd) {
//        return getPayroll(empId, periodStart, periodEnd);
//    }

//    private List<PayrollEntity> getPayroll(Long empId, LocalDate periodStart, LocalDate periodEnd) {
//        List<PayrollEntity> payrolls;
//        if (empId == 0) {
//            payrolls = payrollDao.getPayrollByPeriod(periodStart, periodEnd);
//        }else {
//            payrolls = payrollDao.getEmployeePayroll(empId, periodStart, periodEnd);
//        }
//        double grossPay = 0,
//                totalDeductions = 0,
//                taxableIncome = 0,
//                incomeExcess = 0,
//                withholdingTax = 0,
//                netPay = 0;
//        List<PayrollEntity> payrollsEntity = new ArrayList<>();
//        for (PayrollEntity payroll : payrolls) {
//            grossPay = getGrossPay(payroll, periodStart, periodEnd);
//            payroll.setGrossPay(formatDecimal(grossPay));
//            totalDeductions = getTotalDeductions(payroll.getId());
//            payroll.setTotalDeductions(formatDecimal(totalDeductions));
//            taxableIncome = grossPay - totalDeductions;
//            payroll.setTaxableIncome(formatDecimal(taxableIncome));
//            BirTaxEntity range = birTaxDao.getTaxBySalaryRange(payroll.getGrossPay());
//            if (range != null) {
//                incomeExcess = taxableIncome - range.getMinimum();
//                withholdingTax = range.getFixTax() + (incomeExcess * range.getTaxRateOnExcess());
//                payroll.setWithholdingTax(formatDecimal(withholdingTax));
//            }
//            netPay = taxableIncome - withholdingTax;
//            payroll.setNetPay(formatDecimal(netPay));
//            payrollsEntity.add(payroll);
//        }
//        return payrolls;
//    }
//    private double getGrossPay(PayrollEntity payroll, LocalDate start, LocalDate end){
//        int daysOfMonth = LocalDate.now().withDayOfMonth(LocalDate.now().lengthOfMonth()).getDayOfMonth();
//        double regularPay = 0,
//                overTimePay = 0,
//                tardinessDeduction = 0,
//                vacationPay = 0,
//                sickPay = 0,
//                grossPay = 0;
//        //Rates
//        double hourlyRate  = payroll.getDailyBasic() / 8;
//        double overTimeRate = hourlyRate * 1.25; // ( +25% )
//        double tardinessRate = 0.1;
//        // ( Formulas )
//        List<PayrollDetailEntity> payrollDetailsEntities = payrollDetailDao.getByPeriod(payroll.getId(), start, end);
//        for (PayrollDetailEntity payrollDetail: payrollDetailsEntities) {
//            regularPay += payrollDetail.getRegular() * hourlyRate;
//            overTimePay += payrollDetail.getOt() * overTimeRate;
//            tardinessDeduction += hourlyRate * tardinessRate * payrollDetail.getTardiness();
//            vacationPay += payroll.getDailyBasic() * payrollDetail.getVacation();
//            sickPay += payroll.getDailyBasic() * payrollDetail.getSick();
//        }
//        payroll.setRegularPay(formatDecimal(regularPay));
//        payroll.setOverTimePay(formatDecimal(overTimePay));
//        payroll.setTardinessDeduction(formatDecimal(tardinessDeduction));
//        payroll.setVacationPay(formatDecimal(vacationPay));
//        payroll.setSickPay(formatDecimal(sickPay));
//        grossPay = regularPay + overTimePay + vacationPay + sickPay - tardinessDeduction;
//        return grossPay;
//    }
    private double getTotalDeductions(Long payrollId){
        double totalDeductions = 0;
        List<PayrollDeductibleEntity>deductibleEntities = payrollDeductibleDao.getAllDeductibles(payrollId);
        for (PayrollDeductibleEntity deduct: deductibleEntities) {
            totalDeductions += deduct.getValue();
        }
        return totalDeductions;
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
