package com.atabs.atabbe.model;

import com.atabs.atabbe.entity.BillsStatementEntity;

import java.time.LocalDateTime;

public class BillsStatement {

    private long id;
    private String type;
    private String name;
    private String dueDate;
    private String paymentDate;
    private String referenceCode;
    private LocalDateTime importDate;

    public static BillsStatement from(BillsStatementEntity billing) {
        BillsStatement billsStatement = new BillsStatement();
        billsStatement.id=billing.getId();
        billsStatement.name=billing.getName();
        billsStatement.type=billing.getType();
        billsStatement.dueDate= billsStatement.getDueDate();
        billsStatement.importDate=billing.getImportDate();
        billsStatement.paymentDate=billing.getPaymentDate();
        billsStatement.referenceCode=billing.getReferenceCode();
        return billsStatement;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
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
