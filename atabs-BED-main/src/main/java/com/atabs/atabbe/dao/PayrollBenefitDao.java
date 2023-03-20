package com.atabs.atabbe.dao;

import com.atabs.atabbe.entity.PayrollBenefitEntity;
import com.atabs.atabbe.entity.PayrollDeductibleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PayrollBenefitDao extends JpaRepository<PayrollBenefitEntity, Long> {
    @Query(value = "SELECT * FROM payroll_benefit WHERE payroll_id = :id AND benefit_type = :benefitType", nativeQuery = true)
    public PayrollBenefitEntity getExistingBenefit(long id, String benefitType);

    @Query(value = "SELECT * FROM payroll_benefit WHERE payroll_id = :id", nativeQuery = true)
    public List<PayrollBenefitEntity> getAllBenefits(long id);

    @Query(value = "SELECT * FROM payroll_benefit", nativeQuery = true)
    public List<PayrollBenefitEntity> getBenefits();
}
