package com.atabs.atabbe.dao;


import com.atabs.atabbe.entity.PosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Repository
public interface PosDao extends JpaRepository<PosEntity, Long> {

    @Query(value = "SELECT * FROM transactions WHERE transactions_id=:transact_id", nativeQuery = true)
    PosEntity getPosInfo(Long transact_id);

    @Query(value = "SELECT * FROM transactions WHERE plant_name like %:match% OR plant_grade like %:match% OR plant_price like %:match% " +
            "OR plant_kilogram like %:match% OR plant_total like %:match%", nativeQuery = true)
    List<PosEntity> searchPosByName(String match);

    @Query(value = "SELECT COUNT(1) FROM farmers WHERE id=:id", nativeQuery = true)
    int findFarmerId(String id);

    @Transactional
    @Modifying
    @Query(value = "Update transactions set plant_kilogram=:plantKilogram,plant_total=:plantTotal where transactions_id=:transactionsId", nativeQuery = true)
    Integer updatePos(double plantKilogram, double plantTotal, long transactionsId);

}
