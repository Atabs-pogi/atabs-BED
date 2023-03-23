package com.atabs.atabbe.dao;

import com.atabs.atabbe.entity.OtherDeductionEntity;
import com.atabs.atabbe.entity.PayrollBenefitEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
public interface PayrollBenefitDao extends JpaRepository<PayrollBenefitEntity, Long> {

    @Query(value = "SELECT * FROM payroll_benefit WHERE payroll_id = :id AND description = :description", nativeQuery = true)
    public PayrollBenefitEntity getExistingBenefit(long id, String description);

    @Query(value = "SELECT * FROM payroll_benefit WHERE payroll_id = :id", nativeQuery = true)
    public List<PayrollBenefitEntity> getBenefitById(long id);
}
