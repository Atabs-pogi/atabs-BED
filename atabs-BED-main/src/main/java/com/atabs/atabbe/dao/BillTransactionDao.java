package com.atabs.atabbe.dao;

import com.atabs.atabbe.entity.BillsStatementEntity;
import com.atabs.atabbe.entity.BillsTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillTransactionDao extends JpaRepository<BillsTransaction, Long> {
//    @Query(value = "Select * from bills where id =:bills_id", nativeQuery = true)
//    BillsStatementEntity getBillsInfo(Long bills_id);
//    @Query(value = "SELECT * FROM bills WHERE name like %:match% OR type like %:match% ", nativeQuery = true)
//    List<BillsStatementEntity> searchBillsByName(String match);
//
//
//    @Query(value = "SELECT name FROM bills order by name asc", nativeQuery = true)
//    List<String> listName();
}
