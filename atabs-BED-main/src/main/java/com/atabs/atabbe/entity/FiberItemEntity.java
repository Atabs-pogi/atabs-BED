package com.atabs.atabbe.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "fiber_items")
public class FiberItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "fiberItemId")
    private long fiberItemId;

    private String grade;

    private String strippingCleaning;

    private double knifeUsed;

    private double price;


    @Column(name="status", nullable = false, columnDefinition="INT NOT NULL DEFAULT 1")
    private int status = 1;

    private LocalDateTime createDate;

    public long getFiberItemId() {
        return fiberItemId;
    }

    public void setFiberItemId(long fiberItemId) {
        this.fiberItemId = fiberItemId;
    }



    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getStrippingCleaning() {
        return strippingCleaning;
    }

    public void setStrippingCleaning(String strippingCleaning) {
        this.strippingCleaning = strippingCleaning;
    }

    public double getKnifeUsed() {
        return knifeUsed;
    }

    public void setKnifeUsed(double knifeUsed) {
        this.knifeUsed = knifeUsed;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
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

    @PrePersist
    protected void onCreate() {
        createDate = LocalDateTime.now();
    }



}
