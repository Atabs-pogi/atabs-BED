package com.atabs.atabbe.model;

import java.time.LocalDate;

public class PayrollDetails {

    private long id;
    private LocalDate date;
    private float regular;
    private float ot;
    private float tardiness;
    private float vacation;
    private float sick;
    private long payrollId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public float getRegular() {
        return regular;
    }

    public void setRegular(float regular) {
        this.regular = regular;
    }

    public float getOt() {
        return ot;
    }

    public void setOt(float ot) {
        this.ot = ot;
    }

    public float getTardiness() {
        return tardiness;
    }

    public void setTardiness(float tardiness) {
        this.tardiness = tardiness;
    }

    public float getVacation() {
        return vacation;
    }

    public void setVacation(float vacation) {
        this.vacation = vacation;
    }

    public float getSick() {
        return sick;
    }

    public void setSick(float sick) {
        this.sick = sick;
    }

    public long getPayrollId() {
        return payrollId;
    }

    public void setPayrollId(long payrollId) {
        this.payrollId = payrollId;
    }
}
