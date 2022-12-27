package com.atabs.atabbe.model;


public class UpdateTransaction {

    private int status;
    private long transaction_id;



    private double merchantPayment;



    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public long getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(long transaction_id) {
        this.transaction_id = transaction_id;
    }

    public double getMerchantPayment() {
        return merchantPayment;
    }

    public void setMerchantPayment(double merchantPayment) {
        this.merchantPayment = merchantPayment;
    }
}