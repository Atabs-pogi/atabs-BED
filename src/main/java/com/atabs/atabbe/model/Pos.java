package com.atabs.atabbe.model;

import com.atabs.atabbe.entity.PosEntity;

import java.time.LocalDateTime;
import java.util.List;

public class Pos {


    private List<Pos> bulkTransaction;
    private long transactionsId;
    private String plantName;
    private String plantGrade;
    private double plantPrice;
    private double plantKilogram;
    private double plantTotal;
    private String farmerId;

    private LocalDateTime transactionDate;
    private LocalDateTime updateDate;

    public List<Pos> getBulkTransaction() {
        return bulkTransaction;
    }

    public void setBulkTransaction(List<Pos> bulkTransaction) {
        this.bulkTransaction = bulkTransaction;
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

    public String getFarmerId() {
        return farmerId;
    }

    public void setFarmerId(String farmerId) {
        this.farmerId = farmerId;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDateTime transactionDate) {
        this.transactionDate = transactionDate;
    }



    public static Pos from(PosEntity entity) {
        Pos pos = new Pos();
        pos.transactionsId = entity.getTransactionsId();
        pos.plantName = entity.getPlantName();
        pos.plantGrade = entity.getPlantGrade();
        pos.plantKilogram = entity.getPlantKilogram();
        pos.plantPrice = entity.getPlantPrice();
        pos.plantTotal = entity.getPlantTotal();
        pos.farmerId = entity.getFarmerId();
        pos.transactionDate = entity.getTransactionDate();
        return pos;
    }
}

