package com.atabs.atabbe.model;


public class Transaction {

    private long farmerId;
    private long tuxyId;
    private double goodKg;
    private double goodAmount;
    private double discarteKg;
    private double discarteAmount;
    private double resecoKg;
    private double resecoAmount;




    private double totalAmount;

    public long getFarmerId() {
        return farmerId;
    }

    public void setFarmerId(long farmerId) {
        this.farmerId = farmerId;
    }

    public long getTuxyId() {
        return tuxyId;
    }

    public void setTuxyId(long tuxyId) {
        this.tuxyId = tuxyId;
    }

    public double getGoodKg() {
        return goodKg;
    }

    public void setGoodKg(double goodKg) {
        this.goodKg = goodKg;
    }

    public double getGoodAmount() {
        return goodAmount;
    }

    public void setGoodAmount(double goodAmount) {
        this.goodAmount = goodAmount;
    }

    public double getDiscarteKg() {
        return discarteKg;
    }

    public void setDiscarteKg(double discarteKg) {
        this.discarteKg = discarteKg;
    }

    public double getDiscarteAmount() {
        return discarteAmount;
    }

    public void setDiscarteAmount(double discarteAmount) {
        this.discarteAmount = discarteAmount;
    }

    public double getResecoKg() {
        return resecoKg;
    }

    public void setResecoKg(double resecoKg) {
        this.resecoKg = resecoKg;
    }

    public double getResecoAmount() {
        return resecoAmount;
    }

    public void setResecoAmount(double resecoAmount) {
        this.resecoAmount = resecoAmount;
    }


    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }


}