package com.atabs.atabbe.model;
import com.atabs.atabbe.entity.EmployeeEntity;

import java.time.LocalDate;

public class Employee {

    private long id;
    private String firstName;
    private String middleName;
    private String lastName;
    private LocalDate birthday;
    private String role;
    private String mobileNumber;
    private String email;

    private Address address;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    private String sex;
    private int status;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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


    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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

    public static Employee from (EmployeeEntity entity){
        Employee employee = new Employee();
        employee.id = entity.getId();
        employee.firstName = entity.getFirstName();
        employee.middleName = entity.getMiddleName();
        employee.lastName = entity.getLastName();
        if (entity.getBirthday() != null)
            employee.birthday = entity.getBirthday();
        employee.role = entity.getRole();
        employee.mobileNumber = entity.getMobileNumber();
        employee.email = entity.getEmail();
        employee.sex = entity.getSex();
        employee.status = entity.getStatus();
        employee.address = Address.from(entity.getAddress());
        return employee;
    }

}
