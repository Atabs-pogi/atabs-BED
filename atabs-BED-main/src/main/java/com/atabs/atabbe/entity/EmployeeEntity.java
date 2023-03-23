package com.atabs.atabbe.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Entity
@Table(name = "employees")
public class EmployeeEntity {

    @Id
    @GeneratedValue(generator = "emp_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "emp_seq", sequenceName = "employee_sequence", initialValue = 101, allocationSize = 50)
    @Column(name = "empId")
    private long empId;
    private String firstName;
    private String middleName;
    private String lastName;
    private LocalDate birthday;
    @Transient
    private int age;
    private String mobileNumber;
    private String email;
    private String address;
    private String sex;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
    private LocalDate dateHired;
    private String imageLocation;
    private long postalCode;
    @Column(name = "status", nullable = false, columnDefinition = "INT NOT NULL DEFAULT 1")
    private int status = 1;
    @Transient
    private boolean reviewed;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public boolean isReviewed() {
        return reviewed;
    }

    public void setReviewed(boolean reviewed) {
        this.reviewed = reviewed;
    }


    public String getImageLocation() {
        return imageLocation;
    }

    public void setImageLocation(String imageLocation) {
        this.imageLocation = imageLocation;
    }


    @PrePersist
    protected void onCreate() {
        createDate = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updateDate = LocalDateTime.now();
    }

    public long getId() {
        return empId;
    }

    public void setId(long id) {
        this.empId = id;
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

//    public int getAge() {
//        return (int) ChronoUnit.YEARS.between(this.birthday, LocalDate.now());
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }


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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public LocalDate getDateHired() {
        return dateHired;
    }

    public void setDateHired(LocalDate dateHired) {
        this.dateHired = dateHired;
    }

    public long getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(long postalCode) {
        this.postalCode = postalCode;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }
}
