package com.atabs.atabbe.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tuxy_price")
public class TuxyItemEntity {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    @Column(name = "priceId")
    private long id;

    private String type;

    private double price;


    public long getPriceId() {
        return id;
    }

    public void setPriceId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}