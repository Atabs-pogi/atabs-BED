package com.atabs.atabbe.model;

import java.time.LocalDate;
import java.util.List;

public class Payroll {

    private long id;
    private float baseSalary;
    private LocalDate periodStart;
    private LocalDate periodEnd;
    private long employeeId;
    private List<PayrollDetails> items;
    private List<PayrollDeductible> payrollDeductibles;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public float getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(float baseSalary) {
        this.baseSalary = baseSalary;
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
