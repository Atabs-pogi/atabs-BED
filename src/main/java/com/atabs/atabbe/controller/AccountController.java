package com.atabs.atabbe.controller;

import com.atabs.atabbe.model.Account;
import com.atabs.atabbe.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("login")
@CrossOrigin
public class AccountController {
    @Autowired
    private AccountService accountService;

    @PostMapping("/authenticate")
    public ResponseEntity authenticate(@RequestBody Account account){
        return new ResponseEntity(accountService.authenticate(account), HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity search(@RequestParam("username") String username){
        return new ResponseEntity(accountService.searchAccountByUsername(username), HttpStatus.OK);
    }

    @GetMapping("/getAccount/{id}")
    public ResponseEntity getAccountByID(@PathVariable(value = "id") Long id){
        return new ResponseEntity(accountService.getAccountInfo(id), HttpStatus.OK);
    }

    @PostMapping("/addAccount")
    public ResponseEntity addAccount(@RequestBody Account account){
        return new ResponseEntity(accountService.addAccount(account), HttpStatus.CREATED);
    }

    @PutMapping("/updateAccount")
    public ResponseEntity updateAccount (@RequestBody Account account){
        return new ResponseEntity(accountService.updateAccount(account), HttpStatus.OK);
    }
}