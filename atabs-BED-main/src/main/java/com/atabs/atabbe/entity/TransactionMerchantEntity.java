package com.atabs.atabbe.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "transaction_merchant")
public class TransactionMerchantEntity {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    @Column(name = "transMerchantId")
    private long id;
    private long farmerId;
    private long cashierId;
    private double totalItem;
    private double totalAmount;
    private double payment;
    private double amountChange;

    @Column(name = "status", nullable = false, columnDefinition = "INT NOT NULL DEFAULT 1")
    private int status = 1;


    @OneToMany(targetEntity = TransactionMerchantItemEntity.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "transMerchantId" ,referencedColumnName ="transMerchantId" )
    private List<TransactionMerchantItemEntity> items;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getFarmerId() {
        return farmerId;
    }

    public void setFarmerId(long farmerId) {
        this.farmerId = farmerId;
    }

    public long getCashierId() {
        return cashierId;
    }

    public void setCashierId(long cashierId) {
        this.cashierId = cashierId;
    }

    public double getTotalItem() {
        return totalItem;
    }

    public void setTotalItem(double totalItem) {
        this.totalItem = totalItem;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public double getPayment() {
        return payment;
    }

    public void setPayment(double payment) {
        this.payment = payment;
    }

    public double getAmountChange() {
        return amountChange;
    }

    public void setAmountChange(double amountChange) {
        this.amountChange = amountChange;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<TransactionMerchantItemEntity> getItems() {
        return items;
    }

    public void setItems(List<TransactionMerchantItemEntity> items) {
        this.items = items;
    }

}
