package com.atabs.atabbe.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "tuxy")
public class TuxyEntity {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long tuxyId;

    private String name;

    private double goodPrice;
    private double discardedPrice;
    private double resecoPrice;




    @Column(name="status", nullable = false, columnDefinition="INT NOT NULL DEFAULT 1")
    private int status = 1;
    private LocalDateTime createDate;

    @PrePersist
    protected void onCreate() {
        createDate = LocalDateTime.now();
    }

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


    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }



    public double getGoodPrice() {
        return goodPrice;
    }

    public void setGoodPrice(double goodPrice) {
        this.goodPrice = goodPrice;
    }

    public double getDiscardedPrice() {
        return discardedPrice;
    }

    public void setDiscardedPrice(double discardedPrice) {
        this.discardedPrice = discardedPrice;
    }

    public double getResecoPrice() {
        return resecoPrice;
    }

    public void setResecoPrice(double resecoPrice) {
        this.resecoPrice = resecoPrice;
    }
}
