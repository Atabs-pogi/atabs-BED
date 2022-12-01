package com.atabs.atabbe.dao;

import com.atabs.atabbe.entity.FiberEntity;
import com.atabs.atabbe.entity.FiberUpdatesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FiberUpdatesDao extends JpaRepository<FiberUpdatesEntity, Long> {

//    @Query(value = "SELECT * FROM fibers WHERE fiber_id =:fiber_id", nativeQuery = true)
//    FiberEntity getFiberInfo(Long fiber_id);
//
//    @Query(value = "SELECT COUNT(1) FROM fibers WHERE name=:name AND grade=:grade", nativeQuery = true)
//    int findDuplicate(String name, String grade);
//
//    @Query(value = "SELECT * FROM fibers WHERE name like %:match% OR price like %:match% OR grade like %:match%", nativeQuery = true)
//    List<FiberEntity> searchFiberByName(String match);
}
