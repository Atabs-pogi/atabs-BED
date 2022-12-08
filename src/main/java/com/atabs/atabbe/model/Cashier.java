package com.atabs.atabbe.model;

import com.atabs.atabbe.entity.CashierEntity;

import javax.persistence.PrePersist;
import java.time.LocalDateTime;

public class Cashier {

    private long cashierId;
    private long farmerId;
    private long transactionId;
    private double cashierTotal;
    private double merchandisePrice;
    private LocalDateTime cashierDate;

    public long getCashierId() {
        return cashierId;
    }

    public void setCashierId(Long cashierId) {
        this.cashierId = cashierId;
    }

    public long getFarmerId() {
        return farmerId;
    }

    public void setFarmerId(Long farmerId) {
        this.farmerId = farmerId;
    }

    public long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(long transactionId) {
        this.transactionId = transactionId;
    }

    public double getCashierTotal() {
        return cashierTotal;
    }

    public void setCashierTotal(double cashierTotal) {
        this.cashierTotal = cashierTotal;
    }

    public double getMerchandisePrice() {
        return merchandisePrice;
    }

    public void setMerchandisePrice(double merchandisePrice) {
        this.merchandisePrice = merchandisePrice;
    }

    public LocalDateTime getCashierDate() {
        return cashierDate;
    }

    public void setCashierDate(LocalDateTime cashierDate) {
        this.cashierDate = cashierDate;
    }

    public static Cashier from(CashierEntity entity) {
        Cashier cashier = new Cashier();
        cashier.cashierId = entity.getCashierId();
        cashier.transactionId=entity.getTransactionId();
        cashier.cashierDate = entity.getCashierDate();
        cashier.farmerId = entity.getFarmerId();
        cashier.merchandisePrice = entity.getMerchandisePrice();
        return cashier;
    }


}
