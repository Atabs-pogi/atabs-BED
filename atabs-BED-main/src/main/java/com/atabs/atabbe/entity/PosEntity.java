package com.atabs.atabbe.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "transactionss")
public class PosEntity {
    @Id
    @GeneratedValue(generator = "pos_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "pos_seq", sequenceName = "pos_sequence", initialValue = 101, allocationSize = 10000000)
    @Column(name = "transactionsId")
    private long transactionsId;
    private String plantName;
    private String plantGrade;
    private String farmerId;
    private double plantPrice;
    private double plantKilogram;
    private double plantTotal;
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

    public String getPlantName() {
        return plantName;
    }

    public void setPlantName(String plantName) {
        this.plantName = plantName;
    }

    public String getPlantGrade() {
        return plantGrade;
    }

    public String getFarmerId() {
        return farmerId;
    }

    public void setFarmerId(String farmerId) {
        this.farmerId = farmerId;
    }


    public void setPlantGrade(String plantGrade) {
        this.plantGrade = plantGrade;
    }

    public double getPlantPrice() {
        return plantPrice;
    }

    public void setPlantPrice(double plantPrice) {
        this.plantPrice = plantPrice;
    }

    public double getPlantKilogram() {
        return plantKilogram;
    }

    public void setPlantKilogram(double plantKilogram) {
        this.plantKilogram = plantKilogram;
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
}
