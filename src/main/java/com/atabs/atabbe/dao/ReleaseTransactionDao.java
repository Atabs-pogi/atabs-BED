package com.atabs.atabbe.dao;

import com.atabs.atabbe.entity.ReleaseTransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ReleaseTransactionDao extends JpaRepository<ReleaseTransactionEntity, Long> {

    @Query(value = "SELECT * FROM release_transaction WHERE release_transaction_id=:release_id", nativeQuery = true)
    ReleaseTransactionEntity getReleaseInfo(Long release_id);

}