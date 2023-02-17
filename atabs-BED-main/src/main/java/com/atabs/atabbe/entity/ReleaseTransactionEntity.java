package com.atabs.atabbe.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "releasetransaction")
public class ReleaseTransactionEntity {
    @Id
    @GeneratedValue(generator = "release_seq", strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name = "release_seq", sequenceName = "release_transaction_sequence", initialValue = 101, allocationSize = 50)
    @Column(name = "release_transaction_id")

    private long releaseTransactionId;
    private long farmerId;
    private double totalPrice;
    private long transactionId;
    private double merchandisePrice;
    private LocalDateTime releaseDate;
    @Column(name = "status", nullable = false, columnDefinition = "INT NOT NULL DEFAULT 1")
    private int status;

    @PrePersist
    protected void onCreate() {
        releaseDate = LocalDateTime.now();
    }

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
