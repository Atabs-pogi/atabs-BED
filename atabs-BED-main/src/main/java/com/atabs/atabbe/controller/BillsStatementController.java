package com.atabs.atabbe.controller;

import com.atabs.atabbe.entity.BillsStatementEntity;
import com.atabs.atabbe.model.BillsStatement;
import com.atabs.atabbe.service.BillsStatementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("bills")
@CrossOrigin
public class BillsStatementController {
    @Autowired
    private BillsStatementService billsStatementService;

    @PostMapping("/addBills")
    public ResponseEntity<String> addAccount(@RequestBody BillsStatement billsStatement) {
        return new ResponseEntity<>(billsStatementService.addBills(billsStatement), HttpStatus.CREATED);

    }

    @GetMapping("/getAllBills")
    public List<BillsStatementEntity> findAllBills(){
        return billsStatementService.getBills();
    }

    @PutMapping("/updateBills")
    public ResponseEntity updateProduct(@RequestBody BillsStatement billsStatement){
        return new ResponseEntity(billsStatementService.updateBills(billsStatement), HttpStatus.OK);
    }
}
