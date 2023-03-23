package com.atabs.atabbe.model;

import java.time.LocalDate;

public class EmployeeSalary {
    private long id;
    private LocalDate effDate;
    private LocalDate expDate;
    private String position;
    private double dailyBasic; // For minimum wager
    private double monthlyBasic; // For above minimum wager
    private String bankAccountInfo; //  (e.g., account number, routing number) for direct deposit
    private String taxInfo; // (e.g., BIR account number, routing number) for direct deposit
    private long employeeId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getEffDate() {
        return effDate;
    }

    public void setEffDate(LocalDate effDate) {
        this.effDate = effDate;
    }

    public LocalDate getExpDate() {
        return expDate;
    }

    public void setExpDate(LocalDate expDate) {
        this.expDate = expDate;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
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

    public String getBankAccountInfo() {
        return bankAccountInfo;
    }

    public void setBankAccountInfo(String bankAccountInfo) {
        this.bankAccountInfo = bankAccountInfo;
    }

    public String getTaxInfo() {
        return taxInfo;
    }

    public void setTaxInfo(String taxInfo) {
        this.taxInfo = taxInfo;
    }

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }
}
