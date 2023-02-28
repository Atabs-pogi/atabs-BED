package com.atabs.atabbe.dao;

public interface PayrollDetailsProjection {
    double getRegularPay();
    double getOverTimePay();
    double getTardiness();
    double getVacationPay();
    double getSickPay();
    double getGrossPay();
    double getTotalDeductions();
    double getTaxableIncome();
}

