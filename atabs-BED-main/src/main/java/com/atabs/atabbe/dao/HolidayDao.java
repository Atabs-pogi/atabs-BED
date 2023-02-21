package com.atabs.atabbe.dao;

import com.atabs.atabbe.entity.HolidayEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface HolidayDao extends JpaRepository<HolidayEntity, Long> {


    @Query(value = "SELECT * FROM holiday WHERE date between :start AND :end", nativeQuery = true)
    public List<HolidayEntity>getHolidaysBetween(LocalDate start, LocalDate end);

}
