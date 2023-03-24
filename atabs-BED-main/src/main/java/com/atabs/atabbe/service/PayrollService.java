package com.atabs.atabbe.service;

import com.atabs.atabbe.dao.*;
import com.atabs.atabbe.dto.PayrollSummaryDTO;
import com.atabs.atabbe.entity.*;
import com.atabs.atabbe.exception.NotFoundException;
import com.atabs.atabbe.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.*;

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
    private BirTaxDao birTaxDao;
    @Autowired
    private HolidayDao holidayDao;
    @Autowired
    private PayrollBenefitDao benefitDao;
    @Autowired
    private MandatoryDeductionDao mandatoryDeductionDao;
    @Autowired
    private OtherDeductionDao otherDeductionDao;


    public List<PayrollEntity> getAllByPeriod(LocalDate period){
        return payrollDao.getPayrollByPeriod(this.getPeriodStart(period), this.getPeriodEnd(period));
    }

    public List<Employee> getEmployeePayrollStatus(LocalDate periodStart, LocalDate periodEnd, String name) {
        List<EmployeeEntity> entityEmployees = employeeDao.searchEmployeeByName(name);
        List<Employee> employees = new ArrayList<>();
        for (EmployeeEntity employee : entityEmployees) {
            employees.add(Employee.from(employee));
            PayrollEntity payroll = payrollDao.getEmployeePayrollByPeriod(employee.getId(), periodStart, periodEnd);
            if (payroll != null) {
                employee.setReviewed(true);
            }
        }
        return employees;
    }

    @Transactional
    public PayrollEntity createPayroll(Payroll payroll) throws NotFoundException {
        //check if employee exist
        EmployeeEntity employee =  employeeDao.findById(payroll.getEmployeeId())
                .orElseThrow(() -> new NotFoundException("Employee not found"));
        //check if payroll already exist
        PayrollEntity PayrollEntity = payrollDao.getEmployeePayroll(
                payroll.getEmployeeId(),
                payroll.getPeriodStart(),
                payroll.getPeriodEnd()
        );
        if(PayrollEntity == null) {
            PayrollEntity = new PayrollEntity();
        }
        //Create payroll
        PayrollEntity.setPeriodStart(payroll.getPeriodStart());
        PayrollEntity.setPeriodEnd(payroll.getPeriodEnd());
        PayrollEntity.setPaymentMethod(payroll.getPaymentMethod());
        PayrollEntity.setPaymentDate(payroll.getPaymentDate());
        PayrollEntity.setEmployee(employee);
        payrollDao.save(PayrollEntity);
        payroll.setId(PayrollEntity.getId());
        //Save items
        List<PayrollDetails> items = payroll.getItems();
        for (PayrollDetails item: items) {
            PayrollDetailEntity detailEntity = payrollDetailDao.getByDate(PayrollEntity.getId(), item.getDate());
            if(detailEntity == null){
                detailEntity = new PayrollDetailEntity();
                detailEntity.setPayrollId(PayrollEntity.getId());
            }
            detailEntity.setDate(item.getDate());
            detailEntity.setRegular(item.getRegular());
            detailEntity.setOt(item.getOt());
            detailEntity.setTardiness(item.getTardiness());
            detailEntity.setVacation(item.getVacation());
            detailEntity.setSick(item.getSick());
            payrollDetailDao.save(detailEntity);
        }
        //Save benefits
        List<PayrollBenefit> benefits = payroll.getBenefits();
        for (PayrollBenefit benefit : benefits) {
            PayrollBenefitEntity benefitEntity = benefitDao.getExistingBenefit(PayrollEntity.getId(), benefit.getDescription());
            if (benefitEntity == null) {
                benefitEntity = new PayrollBenefitEntity();
                benefitEntity.setPayrollId(PayrollEntity.getId());
            }
            benefitEntity.setDescription(benefit.getDescription());
            benefitEntity.setValue(benefit.getValue());
            benefitDao.save(benefitEntity);
        }
        return calculatePays(PayrollEntity.getId());
    }

    @Transactional
    public PayrollEntity saveDeductibles(PayrollDeductible deductible) throws NotFoundException {
        PayrollEntity payroll = payrollDao.findById(deductible.getPayrollId())
                .orElseThrow(() -> new NotFoundException("Cannot save, Payroll not found"));
        saveMandatoryDeduction(deductible.getMandatoryDeductions(), payroll);
        saveOtherDeduction(deductible.getOtherDeductions(), payroll);
        return  payroll;
    }

    @Transactional
    private PayrollEntity calculatePays(long payrollId) throws NotFoundException {
        final int regularHours = 8;
        final double tardinessRate = 0.8;

        PayrollEntity payroll = payrollDao.findById(payrollId)
                .orElseThrow(() -> new NotFoundException("Payroll not found"));

        EmployeeSalaryEntity salary = salaryDao.getSalaryByEmployeeId(payroll.getEmployee().getId());
        if (salary == null) {
            throw new NotFoundException("Employee Salary not found");
        }

        List<HolidayEntity> holidays = holidayDao.getHolidaysBetween(payroll.getPeriodStart(), payroll.getPeriodEnd());

        List<PayrollDetailEntity> details = payrollDetailDao.getByPeriod(payrollId, payroll.getPeriodStart(), payroll.getPeriodEnd());
        if (details.isEmpty()) {
            throw new NotFoundException("Employee Details not found, You may be using the wrong period for payroll and items date");
        }

        double overTimeRate = 0;
        double regularWorkHours = 0;
        double otHours = 0;
        double totalTardiness = 0;
        double vacationDays = 0;
        double sickDays = 0;

        double premiumPay = 0;
        double nonWorkingSpecialPay = 0;

        double regularPay = 0;
        double overTimePay = 0;
        double tardinessDeduction = 0;
        double vacationPay = 0;
        double sickPay = 0;
        double totalBenefit = 0;

        for (PayrollDetailEntity detail: details) {

            Optional<HolidayEntity> holidayOptional = holidays.stream()
                    .filter(h -> h.getDate().equals(detail.getDate()))
                    .findFirst();

            if (holidayOptional.isPresent()) {
                HolidayEntity holiday = holidayOptional.get();

                switch (holiday.getType()) {
                    case 0:
                        premiumPay += calculateRegularPay(regularHours, salary.getDailyBasic() / regularHours);
                        break;
                    case 1:
                        if (hasLeaveTakenOrPresent(detail)) {
                            nonWorkingSpecialPay += calculateRegularPay(detail.getRegular(), salary.getDailyBasic() / regularHours) * 0.30;
                        }
                        break;
                }
                overTimeRate = 0.30;
            } else {
                overTimeRate = 0.25;
            }

            // Calculate Hours
            regularWorkHours += detail.getRegular();
            otHours += detail.getOt();
            totalTardiness += detail.getTardiness();
            vacationDays += detail.getVacation();
            sickDays += detail.getSick();

            // Calculate Pays
            regularPay += calculateRegularPay(detail.getRegular(), salary.getDailyBasic() / regularHours);
            overTimePay += calculateRegularPay(detail.getOt(), salary.getDailyBasic() / regularHours)
                    + calculateOtPay(detail.getOt(), salary.getDailyBasic() / regularHours, overTimeRate);
            tardinessDeduction += calculateTardiness(detail.getTardiness(), salary.getDailyBasic() / regularHours, tardinessRate);
            vacationPay += calculateVacationPay(detail.getVacation(), salary.getDailyBasic());
            sickPay += calculateSickPay(detail.getSick(), salary.getDailyBasic());

            overTimeRate = 0.25;
        }

        List<PayrollBenefitEntity> benefits = benefitDao.getBenefitById(payrollId);
        for (PayrollBenefitEntity benefit : benefits) {
            totalBenefit += benefit.getValue();
        }

        //update payroll
        payroll.setTotalWorkHours(regularWorkHours);
        payroll.setOverTimeRate((salary.getDailyBasic() / regularHours) * overTimeRate);
        payroll.setTotalOtHours(otHours);
        payroll.setTotalTardinessHours(totalTardiness);
        payroll.setTotalVacationDays(vacationDays);
        payroll.setTotalSickDays(sickDays);

        payroll.setRegularPay(formatDecimal(regularPay + premiumPay + nonWorkingSpecialPay));
        payroll.setOverTimePay(formatDecimal(overTimePay));
        payroll.setTardinessDeduction(formatDecimal(tardinessDeduction));
        payroll.setVacationPay(formatDecimal(vacationPay));
        payroll.setSickPay(formatDecimal(sickPay));
        payroll.setTotalBenefit(formatDecimal(totalBenefit));
        payroll.setGrossPay(formatDecimal(regularPay + overTimePay + vacationPay + sickPay + totalBenefit - tardinessDeduction));
        payrollDao.save(payroll);
        return payroll;
    }

    @Transactional
    private void saveMandatoryDeduction(List<MandatoryDeduction> mandatoryDeductions, PayrollEntity payroll) throws NotFoundException {
        double totalMandatoryDeduction = 0;
        double taxableIncome = 0;
        double withholdingTax = 0;
        double incomeExcess = 0;
        double netPay = 0;
        for (MandatoryDeduction mandatoryDeduction : mandatoryDeductions) {
            MandatoryDeductionEntity entity = mandatoryDeductionDao.getExistingMandatoryDeduction(payroll.getId(), mandatoryDeduction.getType());
            if(entity == null) {
                entity = new MandatoryDeductionEntity();
                entity.setPayrollId(payroll.getId());
            }
            entity.setType(mandatoryDeduction.getType());
            entity.setContributionAmount(mandatoryDeduction.getContributionAmount());
            mandatoryDeductionDao.save(entity);

            totalMandatoryDeduction += entity.getContributionAmount();
        }

        taxableIncome = payroll.getGrossPay() - totalMandatoryDeduction;

        payroll.setMandatoryDeductions(formatDecimal(totalMandatoryDeduction));
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
        payrollDao.save(payroll);
    }

    @Transactional
    private void saveOtherDeduction(List<OtherDeduction> deductibles, PayrollEntity payroll) throws NotFoundException {
        double otherDeductions = 0;
        double netPay = payroll.getNetPay();
        for (OtherDeduction deductible : deductibles) {
            OtherDeductionEntity deductibleEntity = otherDeductionDao.getExistingOtherDeduction(payroll.getId(), deductible.getDescription());
            if(deductibleEntity == null) {
                deductibleEntity = new OtherDeductionEntity();
                deductibleEntity.setPayrollId(payroll.getId());
            }
            deductibleEntity.setDescription(deductible.getDescription());
            deductibleEntity.setValue(deductible.getValue());
            otherDeductionDao.save(deductibleEntity);

            otherDeductions += deductibleEntity.getValue();
        }
        payroll.setOtherDeductions(formatDecimal(otherDeductions));
        payroll.setTotalDeductions(formatDecimal(otherDeductions + payroll.getTardinessDeduction() + payroll.getMandatoryDeductions()));
        payroll.setNetPay(formatDecimal(netPay - otherDeductions));
        payrollDao.save(payroll);
    }

    public  PayrollEntity getEmployeePayrollByPeriod(Long empId, LocalDate periodStart, LocalDate periodEnd) {
        return payrollDao.getEmployeePayroll(empId, periodStart, periodEnd);
    }

    public  List<PayrollEntity> getAllEmployeesPayrollByPeriod(LocalDate periodStart, LocalDate periodEnd) {
        return payrollDao.getPayrollByPeriod(periodStart, periodEnd);
    }

    public PayrollSummaryDTO getPayrollSummary(LocalDate periodStart, LocalDate periodEnd) throws NotFoundException {
        List<PayrollEntity> payrolls = payrollDao.getAllEmployeePayrollByPeriod(periodStart, periodEnd);
        if (payrolls.isEmpty()) {
            throw new NotFoundException("Payrolls for this period has not been all reviewed");
        }
        PayrollSummaryDTO payrollSummaryDTO = new PayrollSummaryDTO();
        double withholdingTaxPayable = 0.0;
        double salariesPayable = 0.0;
        double salariesExpense = 0.0;
        Map<String, Double> totalTypeContributionMap = new HashMap<>();
        for (PayrollEntity payroll : payrolls) {
            List<MandatoryDeductionEntity> entities = mandatoryDeductionDao.getAllMandatoryDeductionById(payroll.getId());
            payroll.setMandatory(entities);
            salariesExpense += payroll.getGrossPay();
            withholdingTaxPayable += payroll.getWithholdingTax();
            salariesPayable += payroll.getNetPay();
            for (MandatoryDeductionEntity mandatoryDeduction : payroll.getMandatory()) {
                String benefitType = mandatoryDeduction.getType();
                Double contributionAmount = mandatoryDeduction.getContributionAmount();
                if (totalTypeContributionMap.containsKey("total" + benefitType)) {
                    contributionAmount += totalTypeContributionMap.get("total" + benefitType);
                }
                totalTypeContributionMap.put("total" + benefitType, contributionAmount);
            }
        }
        payrollSummaryDTO.setPeriodStart(periodStart);
        payrollSummaryDTO.setPeriodEnd(periodEnd);
        payrollSummaryDTO.setPayrolls(payrolls);
        payrollSummaryDTO.setWithholdingTaxPayable(withholdingTaxPayable);
        payrollSummaryDTO.setSalariesPayable(salariesPayable);
        payrollSummaryDTO.setSalariesExpense(salariesExpense);
        payrollSummaryDTO.setTotalContributions(totalTypeContributionMap);
        return payrollSummaryDTO;
    }

    private double calculateRegularPay(double hoursWorked, double hourlyRate) {
        return hoursWorked * hourlyRate;
    }

    private double calculateOtPay(double otHours, double hourlyRate, double overTimeRate) {
        return otHours * (hourlyRate * overTimeRate);
    }

    private double calculateTardiness(double tardiness, double hourlyRate, double tardinessRate) {
        return tardiness * (hourlyRate * tardinessRate);
    }

    private double calculateVacationPay(double vacation, double dailyRate) {
        return vacation * dailyRate;
    }

    private double calculateSickPay(double sick, double dailyRate) {
        return sick * dailyRate;
    }

    private boolean hasLeaveTakenOrPresent(PayrollDetailEntity detail) {
        return detail.getRegular() > 0 || detail.getSick() > 0 || detail.getVacation() > 0;
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
