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
    private String vendorName;
    private String accountNumber;
    private String billType;
    private String referenceCode;
    private LocalDateTime timeCreated;

    @PrePersist
    protected void onCreate() {
        timeCreated = LocalDateTime.now();
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

    public String getReferenceCode() {
        return referenceCode;
    }

    public void setReferenceCode(String referenceCode) {
        this.referenceCode = referenceCode;
    }

    public LocalDateTime getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(LocalDateTime timeCreated) {
        this.timeCreated = timeCreated;
    }
}