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
    private long employeeId;
    private  double regularPay;
    private double overTimePay;
    private double tardinessDeduction;
    private  double vacationPay;
    private  double sickPay;
    private double grossPay;
    private double totalDeductions;
    private double taxableIncome;
    private double withholdingTax;
    private double netPay;
    private List<PayrollDetails> items;
    private List<PayrollDeductible> payrollDeductibles;

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

    public double getTotalDeductions() {
        double totalDeductions = 0;
        for (PayrollDeductible deductible: payrollDeductibles) {
            totalDeductions += deductible.getValue();
        }
        return totalDeductions;
    }

    public double getTaxableIncome() {
        double taxableIncome = 0;
        taxableIncome = this.getGrossPay() - this.getTotalDeductions();
        return taxableIncome;
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

    public List<PayrollDeductible> getDeductibles() {
        return payrollDeductibles;
    }

    public void setDeductibles(List<PayrollDeductible> payrollDeductibles) {
        this.payrollDeductibles = payrollDeductibles;
    }
}
