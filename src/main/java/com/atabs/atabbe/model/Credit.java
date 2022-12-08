package com.atabs.atabbe.model;

import com.atabs.atabbe.entity.CreditEntity;
import com.atabs.atabbe.entity.PosEntity;

import java.time.LocalDateTime;

public class Credit {

    private long balanceId;
    private double balance;

    private double credit;
    private String cashierName;
    private Long cashierId;
    private LocalDateTime insertBalanceDate;


    public long getBalanceId() {
        return balanceId;
    }

    public void setBalanceI(long balanceI) {
        this.balanceId = balanceI;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setBalanceId(long balanceId) {
        this.balanceId = balanceId;
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    public Long getCashierId() {
        return cashierId;
    }

    public String getCashierName() {
        return cashierName;
    }

    public void setCashierName(String cashierName) {
        this.cashierName = cashierName;
    }

    public Long getCashiedId() {
        return cashierId;
    }

    public void setCashierId(Long cashierId) {
        this.cashierId = cashierId;
    }

    public LocalDateTime getInsertBalanceDate() {
        return insertBalanceDate;
    }

    public void setInsertBalanceDate(LocalDateTime insertBalanceDate) {
        this.insertBalanceDate = insertBalanceDate;
    }

    public static Credit from(CreditEntity entity) {
        Credit credit = new Credit();
        credit.balanceId = entity.getBalanceId();
        credit.balance = entity.getBalance();
        credit.cashierId = entity.getCashierId();
        credit.cashierName = entity.getCashierName();
        credit.insertBalanceDate = entity.getInsertBalanceDate();
        return credit;
    }
}
