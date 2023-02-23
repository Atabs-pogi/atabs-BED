package com.atabs.atabbe.dao;

import com.atabs.atabbe.entity.PayrollDetailEntity;
import com.atabs.atabbe.entity.PayrollEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface PayrollDetailDao extends JpaRepository<PayrollDetailEntity, Long> {

    @Query(value = "SELECT * FROM payroll_detail WHERE payroll_id = :id AND date = :date", nativeQuery = true)
    public PayrollDetailEntity getByDate(long id, LocalDate date);

    @Query(value = "SELECT * FROM payroll_detail WHERE payroll_id = :id  AND date BETWEEN :start AND :end", nativeQuery = true)
    public List<PayrollDetailEntity>  getByPeriod(long id, LocalDate start, LocalDate end);
}
