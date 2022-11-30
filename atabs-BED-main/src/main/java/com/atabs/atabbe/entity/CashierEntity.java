package com.atabs.atabbe.entity;


import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "cashier")
public class CashierEntity {
    @Id
    @GeneratedValue(generator = "cashier_seq", strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name = "cashier_seq", sequenceName = "cashier_sequence", initialValue = 101, allocationSize = 10000000)
    @Column(name = "cashierId")
    private long cashierId;
    private long farmerId;

    private long transactionId;
    private double cashierTotal;
    private double merchandisePrice;
    private LocalDateTime cashierDate;

    @PrePersist
    protected void onCreate() {
        cashierDate = LocalDateTime.now();
    }

    public Long getCashierId() {
        return cashierId;
    }

    public void setCashierId(Long cashierId) {
        this.cashierId = cashierId;
    }

    public Long getFarmerId() {
        return farmerId;
    }

    public void setFarmerId(Long farmerId) {
        this.farmerId = farmerId;
    }

    public void setCashierId(long cashierId) {
        this.cashierId = cashierId;
    }

    public void setFarmerId(long farmerId) {
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
}
