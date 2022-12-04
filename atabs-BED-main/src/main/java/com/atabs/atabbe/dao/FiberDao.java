package com.atabs.atabbe.dao;

import com.atabs.atabbe.entity.FarmerEntity;
import com.atabs.atabbe.entity.FiberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FiberDao extends JpaRepository<FiberEntity, Long> {

    @Query(value = "Select * from fibers where fiber_id =:fiber_id", nativeQuery = true)
    FiberEntity getFiberInfo(Long fiber_id);
//
//    @Query(value = "Select COUNT(name) from Fibers where name =:fiber_nane", nativeQuery = true)
//    int findByName(String fiber_name);

    @Query(value = "SELECT * FROM farmers WHERE first_name like %:match% OR middle_name like %:match% OR last_name like %:match%", nativeQuery = true)
    List<FiberEntity> searchFiberByName(String match);

    @Query(value = "SELECT name FROM fibers where fiber_id=:fiber id", nativeQuery = true)
    FiberEntity getFiberName(Long fiber_id);

    @Query(value = "SELECT grade FROM fibers where fiber_id=:fiber id", nativeQuery = true)
    FiberEntity getFiberGrade(Long fiber_id);


}
