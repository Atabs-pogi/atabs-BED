package com.atabs.atabbe.model;

import java.time.LocalDateTime;

public class ReleaseTransaction {

    private long releaseTransactionId;
    private long farmerId;
    private double totalPrice;
    private long transactionId;
    private double merchandisePrice;
    private LocalDateTime releaseDate;
    private int status;

    public long getReleaseTransactionId() {
        return releaseTransactionId;
    }

    public void setReleaseTransactionId(long releaseTransactionId) {
        this.releaseTransactionId = releaseTransactionId;
    }

    public long getFarmerId() {
        return farmerId;
    }

    public void setFarmerId(long farmerId) {
        this.farmerId = farmerId;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(long transactionId) {
        this.transactionId = transactionId;
    }

    public double getMerchandisePrice() {
        return merchandisePrice;
    }

    public void setMerchandisePrice(double merchandisePrice) {
        this.merchandisePrice = merchandisePrice;
    }

    public LocalDateTime getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDateTime releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
