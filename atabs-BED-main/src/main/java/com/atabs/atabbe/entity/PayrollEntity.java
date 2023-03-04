package com.atabs.atabbe.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "payroll")
public class PayrollEntity {
    @Id
    @GeneratedValue(generator = "payroll_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "payroll_seq", sequenceName = "payroll_sequence", initialValue = 101, allocationSize = 50)
    @Column(name = "payrollId")
    private long id;
    private LocalDate periodStart;
    private LocalDate periodEnd;
    private double grossPay;
    private double totalBenefitContributions;
    private double totalDeductions;
    private double netPay;
    private String paymentMethod; //  (e.g., direct deposit, check)
    private LocalDate paymentDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "emp_id", nullable = false)
    private EmployeeEntity employee;

    public EmployeeEntity getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeEntity employee) {
        this.employee = employee;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getPeriodStart() {
        return periodStart;
    }

    public void setPeriodStart(LocalDate periodStart) {
        this.periodStart = periodStart;
    }

    public LocalDate getPeriodEnd() {
        return periodEnd;
    }

    public void setPeriodEnd(LocalDate periodEnd) {
        this.periodEnd = periodEnd;
    }

    public double getGrossPay() {
        return grossPay;
    }

    public void setGrossPay(double grossPay) {
        this.grossPay = grossPay;
    }

    public double getTotalBenefitContributions() {
        return totalBenefitContributions;
    }

    public void setTotalBenefitContributions(double totalBenefitContributions) {
        this.totalBenefitContributions = totalBenefitContributions;
    }

    public double getTotalDeductions() {
        return totalDeductions;
    }

    public void setTotalDeductions(double totalDeductions) {
        this.totalDeductions = totalDeductions;
    }

    public double getNetPay() {
        return netPay;
    }

    public void setNetPay(double netPay) {
        this.netPay = netPay;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }
}
