package com.atabs.atabbe.model;

import com.atabs.atabbe.entity.FarmerEntity;

import java.time.LocalDate;

public class Farmer {

    private long farmerId;
    private String firstName;
    private String middleName;
    private String lastName;
    private LocalDate birthday;
    private String estimatedAnnualIncome;
    private String civilStatus;
    private String spouse;
    private String educationalAttainment;
    private String noOfDependents;
    private String affiliation;
    private int age;
    private String mobileNumber;
    private String facebookAccount;
    private String viberAccount;
    private String email;
    private String sex;
    private int status;
    private Address address;
    private String imageLocation;


    public String getImageLocation() {
        return imageLocation;
    }

    public void setImageLocation(String imageLocation) {
        this.imageLocation = imageLocation;
    }

    public long getFarmerId() {
        return farmerId;
    }

    public void setFarmerId(long farmerId) {
        this.farmerId = farmerId;
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

    public String getEstimatedAnnualIncome() {
        return estimatedAnnualIncome;
    }

    public void setEstimatedAnnualIncome(String estimatedAnnualIncome) {
        this.estimatedAnnualIncome = estimatedAnnualIncome;
    }

    public String getCivilStatus() {
        return civilStatus;
    }

    public void setCivilStatus(String civilStatus) {
        this.civilStatus = civilStatus;
    }

    public String getSpouse() {
        return spouse;
    }

    public void setSpouse(String spouse) {
        this.spouse = spouse;
    }

    public String getEducationalAttainment() {
        return educationalAttainment;
    }

    public void setEducationalAttainment(String educationalAttainment) {
        this.educationalAttainment = educationalAttainment;
    }

    public String getNoOfDependents() {
        return noOfDependents;
    }

    public void setNoOfDependents(String noOfDependents) {
        this.noOfDependents = noOfDependents;
    }

    public String getAffiliation() {
        return affiliation;
    }

    public void setAffiliation(String affiliation) {
        this.affiliation = affiliation;
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

    public String getFacebookAccount() {
        return facebookAccount;
    }

    public void setFacebookAccount(String facebookAccount) {
        this.facebookAccount = facebookAccount;
    }

    public String getViberAccount() {
        return viberAccount;
    }

    public void setViberAccount(String viberAccount) {
        this.viberAccount = viberAccount;
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
        farmer.farmerId = entity.getFarmerId();
        farmer.firstName = entity.getFirstName();
        farmer.middleName = entity.getMiddleName();
        farmer.lastName = entity.getLastName();
        farmer.birthday = entity.getBirthday();
        farmer.affiliation=entity.getAffiliation();
        farmer.civilStatus= entity.getCivilStatus();
        farmer.educationalAttainment= entity.getEducationalAttainment();
        farmer.estimatedAnnualIncome= entity.getEstimatedAnnualIncome();
        farmer.facebookAccount= entity.getFacebookAccount();
        farmer.noOfDependents= entity.getNoOfDependents();
        farmer.spouse=entity.getSpouse();
        farmer.viberAccount= entity.getViberAccount();
        farmer.imageLocation = entity.getImageLocation();
        farmer.mobileNumber = entity.getMobileNumber();
        farmer.email = entity.getEmail();
        farmer.sex = entity.getSex();
        farmer.status = entity.getStatus();
        farmer.address = Address.from(entity.getAddress());
        return farmer;
    }
}
