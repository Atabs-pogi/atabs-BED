package com.atabs.atabbe.dto;

import com.atabs.atabbe.entity.PayrollEntity;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class PayrollSummaryDTO {
    private LocalDate periodStart;
    private LocalDate periodEnd;
    private Map<String, Double> TotalContributions;
    private double salariesExpense;
    private double withholdingTaxPayable;
    private double SalariesPayable;
    private List<PayrollEntity> payrolls;

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

    public Map<String, Double> getTotalContributions() {
        return TotalContributions;
    }

    public void setTotalContributions(Map<String, Double> totalContributions) {
        TotalContributions = totalContributions;
    }

    public double getSalariesExpense() {
        return salariesExpense;
    }

    public void setSalariesExpense(double salariesExpense) {
        this.salariesExpense = salariesExpense;
    }

    public double getWithholdingTaxPayable() {
        return withholdingTaxPayable;
    }

    public void setWithholdingTaxPayable(double withholdingTaxPayable) {
        this.withholdingTaxPayable = withholdingTaxPayable;
    }

    public double getSalariesPayable() {
        return SalariesPayable;
    }

    public void setSalariesPayable(double salariesPayable) {
        SalariesPayable = salariesPayable;
    }

    public List<PayrollEntity> getPayrolls() {
        return payrolls;
    }

    public void setPayrolls(List<PayrollEntity> payrolls) {
        this.payrolls = payrolls;
    }
}
