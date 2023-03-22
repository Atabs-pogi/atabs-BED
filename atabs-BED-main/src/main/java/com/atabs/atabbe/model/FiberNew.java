package com.atabs.atabbe.model;

import com.atabs.atabbe.entity.FiberNewEntity;

import java.time.LocalDateTime;

public class FiberNew {

    private long fiberId;
    private String referenceCode;
    private double excellentFiberKg;
    private double goodFiberKg;
    private double resecoFiberKg;
    private double excellentFiberAmount;
    private double goodFiberAmount;
    private double resecoFiberAmount;
    private double fiberTotalAmount;
    private LocalDateTime dateTime;
    private int status;

    public static FiberNew from(FiberNewEntity fiber) {
        FiberNew fiberNew=new FiberNew();
        fiberNew.fiberId=fiber.getFiberId();
        fiberNew.referenceCode=fiber.getReferenceCode();
        fiberNew.excellentFiberKg=fiber.getExcellentFiberKg();
        fiberNew.excellentFiberAmount=fiber.getExcellentFiberAmount();
        fiberNew.goodFiberKg=fiber.getGoodFiberKg();
        fiberNew.goodFiberAmount=fiber.getGoodFiberAmount();
        fiberNew.resecoFiberKg=fiber.getResecoFiberKg();
        fiberNew.resecoFiberAmount=fiber.getResecoFiberAmount();
        fiberNew.status=fiber.getStatus();
        fiberNew.dateTime=fiber.getDateTime();
        fiberNew.fiberTotalAmount=fiber.getFiberTotalAmount();

        return fiberNew;

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


    public double totalAmount(){
        return getExcellentFiberAmount()+getGoodFiberAmount()+getResecoFiberAmount();
    }
}
