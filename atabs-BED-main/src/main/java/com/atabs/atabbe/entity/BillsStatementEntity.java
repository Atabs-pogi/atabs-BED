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
    private String accountNo;
    private String Amount;
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

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getAmount() {
        return Amount;
    }

    public void setAmount(String amount) {
        Amount = amount;
    }

    public LocalDateTime getImportDate() {
        return importDate;
    }

    public void setImportDate(LocalDateTime importDate) {
        this.importDate = importDate;
    }
}
