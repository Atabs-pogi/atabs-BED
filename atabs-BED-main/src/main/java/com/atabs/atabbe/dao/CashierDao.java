package com.atabs.atabbe.dao;

import com.atabs.atabbe.entity.CashierEntity;
import com.atabs.atabbe.entity.FiberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CashierDao extends JpaRepository<CashierEntity, Long> {

    @Query(value = "SELECT * FROM cashier WHERE cashier_total like %:match% OR farmer_id like %:match% OR transaction_id like %:match% OR merchandise_price like %:match%", nativeQuery = true)
    List<CashierEntity> searchCashierByName(String match);

    @Query(value = "Select * from cashier where cashier_id =:cashier_id", nativeQuery = true)
    CashierEntity getCashierInfo(Long cashier_id);
}
