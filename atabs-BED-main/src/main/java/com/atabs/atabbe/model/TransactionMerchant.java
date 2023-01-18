package com.atabs.atabbe.model;


import java.util.ArrayList;

public class TransactionMerchant {

    private long transMerchantId;
    private long farmerId;
    private long cashierId;
    private double totalItem;
    private double totalAmount;


    private double payment;
    private double changed;

    private ArrayList<Items> items;

    public ArrayList<Items> getItems() {
        return items;
    }

    public void setItems(ArrayList<Items> items) {
        this.items = items;
    }



    public long getTransMerchantId() {
        return transMerchantId;
    }

    public void setTransMerchantId(long transMerchantId) {
        this.transMerchantId = transMerchantId;
    }

    public long getFarmerId() {
        return farmerId;
    }

    public void setFarmerId(long farmerId) {
        this.farmerId = farmerId;
    }

    public long getCashierId() {
        return cashierId;
    }

    public void setCashierId(long cashierId) {
        this.cashierId = cashierId;
    }

    public double getTotalItem() {
        return totalItem;
    }

    public void setTotalItem(double totalItem) {
        this.totalItem = totalItem;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public double getPayment() {
        return payment;
    }

    public void setPayment(double payment) {
        this.payment = payment;
    }

    public double getChanged() {
        return changed;
    }

    public void setChanged(double changed) {
        this.changed = changed;
    }

    public static class Items {
        private long id;


        private long productId;
        private String  name;
        private double quantity;
        private double price;
        private double subAmount;

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

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

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public double getSubAmount() {
            return subAmount;
        }

        public void setSubAmount(double subAmount) {
            this.subAmount = subAmount;
        }
    }

}

