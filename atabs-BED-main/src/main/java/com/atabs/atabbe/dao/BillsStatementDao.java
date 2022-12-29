package com.atabs.atabbe.dao;

import com.atabs.atabbe.entity.BillsStatementEntity;
import com.atabs.atabbe.entity.MerchantProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BillsStatementDao extends JpaRepository<BillsStatementEntity, Long> {
    @Query(value = "Select * from bills where id =:bills_id", nativeQuery = true)
    BillsStatementEntity getBillsInfo(Long bills_id);

}
