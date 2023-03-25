package com.atabs.atabbe.entity;

import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.*;

@Entity
@Table(name = "fiber_price")
public class FiberPricesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fiberPriceId")
    private long id;
    private double excellentFiberPrice;
    private double goodFiberPrice;
    private double resecoFiberPrice;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
}
