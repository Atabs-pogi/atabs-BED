package com.atabs.atabbe.model;

import com.atabs.atabbe.entity.BirTaxEntity;
import com.atabs.atabbe.entity.PayrollDetailEntity;

import javax.persistence.Transient;
import java.time.LocalDate;
import java.util.List;

public class Payroll {

    private long id;
    private LocalDate periodStart;
    private LocalDate periodEnd;
    private String paymentMethod; //  (e.g., direct deposit, check)
    private LocalDate paymentDate;
    private long employeeId;
    private List<PayrollDetails> items;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public List<PayrollDetails> getItems() {
        return items;
    }

    public void setItems(List<PayrollDetails> items) {
        this.items = items;
    }
}
