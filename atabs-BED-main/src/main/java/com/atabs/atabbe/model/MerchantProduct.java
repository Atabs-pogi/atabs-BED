package com.atabs.atabbe.model;

import com.atabs.atabbe.entity.MerchantProductEntity;

import java.time.LocalDateTime;

public class MerchantProduct {

    private long productId;
    private String item;
    private int quantity;
    private double price;
    private String status;

    private double originalPrice;

    private LocalDateTime importDate;

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(double originalPrice) {
        this.originalPrice = originalPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getImportDate() {
        return importDate;
    }

    public void setImportDate(LocalDateTime importDate) {
        this.importDate = importDate;
    }

    public static MerchantProduct from(MerchantProductEntity entity) {
        MerchantProduct merchantProduct = new MerchantProduct();
        merchantProduct.productId = entity.getProductId();
        merchantProduct.item = entity.getItem();
        merchantProduct.importDate = entity.getImportDate();
        merchantProduct.price = entity.getPrice();
        merchantProduct.quantity = entity.getQuantity();
        merchantProduct.status = String.valueOf(entity.getStatus());
        merchantProduct.originalPrice= entity.getOriginalPrice();
        return merchantProduct;
    }
}
