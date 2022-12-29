package com.atabs.atabbe.model;

import com.atabs.atabbe.entity.BillsStatementEntity;

import java.time.LocalDateTime;

public class BillsStatement {

    private long id;
    private String type;
    private String name;
    private String dueDate;
    private LocalDateTime importDate;

    public static BillsStatement from(BillsStatementEntity billing) {
        BillsStatement billsStatement = new BillsStatement();
        billsStatement.id=billing.getId();
        billsStatement.name=billing.getName();
        billsStatement.type=billing.getType();
        billsStatement.dueDate= billsStatement.getDueDate();
        billsStatement.importDate=billing.getImportDate();
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

    public LocalDateTime getImportDate() {
        return importDate;
    }

    public void setImportDate(LocalDateTime importDate) {
        this.importDate = importDate;
    }
}
