package com.atabs.atabbe.dao;

import com.atabs.atabbe.entity.TuxyEntity;
import com.atabs.atabbe.entity.TuxyLogsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TuxyLogsDao extends JpaRepository<TuxyLogsEntity,Long> {


    @Query(value = "SELECT * FROM tuxy_log WHERE tuxy_name like %:match% OR create_date like %:match% order by create_date DESC" , nativeQuery = true)
    List<TuxyLogsEntity> searchByName(String match);
}
