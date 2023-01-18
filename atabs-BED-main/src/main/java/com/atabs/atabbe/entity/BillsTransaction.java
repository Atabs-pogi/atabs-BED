package com.atabs.atabbe.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "bills_transaction")
public class BillsTransaction {

    @Id
    @GeneratedValue(generator = "bills_trans_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "bills_trans_seq", sequenceName = "bills_trans_sequence", initialValue = 201, allocationSize = 50)
    @Column(name = "id")
    private long id;


    private String monthYear;
    private double totalAmount;
    private LocalDateTime dateTime;


    @OneToMany(targetEntity = BillsItemEntity.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "billsTranId" ,referencedColumnName ="id" )
    private List<BillsItemEntity> items;


    @PrePersist
    protected void onCreate() {
        dateTime = LocalDateTime.now();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMonthYear() {
        return monthYear;
    }

    public void setMonthYear(String monthYear) {
        this.monthYear = monthYear;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public LocalDateTime getImportDate() {
        return dateTime;
    }

    public void setImportDate(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }



    public List<BillsItemEntity> getItems() {
        return items;
    }

    public void setItems(List<BillsItemEntity> items) {
        this.items = items;
    }


}
