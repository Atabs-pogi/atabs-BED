package com.atabs.atabbe.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "fibernew")
public class FiberNewEntity {
    @Id
    @GeneratedValue(generator = "fibernew_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "fibernew_seq", sequenceName = "fibernew_sequence", initialValue = 101,allocationSize = 50)
    @Column(name = "fiberId")
    private long fiberId;
    private String referenceCode;
    private double excellentFiberKg;
    private double goodFiberKg;
    private double resecoFiberKg;
    private double excellentFiberAmount;
    private double goodFiberAmount;
    private double resecoFiberAmount;
    private double fiberTotalAmount;

    @Column(name = "status", nullable = false, columnDefinition = "INT NOT NULL DEFAULT 1")
    private int status = 1;
    private LocalDateTime dateTime;

    @PrePersist
    protected void onCreate() {
        dateTime = LocalDateTime.now();
    }

    public long getFiberId() {
        return fiberId;
    }

    public void setFiberId(long fiberId) {
        this.fiberId = fiberId;
    }

    public String getReferenceCode() {
        return referenceCode;
    }

    public void setReferenceCode(String referenceCode) {
        this.referenceCode = referenceCode;
    }

    public double getExcellentFiberKg() {
        return excellentFiberKg;
    }

    public void setExcellentFiberKg(double excellentFiberKg) {
        this.excellentFiberKg = excellentFiberKg;
    }

    public double getGoodFiberKg() {
        return goodFiberKg;
    }

    public void setGoodFiberKg(double goodFiberKg) {
        this.goodFiberKg = goodFiberKg;
    }

    public double getResecoFiberKg() {
        return resecoFiberKg;
    }

    public void setResecoFiberKg(double resecoFiberKg) {
        this.resecoFiberKg = resecoFiberKg;
    }

    public double getExcellentFiberAmount() {
        return excellentFiberAmount;
    }

    public void setExcellentFiberAmount(double excellentFiberAmount) {
        this.excellentFiberAmount = excellentFiberAmount;
    }

    public double getGoodFiberAmount() {
        return goodFiberAmount;
    }

    public void setGoodFiberAmount(double goodFiberAmount) {
        this.goodFiberAmount = goodFiberAmount;
    }

    public double getResecoFiberAmount() {
        return resecoFiberAmount;
    }

    public void setResecoFiberAmount(double resecoFiberAmount) {
        this.resecoFiberAmount = resecoFiberAmount;
    }

    public double getFiberTotalAmount() {
        return fiberTotalAmount;
    }

    public void setFiberTotalAmount(double fiberTotalAmount) {
        this.fiberTotalAmount = fiberTotalAmount;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
