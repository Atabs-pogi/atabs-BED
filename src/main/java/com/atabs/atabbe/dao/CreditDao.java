package com.atabs.atabbe.dao;

import com.atabs.atabbe.entity.CreditEntity;
import com.atabs.atabbe.entity.PosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CreditDao extends JpaRepository<CreditEntity, Long> {

    @Query(value = "SELECT * FROM credit WHERE balance_id=:balance_id", nativeQuery = true)
    PosEntity getCreditInfo(Long balance_id);

    @Query(value = "SELECT * FROM credit WHERE credit_id like %:match% OR credit_balance like %:match% OR cashier_name like %:match% OR cashier_id like %:match% OR" +
            "plant_name like %:match% OR credit like %:match%", nativeQuery = true)
    List<CreditEntity> searchCreditByName(String match);

}
