package com.atabs.atabbe.dao;

import com.atabs.atabbe.entity.EmployeeEntity;
import com.atabs.atabbe.entity.FiberEntity;
import com.atabs.atabbe.entity.FiberNewEntity;
import com.atabs.atabbe.entity.MerchantProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FiberNewDao extends JpaRepository<FiberNewEntity, Long> {

    @Query(value = "SELECT * FROM fibernew WHERE fiber_id like %:match% OR reference_code like %:match% OR date_time like %:match%", nativeQuery = true)
    List<FiberNewEntity> searchFiberByName(String match);

    @Query(value = "SELECT * FROM fibernew WHERE reference_code =:refCode", nativeQuery = true)
    FiberNewEntity getRefCode(String refCode);

    @Query(value = "SELECT MAX(fiber_id) FROM fibernew", nativeQuery = true)
    Integer getFiberId();
}
