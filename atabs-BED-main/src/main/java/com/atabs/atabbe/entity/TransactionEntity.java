package com.atabs.atabbe.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "transactionss")
public class TransactionEntity {


    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long transactionsId;

    private String farmerId;

    private double plantTotal;


    @OneToMany(targetEntity = TransactionItemEntity.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "transactionsId" ,referencedColumnName ="id" )
    private List<TransactionItemEntity> items;

//    @OneToMany(targetEntity = Contact.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @JoinColumn(name = "transactionsId" ,referencedColumnName ="id" )
//    private List<TransactionItemEntity> contacts;

    private LocalDateTime transactionDate;
    private LocalDateTime updateDate;



    @PrePersist
    protected void onCreate() {
        transactionDate = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updateDate = LocalDateTime.now();
    }

    public long getTransactionsId() {
        return transactionsId;
    }

    public void setTransactionsId(long transactionsId) {
        this.transactionsId = transactionsId;
    }

    public String getFarmerId() {
        return farmerId;
    }

    public void setFarmerId(String farmerId) {
        this.farmerId = farmerId;
    }

    public double getPlantTotal() {
        return plantTotal;
    }

    public void setPlantTotal(double plantTotal) {
        this.plantTotal = plantTotal;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDateTime transactionDate) {
        this.transactionDate = transactionDate;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }

    public List<TransactionItemEntity> getItems() {
        return items;
    }

    public void setItems(ArrayList<TransactionItemEntity> items) {
        this.items = items;
    }
}
