package com.atabs.atabbe.dao;

import com.atabs.atabbe.entity.FiberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FiberDao extends JpaRepository<FiberEntity, Long> {

    @Query(value = "SELECT * FROM fibers WHERE fiber_id =:fiber_id", nativeQuery = true)
    FiberEntity getFiberInfo(Long fiber_id);
    @Query(value = "SELECT COUNT(1) FROM fibers WHERE name=:name AND grade=:grade", nativeQuery = true)
    int findDuplicate(String name, String grade);
    @Query(value = "SELECT price FROM fibers WHERE fiber_id =:id", nativeQuery = true)
    double findOldPrice(long id);
    @Query(value = "SELECT * FROM fibers WHERE name like %:match% OR price like %:match% OR grade like %:match%", nativeQuery = true)
    List<FiberEntity> searchFiberByName(String match);

}
