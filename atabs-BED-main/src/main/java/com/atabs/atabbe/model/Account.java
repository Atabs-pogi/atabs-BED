package com.atabs.atabbe.model;

import com.atabs.atabbe.entity.AccountEntity;

import java.util.Set;

public class Account {
    private long accountId;
    private String username;
    private String password;
    private String role;
    private int status;

    private long empId;


    public long getEmpId() {
        return empId;
    }

    public void setEmpId(long empId) {
        this.empId = empId;
    }

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public static Account from(AccountEntity accountEntity) {
        Account account = new Account();
        account.accountId= accountEntity.getAccountId();
        account.username = accountEntity.getUsername();
        account.password = accountEntity.getPassword();
        account.role = accountEntity.getRole();
        account.status = accountEntity.getStatus();
        account.empId= account.getEmpId();
        return account;
    }
}