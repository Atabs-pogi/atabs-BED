package com.atabs.atabbe.dao;

import com.atabs.atabbe.entity.OtherDeductionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface OtherDeductionDao extends JpaRepository<OtherDeductionEntity, Long> {

    @Query(value = "SELECT * FROM other_deduction WHERE payroll_id = :id AND description = :description", nativeQuery = true)
    public OtherDeductionEntity getExistingOtherDeduction(long id, String description);

    @Query(value = "SELECT * FROM other_deduction WHERE payroll_id = :id", nativeQuery = true)
    public List<OtherDeductionEntity> getOtherDeductionsById(long id);
}
