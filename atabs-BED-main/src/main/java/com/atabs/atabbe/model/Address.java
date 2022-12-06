package com.atabs.atabbe.model;

public class Address {
    private String houseNo;
    private String unit;
    private String barangay;
    private String province;
    private String city;
    public String getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getBarangay() {
        return barangay;
    }

    public void setBarangay(String barangay) {
        this.barangay = barangay;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String toString(){
        String[] wholeAddress = {
                this.houseNo,
                this.unit,
                this.barangay,
                this.province,
                this.city
        };
            return  String.join("/", wholeAddress);
    }

    public static Address from (String addressStr){
        Address address = new Address();
        if (addressStr != null) {
            String[] parts = addressStr.split("/");
            if (parts.length > 0)
                address.houseNo = parts[0];
            if (parts.length > 1)
                address.unit = parts[1];
            if (parts.length > 2)
                if (parts.length > 4)
                address.barangay = parts[2];
            if (parts.length > 3)
            address.province = parts[3];
            address.city = parts[4];
        }
        return address;
    }
}
