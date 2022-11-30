package com.atabs.atabbe.model;

import com.atabs.atabbe.entity.FiberEntity;

public class Fiber {

    private long Id;
    private String name;
    private String grade;
    private double price;
    private String datePrice;
    private int status;

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

    public String getDatePrice() {
        return datePrice;
    }

    public void setDatePrice(String datePrice) {
        this.datePrice = datePrice;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public static Fiber from(FiberEntity entity) {
        Fiber fiber = new Fiber();
        fiber.Id = entity.getId();
        fiber.name = entity.getName();
        fiber.grade = entity.getGrade();
        fiber.price = entity.getPrice();
        fiber.datePrice = entity.getDatePrice();
        fiber.status = entity.getStatus();
        return fiber;
    }
}

