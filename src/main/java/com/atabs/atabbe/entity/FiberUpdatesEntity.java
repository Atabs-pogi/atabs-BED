package com.atabs.atabbe.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "fiberUpdates")
public class FiberUpdatesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fiberUpdatesId")
    private long fiberUpdatesId;
    private double previousPrice;
    private double updatePrice;
    @Column(name = "updateDate", nullable = false, updatable = false)
    @CreationTimestamp
    private Date updateDate;
    private long fiberId;

    public long getId() {
        return fiberUpdatesId;
    }

    public void setId(long fiberUpdatesId) {
        this.fiberUpdatesId = fiberUpdatesId;
    }

    public double getPreviousPrice() {
        return previousPrice;
    }

    public void setPreviousPrice(double previousPrice) {
        this.previousPrice = previousPrice;
    }

    public double getUpdatePrice() {
        return updatePrice;
    }

    public void setUpdatePrice(double updatePrice) {
        this.updatePrice = updatePrice;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public long getFiberId() {
        return fiberId;
    }

    public void setFiberId(long fiberId) {
        this.fiberId = fiberId;
    }
}
