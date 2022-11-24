package com.atabs.atabbe.dao;


import com.atabs.atabbe.entity.FiberEntity;
import com.atabs.atabbe.entity.PosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PosDao extends JpaRepository<PosEntity,Long> {


}
