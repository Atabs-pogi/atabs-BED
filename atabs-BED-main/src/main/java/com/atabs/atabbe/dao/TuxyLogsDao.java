package com.atabs.atabbe.dao;


import com.atabs.atabbe.entity.TuxyLogsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

public interface TuxyLogsDao extends JpaRepository<TuxyLogsEntity,Long> {

    @Query(value = "SELECT * FROM tuxy_log WHERE tuxy_name like %:match% OR create_date like %:match% order by create_date DESC" , nativeQuery = true)
    List<TuxyLogsEntity> searchByName(String match);

    @Query(value = "SELECT * FROM tuxy_log WHERE create_date BETWEEN :startDate AND :endDate", nativeQuery = true)
    List<TuxyLogsEntity> findByCreateDateBetween(LocalDateTime startDate, LocalDateTime endDate);

    @Query(value = "SELECT * FROM tuxy_log WHERE id =:id", nativeQuery = true)
    List<TuxyLogsEntity> getDetails(Long id);
}
