package com.atabs.atabbe.dao;

import com.atabs.atabbe.entity.PayrollEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface PayrollDao extends JpaRepository<PayrollEntity, Long> {


    @Query(value = "SELECT * FROM payroll WHERE emp_id = :empId AND period_start = :start AND period_end = :end", nativeQuery = true)
    public PayrollEntity getEmployeePayrollByPeriod(long empId, LocalDate start, LocalDate end);

    @Query(value = "SELECT * FROM payroll WHERE period_start = :start AND period_end = :end", nativeQuery = true)
    public List<PayrollEntity> getPayrollByPeriod(LocalDate start, LocalDate end);

    @Query(value = "SELECT e.emp_id FROM employees e INNER JOIN payroll p ON p.emp_id = e.emp_id AND p.period_start BETWEEN :start AND :end", nativeQuery = true)
    public List<Long> getEmployeesPeriod(LocalDate start, LocalDate end);
}
