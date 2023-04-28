package com.atabs.atabbe.model;

import com.atabs.atabbe.entity.BillsStatementEntity;

import java.time.LocalDateTime;

public class BillsStatement {

    private long id;
    private String vendorName;
    private String accountNumber;
    private String billType;
    private LocalDateTime timeCreated;
    private String referenceCode;
    private LocalDateTime importDate;

    public static BillsStatement from(BillsStatementEntity billing) {
        BillsStatement billsStatement = new BillsStatement();
        billsStatement.id=billing.getId();
        billsStatement.vendorName=billing.getVendorName();
        billsStatement.accountNumber=billing.getAccountNumber();
        billsStatement.billType=billing.getBillType();
        billsStatement.timeCreated=billing.getTimeCreated();
        billsStatement.referenceCode=billing.getReferenceCode();
        billsStatement.importDate=billing.getImportDate();
        return billsStatement;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getBillType() {
        return billType;
    }

    public void setBillType(String billType) {
        this.billType = billType;
    }

    public LocalDateTime getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(LocalDateTime timeCreated) {
        this.timeCreated = timeCreated;
    }

    public String getReferenceCode() {
        return referenceCode;
    }

    public void setReferenceCode(String referenceCode) {
        this.referenceCode = referenceCode;
    }

    public LocalDateTime getImportDate() {
        return importDate;
    }

    public void setImportDate(LocalDateTime importDate) {
        this.importDate = importDate;
    }
}