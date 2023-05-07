package com.atabs.atabbe.entity;

import javax.persistence.*;

@Entity
@Table(name = "transaction_merchant_item")
public class TransactionMerchantItemEntity {
    @Id
    @GeneratedValue(generator = "merchant_item_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "merchant_item_seq", sequenceName = "merchant_item_sequence", initialValue = 500, allocationSize = 10000000)
    @Column(name = "itemId")
    private long id;

    private long productId;
    private String  name;
    private double quantity;
    private double price;
    private double subAmount;


    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }



    public double getSubAmount() {
        return subAmount;
    }

    public void setSubAmount(double subAmount) {
        this.subAmount = subAmount;
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }



    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }





}
