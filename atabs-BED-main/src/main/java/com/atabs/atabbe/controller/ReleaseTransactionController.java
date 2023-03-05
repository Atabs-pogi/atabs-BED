package com.atabs.atabbe.controller;

import com.atabs.atabbe.model.ReleaseTransaction;
import com.atabs.atabbe.service.ReleaseTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("releasetransaction")
@CrossOrigin
public class ReleaseTransactionController {

    @Autowired
    private ReleaseTransactionService releaseTransactionService;

    @PostMapping("/addReleaseTransaction")
    public ResponseEntity addReleaseTransaction(@RequestBody ReleaseTransaction releaseTransaction) {
        return new ResponseEntity(releaseTransactionService.addReleaseTransaction(releaseTransaction), HttpStatus.OK);
    }

    @GetMapping("/getReleaseTransaction/{id}")
    public ResponseEntity getAccountByID(@PathVariable(value = "id") Long id) {
        return new ResponseEntity(releaseTransactionService.getReleaseInfo(id), HttpStatus.OK);
    }
}
