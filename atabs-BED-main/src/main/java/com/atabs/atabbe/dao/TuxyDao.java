package com.atabs.atabbe.dao;

import com.atabs.atabbe.entity.FarmerEntity;
import com.atabs.atabbe.entity.TuxyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TuxyDao extends JpaRepository<TuxyEntity, Long> {

    @Query(value = "SELECT * FROM tuxy WHERE name like %:match%", nativeQuery = true)
    List<TuxyEntity> searchByName(String match);
}
