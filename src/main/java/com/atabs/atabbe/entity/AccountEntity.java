package com.atabs.atabbe.entity;
import javax.persistence.*;

@Entity
@Table(name = "accounts")
public class AccountEntity {

    @Id
    @GeneratedValue(generator = "account_seq", strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name = "account_seq", sequenceName = "account_sequence", initialValue = 2022101, allocationSize = 10000000)
    @Column(name = "accountId")
    private long accountId;
    private String username;
    private String password;
    private String role;
    @Column(name="status", nullable = false, columnDefinition="INT NOT NULL DEFAULT 1")
    private int status = 1;

    @OneToOne
    @PrimaryKeyJoinColumn
    private EmployeeEntity employeeEntity;

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

    public EmployeeEntity getEmployeeEntity() {
        return employeeEntity;
    }

    public void setEmployeeEntity(EmployeeEntity employeeEntity) {
        this.employeeEntity = employeeEntity;
    }
}
