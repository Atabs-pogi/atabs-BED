package com.atabs.atabbe.dao;

import com.atabs.atabbe.entity.TuxyLogsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TuxyLogsDao extends JpaRepository<TuxyLogsEntity,Long> {


//    @Query(value = "Select * from tuxy", nativeQuery = true)
//    TuxyLogsEntity getLogs;
}
