package com.atabs.atabbe.model;

import javax.persistence.*;
import java.time.LocalDateTime;

public class Tuxy {

    private long tuxyId;
    private String name;
    private double goodPrice;
    private double discartePrice;
    private double resecoPrice;

    public long getTuxyId() {
        return tuxyId;
    }

    public void setTuxyId(long tuxyId) {
        this.tuxyId = tuxyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGoodPrice() {
        return goodPrice;
    }

    public void setGoodPrice(double goodPrice) {
        this.goodPrice = goodPrice;
    }

    public double getDiscartePrice() {
        return discartePrice;
    }

    public void setDiscartePrice(double discartePrice) {
        this.discartePrice = discartePrice;
    }

    public double getResecoPrice() {
        return resecoPrice;
    }

    public void setResecoPrice(double resecoPrice) {
        this.resecoPrice = resecoPrice;
    }
}
