package com.atabs.atabbe.model;


public class UpdateTuxy {


    private long tuxyId;
    private String type;
    private double oldPrice;
    private double newPrice;


    public long getTuxyId() {
        return tuxyId;
    }

    public void setTuxyId(long tuxyId) {
        this.tuxyId = tuxyId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(double oldPrice) {
        this.oldPrice = oldPrice;
    }

    public double getNewPrice() {
        return newPrice;
    }

    public void setNewPrice(double newPrice) {
        this.newPrice = newPrice;
    }
}