package com.atabs.atabbe.dao;

import com.atabs.atabbe.entity.BirTaxEntity;
import com.atabs.atabbe.entity.HolidayEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BirTaxDao extends JpaRepository<BirTaxEntity, Long> {
    @Query(value = "SELECT * FROM bir_tax WHERE frequency = :frequency AND :grossPay BETWEEN minimum AND maximum", nativeQuery = true)
    public BirTaxEntity getTaxBySalaryRange(double grossPay, String frequency);
}
