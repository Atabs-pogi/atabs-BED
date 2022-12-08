package com.atabs.atabbe.service;

import com.atabs.atabbe.dao.AccountDao;
import com.atabs.atabbe.entity.AccountEntity;
import com.atabs.atabbe.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountService {
    @Autowired
    private AccountDao accountDao;

    public AccountEntity authenticate(Account account) {
        String username = account.getUsername();
        String secret = account.getPassword();
        AccountEntity result = accountDao.getUserLogin(username, secret);
        if (result != null){
            return result;
        }else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST , "Invalid User");
        }
    }

    public AccountEntity getIdByUsername(String username){
        return accountDao.findByUsername(username);
    }

    public List<Account> searchAccountByUsername(String username){
        List<AccountEntity> entityAccounts = (List<AccountEntity>) accountDao.searchAccountByUsername(username);
        List<Account> accounts = new ArrayList<>();
        for (AccountEntity account: entityAccounts) {
            accounts.add(Account.from(account));
        }
        return accounts;
    }

    public AccountEntity getAccountInfo(long acc_id) {
        return accountDao.getAccountInfo(acc_id);
    }

    public String addAccount(Account account){
        AccountEntity accountEntity = new AccountEntity();
        int accountExist = accountDao.findAccountByUsername(account.getUsername());
        if (accountExist > 0) {
            throw new IllegalStateException("username taken");
        } else {
            accountEntity.setUsername(account.getUsername());
            accountEntity.setPassword(account.getPassword());
            accountEntity.setRole(account.getRole());
            accountDao.save(accountEntity);
            return "Successful";
        }
    }

    public Account updateAccount(Account account) {
        AccountEntity accountEntity = accountDao.findById(account.getId()).orElse(null);
        System.out.println(account.getRole());
        if (accountEntity != null) {
            accountEntity.setId(account.getId());
            accountEntity.setUsername(account.getUsername());
            accountEntity.setPassword(account.getPassword());
            accountEntity.setRole(account.getRole());
            accountEntity.setStatus(account.getStatus());
            accountDao.save(accountEntity);
            return account;
        }else {
            throw new IllegalStateException("This ID cannot be found");
        }
    }
}