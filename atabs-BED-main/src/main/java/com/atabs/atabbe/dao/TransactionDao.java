package com.atabs.atabbe.dao;


import com.atabs.atabbe.entity.PosEntity;
import com.atabs.atabbe.entity.TransactionEntity;
import com.atabs.atabbe.entity.TuxyLogsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public interface TransactionDao extends JpaRepository<TransactionEntity, Long> {


    @Transactional
    @Modifying
    @Query(value = "Update transactions set status=:status, merchant_payment=:merchantPayment, release_date=:time where id=:transactionsId", nativeQuery = true)
    Integer updateTransaction(int status,double merchantPayment, long transactionsId, LocalDateTime time);




    @Query(value = "Select * from transactions where status=:status order by transactionDate DESC", nativeQuery = true)
    ArrayList<TransactionEntity> transactionList(int status);



}
