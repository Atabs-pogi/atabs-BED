package com.atabs.atabbe.dao;

import com.atabs.atabbe.entity.FarmerEntity;
import com.atabs.atabbe.entity.FiberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FiberDao extends JpaRepository<FiberEntity, Long> {

    @Query(value = "Select * from Fibers where id =:fiber_id", nativeQuery = true)
    FiberEntity getFiberInfo(Long fiber_id);
//
//    @Query(value = "Select COUNT(name) from Fibers where name =:fiber_nane", nativeQuery = true)
//    int findByName(String fiber_name);

    @Query(value = "SELECT * FROM Fibers WHERE name like %:match%", nativeQuery = true)
    List<FiberEntity> searchFiberByName(String match);

}
