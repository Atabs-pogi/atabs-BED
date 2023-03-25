package com.atabs.atabbe.model;

import com.atabs.atabbe.entity.FiberNewEntity;

import java.time.LocalDateTime;

public class FiberNew {

    private long fiberId;
    private String referenceCode;
    private double excellentFiberKg;
    private double goodFiberKg;
    private double resecoFiberKg;
    private double excellentFiberPrice;
    private double goodFiberPrice;
    private double resecoFiberPrice;
    //private double fiberTotalAmount;
    private LocalDateTime dateTime;
    private int status;

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

    public double getExcellentFiberPrice() {
        return excellentFiberPrice;
    }

    public void setExcellentFiberPrice(double excellentFiberPrice) {
        this.excellentFiberPrice = excellentFiberPrice;
    }

    public double getGoodFiberPrice() {
        return goodFiberPrice;
    }

    public void setGoodFiberPrice(double goodFiberPrice) {
        this.goodFiberPrice = goodFiberPrice;
    }

    public double getResecoFiberPrice() {
        return resecoFiberPrice;
    }

    public void setResecoFiberPrice(double resecoFiberPrice) {
        this.resecoFiberPrice = resecoFiberPrice;
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
