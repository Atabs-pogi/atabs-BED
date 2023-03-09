package com.atabs.atabbe.dao;

import com.atabs.atabbe.entity.FarmerEntity;
import com.atabs.atabbe.entity.FiberEntity;
import com.atabs.atabbe.entity.TuxyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface FiberDao extends JpaRepository<FiberEntity, Long> {

    @Query(value = "Select * from fibers where fiber_id =:fiber_id", nativeQuery = true)
    FiberEntity getFiberInfo(Long fiber_id);

//
//    @Query(value = "Select COUNT(name) from Fibers where name =:fiber_nane", nativeQuery = true)
//    int findByName(String fiber_name);

    @Query(value = "SELECT * FROM fibers WHERE name like %:match%", nativeQuery = true)
    List<FiberEntity> searchByName(String match);

    @Query(value = "SELECT grade from fibers where name=:fName",nativeQuery = true)
    String getFiberGrade(String fName);



}
