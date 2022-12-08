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

    private String plantName;

    private String plantGrade;

    private double plantPrice;

    private double plantKilogram;



//    @ManyToOne
//    @JoinColumn(name="transactionsId", nullable=false)
//    private TransactionEntity transactionEntity;




    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPlantName() {
        return plantName;
    }

    public void setPlantName(String plantName) {
        this.plantName = plantName;
    }

    public String getPlantGrade() {
        return plantGrade;
    }

    public void setPlantGrade(String plantGrade) {
        this.plantGrade = plantGrade;
    }

    public double getPlantPrice() {
        return plantPrice;
    }

    public void setPlantPrice(double plantPrice) {
        this.plantPrice = plantPrice;
    }

    public double getPlantKilogram() {
        return plantKilogram;
    }

    public void setPlantKilogram(double plantKilogram) {
        this.plantKilogram = plantKilogram;
    }


//    public TransactionEntity getTransactionEntity() {
//        return transactionEntity;
//    }
//
//    public void setTransactionEntity(TransactionEntity transactionEntity) {
//        this.transactionEntity = transactionEntity;
//    }
}
