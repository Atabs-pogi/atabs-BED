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
    private LocalDateTime paymentDate;
    private double totalBillAmount;
    private LocalDateTime encodeDate;

    @OneToMany(targetEntity = BillsItemEntity.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "billsTranId" ,referencedColumnName ="id" )
    private List<BillsItemEntity> items;

    @PrePersist
    protected void onCreate() {
        encodeDate = LocalDateTime.now();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDateTime paymentDate) {
        this.paymentDate = paymentDate;
    }

    public double getTotalBillAmount() {
        return totalBillAmount;
    }

    public void setTotalBillAmount(double totalBillAmount) {
        this.totalBillAmount = totalBillAmount;
    }

    public LocalDateTime getEncodeDate() {
        return encodeDate;
    }

    public void setEncodeDate(LocalDateTime encodeDate) {
        this.encodeDate = encodeDate;
    }

    public List<BillsItemEntity> getItems() {
        return items;
    }

    public void setItems(List<BillsItemEntity> items) {
        this.items = items;
    }
}
