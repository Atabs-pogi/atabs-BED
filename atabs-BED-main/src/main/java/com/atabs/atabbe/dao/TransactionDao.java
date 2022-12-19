package com.atabs.atabbe.dao;


import com.atabs.atabbe.entity.PosEntity;
import com.atabs.atabbe.entity.TransactionEntity;
import com.atabs.atabbe.entity.TuxyLogsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface TransactionDao extends JpaRepository<TransactionEntity, Long> {





}
