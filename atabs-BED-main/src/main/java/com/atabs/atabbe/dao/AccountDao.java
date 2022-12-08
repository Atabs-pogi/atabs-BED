package com.atabs.atabbe.dao;

import com.atabs.atabbe.entity.AccountEntity;
import com.atabs.atabbe.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountDao extends JpaRepository<AccountEntity, Long> {

    @Query(value = "SELECT * FROM Accounts WHERE username =:username", nativeQuery = true)
    AccountEntity findByUsername(String username);

    @Query(value = "SELECT COUNT(1) FROM Accounts WHERE binary username =:username AND binary password =:secret", nativeQuery = true)
    int getUserLogin(String username, String secret);

    @Query(value = "SELECT * FROM Accounts WHERE account_id =:acc_id", nativeQuery = true)
    AccountEntity getAccountInfo(Long acc_id);

    @Query(value = "SELECT COUNT(username) FROM Accounts WHERE username =:username", nativeQuery = true)
    int findAccountByUsername(String username);

    @Query(value = "SELECT * FROM Accounts WHERE username like %:match% OR role like %:match%", nativeQuery = true)
    List<AccountEntity> searchAccountByUsername(String match);
}
