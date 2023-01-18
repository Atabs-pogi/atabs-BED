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

    private long productId;
    private String item;
    private String quantity;
<<<<<<< HEAD
    private String price;
    private String originalPrice;
=======
    private double price;
>>>>>>> 2ad10690f1773f9fd224ab7731fd2cf5ef3cf7e0

    private LocalDateTime importDate;

    @PrePersist
    protected void onCreate() {
        importDate = LocalDateTime.now();
    }


    @Column(name = "status", nullable = false, columnDefinition = "INT NOT NULL DEFAULT 1")
    private int status = 1;

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

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(String originalPrice) {
        this.originalPrice = originalPrice;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public LocalDateTime getImportDate() {
        return importDate;
    }

    public void setImportDate(LocalDateTime importDate) {
        this.importDate = importDate;
    }
}
