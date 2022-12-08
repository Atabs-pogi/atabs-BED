package com.atabs.atabbe.entity;
import javax.persistence.*;

@Entity
@Table(name = "accounts")
public class AccountEntity {

    @Id
    @GeneratedValue(generator = "account_seq", strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name = "account_seq", sequenceName = "account_sequence", initialValue = 2022101, allocationSize = 10000000)
    @Column(name = "account_id")
    private long id;
    private String username;
    private String password;
    private String role;
    @Column(name="status", nullable = false, columnDefinition="INT NOT NULL DEFAULT 1")
    private int status = 1;

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
}