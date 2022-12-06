package com.atabs.atabbe.model;

import com.atabs.atabbe.entity.FarmerEntity;

import java.time.LocalDate;

public class Farmer {

    private long Id;
    private String firstName;
    private String middleName;
    private String lastName;
    private LocalDate birthday;
    private int age;
    private String mobileNumber;
    private String email;
    private String sex;
    private int status;
    private Address address;

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public static Farmer from(FarmerEntity entity) {
        Farmer farmer = new Farmer();
        farmer.Id = entity.getId();
        farmer.firstName = entity.getFirstName();
        farmer.middleName = entity.getMiddleName();
        farmer.lastName = entity.getLastName();
        farmer.birthday = entity.getBirthday();
        farmer.age = entity.getAge();
        farmer.mobileNumber = entity.getMobileNumber();
        farmer.email = entity.getEmail();
        farmer.sex = entity.getSex();
        farmer.status = entity.getStatus();
        farmer.address = Address.from(entity.getAddress());
        return farmer;
    }
}
