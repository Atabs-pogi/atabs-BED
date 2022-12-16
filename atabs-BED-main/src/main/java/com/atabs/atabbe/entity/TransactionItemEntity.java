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

    private double excellentKilo;

    private double excellentAmount;

    private double diskarteKilo;

    private double discarteAmount;

    private double resecoKilo;

    private double resecoAmount;

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



    public double getExcellentKilo() {
        return excellentKilo;
    }

    public void setExcellentKilo(double excellentKilo) {
        this.excellentKilo = excellentKilo;
    }

    public double getExcellentAmount() {
        return excellentAmount;
    }

    public void setExcellentAmount(double excellentAmount) {
        this.excellentAmount = excellentAmount;
    }

    public double getDiskarteKilo() {
        return diskarteKilo;
    }

    public void setDiskarteKilo(double diskarteKilo) {
        this.diskarteKilo = diskarteKilo;
    }

    public double getDiscarteAmount() {
        return discarteAmount;
    }

    public void setDiscarteAmount(double discarteAmount) {
        this.discarteAmount = discarteAmount;
    }

    public double getResecoKilo() {
        return resecoKilo;
    }

    public void setResecoKilo(double resecoKilo) {
        this.resecoKilo = resecoKilo;
    }

    public double getResecoAmount() {
        return resecoAmount;
    }

    public void setResecoAmount(double resecoAmount) {
        this.resecoAmount = resecoAmount;
    }
//    @ManyToOne
//    @JoinColumn(name="transactionsId", nullable=false)
//    private TransactionEntity transactionEntity;




}
