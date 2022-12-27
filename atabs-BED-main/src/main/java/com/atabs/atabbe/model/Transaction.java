package com.atabs.atabbe.model;


import java.util.List;

public  class Transaction {

    private List<Items> items;

    public long getFarmerId() {
        return farmerId;
    }

    public void setFarmerId(long farmerId) {
        this.farmerId = farmerId;
    }

    private long farmerId;

    public List<Items> getItems() {
        return items;
    }

    public void setItems(List<Items> items) {
        this.items = items;
    }


    public static class Items {
        private double quantity;
        private String quality;

        private long tuxyId;

        public long getTuxyId() {
            return tuxyId;
        }

        public void setTuxyId(long tuxyId) {
            this.tuxyId = tuxyId;
        }



        public double getQuantity() {
            return quantity;
        }

        public void setQuantity(double quantity) {
            this.quantity = quantity;
        }

        public String getQuality() {
            return quality;
        }

        public void setQuality(String quality) {
            this.quality = quality;
        }


    }
}