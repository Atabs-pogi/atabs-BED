package com.atabs.atabbe.dao;

import com.atabs.atabbe.entity.BillsStatementEntity;
import com.atabs.atabbe.entity.MerchantProductEntity;
import com.atabs.atabbe.entity.PosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillsStatementDao extends JpaRepository<BillsStatementEntity, Long> {
    @Query(value = "Select * from bills where id =:bills_id", nativeQuery = true)
    BillsStatementEntity getBillsInfo(Long bills_id);
    @Query(value = "SELECT * FROM bills WHERE vendorName like %:match% OR billType like %:match% ", nativeQuery = true)
    List<BillsStatementEntity> searchBillsByName(String match);


    @Query(value = "SELECT vendorName FROM bills order by vendorName ASC", nativeQuery = true)
    List<String> listName();
}
