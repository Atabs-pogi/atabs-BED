package com.atabs.atabbe.entity;

import javax.persistence.*;

@Entity
@Table(name = "bills_item_transaction")
public class BillsItemEntity {
    @Id
    @GeneratedValue(generator = "bills_trans_item_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "bills_trans_item_seq", sequenceName = "bills_trans_item_sequence", initialValue = 800, allocationSize = 10000000)
    @Column(name = "item_id")
    private long id;

    private String  category;

    private double  amount;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
