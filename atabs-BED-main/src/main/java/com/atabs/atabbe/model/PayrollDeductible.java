package com.atabs.atabbe.model;

import java.util.List;

public class PayrollDeductible {
    private long payrollId;
    private String frequency;
    private List<MandatoryDeduction> mandatoryDeductions;
    private List<OtherDeduction> otherDeductions;

    public long getPayrollId() {
        return payrollId;
    }

    public void setPayrollId(long payrollId) {
        this.payrollId = payrollId;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public List<MandatoryDeduction> getMandatoryDeductions() {
        return mandatoryDeductions;
    }

    public void setMandatoryDeductions(List<MandatoryDeduction> mandatoryDeductions) {
        this.mandatoryDeductions = mandatoryDeductions;
    }

    public List<OtherDeduction> getOtherDeductions() {
        return otherDeductions;
    }

    public void setOtherDeductions(List<OtherDeduction> otherDeductions) {
        this.otherDeductions = otherDeductions;
    }
}
