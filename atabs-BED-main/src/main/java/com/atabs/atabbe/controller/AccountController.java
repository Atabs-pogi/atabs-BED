package com.atabs.atabbe.controller;

import com.atabs.atabbe.entity.AccountEntity;
import com.atabs.atabbe.model.Account;
import com.atabs.atabbe.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("login")
@CrossOrigin
public class AccountController {
    @Autowired
    private AccountService accountService;

    @PostMapping("/authenticate")
    public ResponseEntity<com.atabs.atabbe.entity.AccountEntity> authenticate(@RequestBody Account account) {
        return new ResponseEntity<>(accountService.authenticate(account), HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<java.util.List<Account>> search(@RequestParam("username") String username) {
        return new ResponseEntity<>(accountService.searchAccountByUsername(username), HttpStatus.OK);
    }

    @GetMapping("/getAccount/{id}")
    public ResponseEntity<com.atabs.atabbe.entity.AccountEntity> getAccountByID(@PathVariable(value = "id") Long id) {
        return new ResponseEntity<>(accountService.getAccountInfo(id), HttpStatus.OK);
    }


    @PutMapping("/updateAccount")
    public ResponseEntity<Account> updateAccount(@RequestBody Account account) {
        return new ResponseEntity<>(accountService.updateAccount(account), HttpStatus.OK);
    }

    @PostMapping("/addAccount")
    public ResponseEntity<String> addAccount(@RequestBody Account account) {
        return new ResponseEntity<>(accountService.addAccount(account), HttpStatus.CREATED);
    }

    @GetMapping("/getAllAccount")
    public List<AccountEntity> findAllAccount(){
        return accountService.getAccount();
    }

}