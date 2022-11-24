package com.atabs.atabbe.model;
import com.atabs.atabbe.entity.AccountEntity;

public class Account {
    private long id;
    private String username;
    private String password;
    private String role;
    private int status;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public static Account from (AccountEntity accountEntity){
        Account account = new Account();
        account.id = account.getId();
        account.username = accountEntity.getUsername();
        account.password = accountEntity.getPassword();
        account.role = accountEntity.getRole();
        account.status = accountEntity.getStatus();
        return account;
    }
}