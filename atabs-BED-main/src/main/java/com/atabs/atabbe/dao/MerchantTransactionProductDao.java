package com.atabs.atabbe.dao;


import com.atabs.atabbe.entity.TransactionMerchantEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MerchantTransactionProductDao extends JpaRepository<TransactionMerchantEntity, Long> {


}
