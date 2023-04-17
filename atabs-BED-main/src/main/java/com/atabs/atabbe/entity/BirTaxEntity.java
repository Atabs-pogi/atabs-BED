package com.atabs.atabbe.entity;

import javax.persistence.*;

@Entity
@Table(name = "bir_tax")
public class BirTaxEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "taxId")
    private long id;
    private double minimum;
    private double maximum;
    private double fixTax;
    private double taxRateOnExcess;
    private String frequency;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getMinimum() {
        return minimum;
    }

    public void setMinimum(double minimum) {
        this.minimum = minimum;
    }

    public double getMaximum() {
        return maximum;
    }

    public void setMaximum(double maximum) {
        this.maximum = maximum;
    }

    public double getFixTax() {
        return fixTax;
    }

    public void setFixTax(double fixTax) {
        this.fixTax = fixTax;
    }

    public double getTaxRateOnExcess() {
        return taxRateOnExcess;
    }

    public void setTaxRateOnExcess(double taxRateOnExcess) {
        this.taxRateOnExcess = taxRateOnExcess;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }
}
