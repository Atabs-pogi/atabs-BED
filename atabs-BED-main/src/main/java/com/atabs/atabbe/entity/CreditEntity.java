package com.atabs.atabbe.entity;


import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "credit")
public class CreditEntity {

    @Id
    @GeneratedValue(generator = "credit_seq", strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name = "credit_seq", sequenceName = "credit_sequence", initialValue = 101, allocationSize = 50)
    @Column(name = "balanceId")
    private long balanceId;
    private double balance;
    private double credit;
    private String cashierName;
    private Long cashierId;
    private LocalDateTime insertBalanceDate;

    @PrePersist

    protected void onCreate() {
        insertBalanceDate = LocalDateTime.now();
    }

    public long getBalanceId() {
        return balanceId;
    }

    public void setBalanceId(long balanceId) {
        this.balanceId = balanceId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    public String getCashierName() {
        return cashierName;
    }

    public void setCashierName(String cashierName) {
        this.cashierName = cashierName;
    }

    public Long getCashierId() {
        return cashierId;
    }

    public void setCashierId(Long cashiedId) {
        this.cashierId = cashiedId;
    }

    public LocalDateTime getInsertBalanceDate() {
        return insertBalanceDate;
    }

    public void setInsertBalanceDate(LocalDateTime insertBalanceDate) {
        this.insertBalanceDate = insertBalanceDate;
    }



}
