package com.atabs.atabbe.dao;

import com.atabs.atabbe.entity.FiberNewEntity;
import com.atabs.atabbe.entity.FiberPricesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FiberPriceDao extends JpaRepository<FiberPricesEntity, Long> {
    @Query(value = "SELECT * FROM fiber_price WHERE fiber_price_id = (SELECT MAX(fiber_price_id) FROM fiber_price)", nativeQuery = true)
    FiberPricesEntity getLatestPrice();
}
