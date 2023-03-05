package com.atabs.atabbe.dao;

import com.atabs.atabbe.entity.AttendanceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttendanceDao extends JpaRepository<AttendanceEntity, Long> {

}
