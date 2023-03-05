package com.atabs.atabbe.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "bills")
public class BillsStatementEntity {

    @Id
    @GeneratedValue(generator = "bills_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "bills_seq", sequenceName = "bills_sequence", initialValue = 101, allocationSize = 50)
    @Column(name = "id")
    private long id;
    private String type;
    private String name;
    private String dueDate;
    private String paymentDate;
    private String referenceCode;
    private LocalDateTime importDate;

    @PrePersist
    protected void onCreate() {
        importDate = LocalDateTime.now();
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