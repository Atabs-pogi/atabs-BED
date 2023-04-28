package com.atabs.atabbe.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "bills_item_transaction")
public class BillsItemEntity {
    @Id
    @GeneratedValue(generator = "bills_trans_item_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "bills_trans_item_seq", sequenceName = "bills_trans_item_sequence", initialValue = 800, allocationSize = 10000000)
    @Column(name = "item_id")
    private long id;
    private LocalDate issuanceDate;
    private LocalDate dueDate;
    private LocalDate receiptDate;
    private LocalDate deliveryDate;
    private double billAmount;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getIssuanceDate() {
        return issuanceDate;
    }

    public void setIssuanceDate(LocalDate issuanceDate) {
        this.issuanceDate = issuanceDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public LocalDate getReceiptDate() {
        return receiptDate;
    }

    public void setReceiptDate(LocalDate receiptDate) {
        this.receiptDate = receiptDate;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public double getBillAmount() {
        return billAmount;
    }

    public void setBillAmount(double billAmount) {
        this.billAmount = billAmount;
    }
}
