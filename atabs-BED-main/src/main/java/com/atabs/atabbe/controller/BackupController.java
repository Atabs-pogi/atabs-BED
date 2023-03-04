package com.atabs.atabbe.controller;


import com.atabs.atabbe.service.BackupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("backup")
@CrossOrigin
public class BackupController {

    @Autowired
    private BackupService backupService;

    @GetMapping("/save")
    public ResponseEntity backupDB() {
        return new ResponseEntity<>(backupService.backUp(), HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity getList() {
        return new ResponseEntity<>(backupService.getBackUpDB(), HttpStatus.OK);
    }

}