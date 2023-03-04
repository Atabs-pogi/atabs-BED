package com.atabs.atabbe.model;

import com.atabs.atabbe.entity.BirTaxEntity;
import com.atabs.atabbe.entity.PayrollDetailEntity;

import javax.persistence.Transient;
import java.time.LocalDate;
import java.util.List;

public class Payroll {

    private long id;
    private double dailyBasic; // For minimum wager
    private double monthlyBasic; // For above minimum wager
    private LocalDate periodStart;
    private LocalDate periodEnd;
    private String paymentMethod; //  (e.g., direct deposit, check)
    private LocalDate paymentDate;
    private long employeeId;
    private  double regularPay;
    private double overTimePay;
    private double tardinessDeduction;
    private  double vacationPay;
    private  double sickPay;
    private double grossPay;
    private double totalBenefitContributions;
    private double taxableIncome;
    private double totalDeductions;
    private double withholdingTax;
    private double netPay;
    private List<PayrollDetails> items;
    private List<PayrollBenefit> benefits;
    private List<PayrollDeductible> deductibles;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getDailyBasic() {
        return dailyBasic;
    }

    public void setDailyBasic(double dailyBasic) {
        this.dailyBasic = dailyBasic;
    }

    public double getMonthlyBasic() {
        return monthlyBasic;
    }

    public void setMonthlyBasic(double monthlyBasic) {
        this.monthlyBasic = monthlyBasic;
    }

    public LocalDate getPeriodStart() {
        return periodStart;
    }

    public void setPeriodStart(LocalDate periodStart) {
        this.periodStart = periodStart;
    }

    public LocalDate getPeriodEnd() {
        return periodEnd;
    }

    public void setPeriodEnd(LocalDate periodEnd) {
        this.periodEnd = periodEnd;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public LocalDate getPaymentDate() {
        if (this.paymentDate == null) {
            this.paymentDate = LocalDate.now();
        }
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    public double getRegularPay() {
        double regularPay = 0;
        double hourlyRate = this.getDailyBasic() / 8;
        for (PayrollDetails item: items) {
            regularPay += item.getRegular() * hourlyRate;
        }
        return regularPay;
    }

    public double getOverTimePay() {
        double overTimePay = 0;
        double overTimeRate = (this.getDailyBasic()  / 8) * 1.25;
        for (PayrollDetails item: items) {
            overTimePay += item.getOt() * overTimeRate;
        }
        return overTimePay;
    }

    public double getTardinessDeduction() {
        double tardinessDeduction = 0;
        double tardinessRate = 50;
        for (PayrollDetails item: items) {
            tardinessDeduction += tardinessRate * item.getTardiness();
        }
        return tardinessDeduction;
    }

    public double getVacationPay() {
        double vacationPay = 0;
        for (PayrollDetails item: items) {
            vacationPay += this.getDailyBasic() * item.getVacation();
        }
        return vacationPay;
    }

    public double getSickPay() {
        double sickPay = 0;
        for (PayrollDetails item: items) {
            sickPay += this.getDailyBasic() * item.getSick();
        }
        return sickPay;
    }

    public double getGrossPay() {
        double grossPay = 0;
        grossPay = this.getRegularPay() + this.getOverTimePay() + this.getVacationPay() + this.getSickPay() - this.getTardinessDeduction();
        return grossPay;
    }

    public double getTotalBenefitContributions() {
        double totalBenefitContributions = 0;
        for (PayrollBenefit benefit: benefits) {
            totalBenefitContributions += benefit.getContributionAmount();
        }
        return totalBenefitContributions;
    }

    public double getTaxableIncome() {
        double taxableIncome = 0;
        taxableIncome = this.getGrossPay() - this.getTotalBenefitContributions();
        return taxableIncome;
    }

    public double getTotalDeductions() {
        double totalDeductions = 0;
        for (PayrollDeductible deductible: deductibles) {
            totalDeductions += deductible.getValue();
        }
        return totalDeductions;
    }

    public double getWithholdingTax() {
        return withholdingTax;
    }

    public void setWithholdingTax(double withholdingTax) {
        this.withholdingTax = withholdingTax;
    }

    public double getNetPay() {
        return netPay;
    }

    public void setNetPay(double netPay) {
        this.netPay = netPay;
    }

    public List<PayrollDetails> getItems() {
        return items;
    }

    public void setItems(List<PayrollDetails> items) {
        this.items = items;
    }

    public List<PayrollBenefit> getBenefits() {
        return benefits;
    }

    public void setBenefits(List<PayrollBenefit> benefits) {
        this.benefits = benefits;
    }

    public List<PayrollDeductible> getDeductibles() {
        return deductibles;
    }

    public void setDeductibles(List<PayrollDeductible> deductibles) {
        this.deductibles = deductibles;
    }
}
