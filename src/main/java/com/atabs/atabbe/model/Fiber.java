package com.atabs.atabbe.model;

import com.atabs.atabbe.entity.FiberEntity;

import java.time.LocalDateTime;

public class Fiber {

    private long Id;
    private String name;
    private String grade;
    private double price;
    private int status;

    private LocalDateTime dateCreated;
    private LocalDateTime lastUpdated;

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
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
    public static Fiber from (FiberEntity entity){
        Fiber fiber = new Fiber();
        fiber.Id = entity.getId();
        fiber.name = entity.getName();
        fiber.grade = entity.getGrade();
        fiber.price = entity.getPrice();
        fiber.status = entity.getStatus();
        fiber.dateCreated = entity.getDateCreated();
        fiber.lastUpdated = entity.getLastUpdated();
        return fiber;
    }
}

