package com.atabs.atabbe.controller;

import com.atabs.atabbe.entity.BillsStatementEntity;
import com.atabs.atabbe.entity.BillsTransaction;
import com.atabs.atabbe.exception.NotFoundException;
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

    @GetMapping("/search")
    public ResponseEntity search(@RequestParam("name") String name) {
        return new ResponseEntity(billsStatementService.searchBillsByName(name), HttpStatus.OK);
    }


    @GetMapping("/getList")
    public ResponseEntity getList() {
        return new ResponseEntity(billsStatementService.getListName(), HttpStatus.OK);
    }



    @PostMapping("/save")
    public ResponseEntity addBillTransaction(@RequestBody BillsTransaction transactions) {
        try {
            return new ResponseEntity(billsStatementService.addReleaseTransaction(transactions), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/all")
    public ResponseEntity getAllBulk() {

        try {
            return new ResponseEntity(billsStatementService.getAll(), HttpStatus.OK);
        } catch (NotFoundException n) {
            return new ResponseEntity(n.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



}
