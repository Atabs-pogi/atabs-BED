package com.atabs.atabbe.model;

public class PayrollBenefit {
    private long id;
    private String benefitType; // (e.g., SSS, Philhealth, Pag-IBIG Fund)
    private double contributionAmount;
    private long payrollId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBenefitType() {
        return benefitType;
    }

    public void setBenefitType(String benefitType) {
        this.benefitType = benefitType;
    }

    public double getContributionAmount() {
        return contributionAmount;
    }

    public void setContributionAmount(double contributionAmount) {
        this.contributionAmount = contributionAmount;
    }

    public long getPayrollId() {
        return payrollId;
    }

    public void setPayrollId(long payrollId) {
        this.payrollId = payrollId;
    }
}
