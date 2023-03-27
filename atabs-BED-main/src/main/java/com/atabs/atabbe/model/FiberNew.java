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

    private double excellentFiberAmount;
    private double goodFiberAmount;
    private double resecoFiberAmount;
    private double fiberTotalAmount;

    private double excellentOrCode;
    private double goodOrCode;
    private double resecoOrCode;
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

    public double getExcellentOrCode() {
        return excellentOrCode;
    }

    public void setExcellentOrCode(double excellentOrCode) {
        this.excellentOrCode = excellentOrCode;
    }

    public double getGoodOrCode() {
        return goodOrCode;
    }

    public void setGoodOrCode(double goodOrCode) {
        this.goodOrCode = goodOrCode;
    }

    public double getResecoOrCode() {
        return resecoOrCode;
    }

    public void setResecoOrCode(double resecoOrCode) {
        this.resecoOrCode = resecoOrCode;
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
