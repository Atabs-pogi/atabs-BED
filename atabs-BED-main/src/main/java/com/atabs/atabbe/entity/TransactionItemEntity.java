package com.atabs.atabbe.entity;

import com.atabs.atabbe.model.Tuxy;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "transaction_item")
public class TransactionItemEntity {
    @Id
    @GeneratedValue(generator = "item_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "item_seq", sequenceName = "item_sequence", initialValue = 500, allocationSize = 10000000)
    @Column(name = "item_id")
    private long id;

    private long tuxyId;



    private String  tuxyName;

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

    public String getTuxyName() {
        return tuxyName;
    }

    public void setTuxyName(String tuxyName) {
        this.tuxyName = tuxyName;
    }

//    public TuxyEntity getTuxy() {
//        return tuxy;
//    }
//
//    public void setTuxy(TuxyEntity tuxy) {
//        this.tuxy = tuxy;
//    }
//
//    @OneToOne(targetEntity = TuxyEntity.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @JoinColumn(name = "tuxyId" ,referencedColumnName ="tuxyId" )
//    private TuxyEntity tuxy;


}
