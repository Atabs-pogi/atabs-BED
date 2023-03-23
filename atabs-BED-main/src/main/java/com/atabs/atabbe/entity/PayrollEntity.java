package com.atabs.atabbe.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

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
    private String paymentMethod; //  (e.g., direct deposit, check)
    private LocalDate paymentDate;

    private double totalWorkHours;
    private double overTimeRate;
    private double totalOtHours;
    private double totalTardinessHours;
    private double totalVacationDays;
    private double totalSickDays;

    private  double regularPay;
    private double overTimePay;
    private double tardinessDeduction;
    private double vacationPay;
    private double sickPay;
    private double grossPay;

    private double totalMandatoryDeduction;
    private double taxableIncome;
    private double withholdingTax;

    private double otherDeductions;
    private double totalDeductions;
    private double netPay;
    @Transient
    private List<MandatoryDeductionEntity> benefits;
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

    public double getTotalWorkHours() {
        return totalWorkHours;
    }

    public void setTotalWorkHours(double totalWorkHours) {
        this.totalWorkHours = totalWorkHours;
    }

    public double getOverTimeRate() {
        return overTimeRate;
    }

    public void setOverTimeRate(double overTimeRate) {
        this.overTimeRate = overTimeRate;
    }

    public double getTotalOtHours() {
        return totalOtHours;
    }

    public void setTotalOtHours(double totalOtHours) {
        this.totalOtHours = totalOtHours;
    }

    public double getTotalTardinessHours() {
        return totalTardinessHours;
    }

    public void setTotalTardinessHours(double totalTardinessHours) {
        this.totalTardinessHours = totalTardinessHours;
    }

    public double getTotalVacationDays() {
        return totalVacationDays;
    }

    public void setTotalVacationDays(double totalVacationDays) {
        this.totalVacationDays = totalVacationDays;
    }

    public double getTotalSickDays() {
        return totalSickDays;
    }

    public void setTotalSickDays(double totalSickDays) {
        this.totalSickDays = totalSickDays;
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

    public double getGrossPay() {
        return grossPay;
    }

    public void setGrossPay(double grossPay) {
        this.grossPay = grossPay;
    }

    public double getTotalMandatoryDeduction() {
        return totalMandatoryDeduction;
    }

    public void setTotalMandatoryDeduction(double totalMandatoryDeduction) {
        this.totalMandatoryDeduction = totalMandatoryDeduction;
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

    public double getOtherDeductions() {
        return otherDeductions;
    }

    public void setOtherDeductions(double otherDeductions) {
        this.otherDeductions = otherDeductions;
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

    public List<MandatoryDeductionEntity> getBenefits() {
        return benefits;
    }

    public void setBenefits(List<MandatoryDeductionEntity> benefits) {
        this.benefits = benefits;
    }
}
