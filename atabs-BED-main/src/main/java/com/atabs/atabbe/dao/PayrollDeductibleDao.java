package com.atabs.atabbe.dao;

import com.atabs.atabbe.entity.PayrollDeductibleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PayrollDeductibleDao extends JpaRepository<PayrollDeductibleEntity, Long> {

    @Query(value = "SELECT * FROM payroll_deductible WHERE payroll_id = :id AND description = :description", nativeQuery = true)
    public PayrollDeductibleEntity getExistingDeductible(long id, String description);
}
