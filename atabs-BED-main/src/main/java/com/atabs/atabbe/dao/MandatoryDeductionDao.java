package com.atabs.atabbe.dao;

import com.atabs.atabbe.entity.MandatoryDeductionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MandatoryDeductionDao extends JpaRepository<MandatoryDeductionEntity, Long> {
    @Query(value = "SELECT * FROM mandatory_deduction WHERE payroll_id = :id AND type = :type", nativeQuery = true)
    public MandatoryDeductionEntity getExistingMandatoryDeduction(long id, String type);

    @Query(value = "SELECT * FROM mandatory_deduction WHERE payroll_id = :id", nativeQuery = true)
    public List<MandatoryDeductionEntity> getAllMandatoryDeductionById(long id);

    @Query(value = "SELECT * FROM mandatory_deduction", nativeQuery = true)
    public List<MandatoryDeductionEntity> getMandatoryDeduction();
}
