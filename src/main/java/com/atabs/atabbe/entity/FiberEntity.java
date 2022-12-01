package com.atabs.atabbe.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "fibers")
public class FiberEntity {

    @Id
    @GeneratedValue(generator = "fiber_seq", strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name = "fiber_seq", sequenceName = "fiber_sequence", initialValue = 101, allocationSize = 10000000)
    @Column(name = "fiberId")
    private long fiberId;
    private String name;
    private String grade;
    private double price;
    @Column(name="status", nullable = false, columnDefinition="INT NOT NULL DEFAULT 1")
    private int status = 1;
    private LocalDateTime dateCreated;
    private LocalDateTime lastUpdated;

    @PrePersist
    protected void onCreate() {
        dateCreated = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate(){
        lastUpdated = LocalDateTime.now();
    }

    public long getId() {
        return fiberId;
    }

    public void setId(long id) {
        this.fiberId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
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

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}
