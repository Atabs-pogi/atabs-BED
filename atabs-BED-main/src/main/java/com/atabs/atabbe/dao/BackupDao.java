package com.atabs.atabbe.dao;

import com.atabs.atabbe.entity.AccountEntity;
import com.atabs.atabbe.entity.DatabaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BackupDao extends JpaRepository<DatabaseEntity, Long> {

    @Query(value = "SELECT * FROM coop.backup",nativeQuery = true)
    List<DatabaseEntity> getDBList();
}
