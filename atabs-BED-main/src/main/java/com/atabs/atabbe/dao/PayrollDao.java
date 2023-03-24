package com.atabs.atabbe.dao;

import com.atabs.atabbe.entity.EmployeeEntity;
import com.atabs.atabbe.entity.PayrollEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
@Repository
public interface PayrollDao extends JpaRepository<PayrollEntity, Long> {

    @Query(value = "SELECT * FROM payroll WHERE emp_id = :empId AND period_start = :start AND period_end = :end AND net_pay > 0", nativeQuery = true)
    public PayrollEntity getEmployeePayrollByPeriod(long empId, LocalDate start, LocalDate end);

    @Query(value = "SELECT * FROM payroll WHERE period_start = :start AND period_end = :end AND net_pay > 0", nativeQuery = true)
    public List<PayrollEntity> getAllEmployeePayrollByPeriod(LocalDate start, LocalDate end);

    @Query(value = "SELECT * FROM payroll WHERE emp_id = :empId AND period_start = :start AND period_end = :end", nativeQuery = true)
    public PayrollEntity getEmployeePayroll(long empId, LocalDate start, LocalDate end);

    @Query(value = "SELECT * FROM payroll WHERE period_start = :start AND period_end = :end", nativeQuery = true)
    public List<PayrollEntity> getPayrollByPeriod(LocalDate start, LocalDate end);

}
