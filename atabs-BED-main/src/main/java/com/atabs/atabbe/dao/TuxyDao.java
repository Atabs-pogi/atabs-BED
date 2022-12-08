package com.atabs.atabbe.dao;

import com.atabs.atabbe.entity.TuxyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TuxyDao extends JpaRepository<TuxyEntity, Long> {

}
