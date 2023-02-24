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
    private double baseSalary;
    private LocalDate periodStart;
    private LocalDate periodEnd;
    @Transient
    private  double regularPay;
    @Transient
    private double overTimePay;
    @Transient
    private double tardinessDeduction;
    @Transient
    private  double vacationPay;
    @Transient
    private  double sickPay;
    @Transient
    private double grossPay;
    @Transient
    private double totalDeductions;
    @Transient
    private double taxableIncome;
    @Transient
    private double withholdingTax;
    @Transient
    private double netPay;
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

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public double getGrossPay() {
        return grossPay;
    }

    public void setGrossPay(double grossPay) {
        this.grossPay = grossPay;
    }

    public double getNetPay() {
        return netPay;
    }

    public void setNetPay(double netPay) {
        this.netPay = netPay;
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

    public double getRegularPay() {
        return regularPay;
    }

    public void setRegularPay(double regularPay) {
        this.regularPay = regularPay;
    }

    public double getOverTimePay() {
        return overTimePay;
    }

    public void setOverTimePay(double overTimePay) {
        this.overTimePay = overTimePay;
    }

    public double getTardinessDeduction() {
        return tardinessDeduction;
    }

    public void setTardinessDeduction(double tardinessDeduction) {
        this.tardinessDeduction = tardinessDeduction;
    }

    public double getVacationPay() {
        return vacationPay;
    }

    public void setVacationPay(double vacationPay) {
        this.vacationPay = vacationPay;
    }

    public double getSickPay() {
        return sickPay;
    }

    public void setSickPay(double sickPay) {
        this.sickPay = sickPay;
    }

    public double getTotalDeductions() {
        return totalDeductions;
    }

    public void setTotalDeductions(double totalDeductions) {
        this.totalDeductions = totalDeductions;
    }

    public double getTaxableIncome() {
        return taxableIncome;
    }

    public void setTaxableIncome(double taxableIncome) {
        this.taxableIncome = taxableIncome;
    }

    public double getWithholdingTax() {
        return withholdingTax;
    }

    public void setWithholdingTax(double withholdingTax) {
        this.withholdingTax = withholdingTax;
    }
}
