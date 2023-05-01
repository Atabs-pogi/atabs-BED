package com.atabs.atabbe.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "merchant_product")
public class MerchantProductEntity {
    @Id
    @GeneratedValue(generator = "mrc_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "mrc_seq", sequenceName = "mrc_sequence", initialValue = 101, allocationSize = 50)
    @Column(name = "productId")

    private long id;
    private String productCategory;
    private String productName;
    private String unit;
    private double unitPrice;
    private double costPrice;
    private double originalPrice;
    private int quantity;
    private int minimumStock;
    private LocalDateTime importDate;

    @PrePersist
    protected void onCreate() {
        importDate = LocalDateTime.now();
    }

    @Column(name = "status", nullable = false, columnDefinition = "INT NOT NULL DEFAULT 1")
    private int status = 1;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(double costPrice) {
        this.costPrice = costPrice;
    }

    public double getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(double originalPrice) {
        this.originalPrice = originalPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getMinimumStock() {
        return minimumStock;
    }

    public void setMinimumStock(int minimumStock) {
        this.minimumStock = minimumStock;
    }

    public LocalDateTime getImportDate() {
        return importDate;
    }

    public void setImportDate(LocalDateTime importDate) {
        this.importDate = importDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
