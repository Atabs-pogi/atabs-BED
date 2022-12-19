package com.atabs.atabbe.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "transaction_item")
public class TransactionItemEntity {
    @Id
    @GeneratedValue(generator = "item_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "item_seq", sequenceName = "item_sequence", initialValue = 500, allocationSize = 10000000)
    @Column(name = "item_id")
    private long id;

    private long tuxyId;

    private String type;

    private double quantity;

    private double value;

    private double price;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getTuxyId() {
        return tuxyId;
    }

    public void setTuxyId(long tuxyId) {
        this.tuxyId = tuxyId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
//    @ManyToOne
//    @JoinColumn(name="transactionsId", nullable=false)
//    private TransactionEntity transactionEntity;




}
