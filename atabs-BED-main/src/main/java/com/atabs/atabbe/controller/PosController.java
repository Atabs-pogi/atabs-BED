package com.atabs.atabbe.controller;


import com.atabs.atabbe.dao.TransactionDao;
import com.atabs.atabbe.entity.TransactionEntity;
import com.atabs.atabbe.exception.NotFoundException;
import com.atabs.atabbe.model.Pos;
import com.atabs.atabbe.model.Transaction;
import com.atabs.atabbe.service.PosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("pos")
@CrossOrigin
public class PosController {

    @Autowired
    private PosService posService;




    @PostMapping("/addPos")
    public ResponseEntity addPosBulk(@RequestBody Pos pos) {
        return new ResponseEntity(posService.bulkTransactionInsert(pos), HttpStatus.CREATED);
    }

    @GetMapping("/search")
    public ResponseEntity search(@RequestParam("name") String name) {
        return new ResponseEntity(posService.searchPosByName(name), HttpStatus.OK);
    }

    @PutMapping("/updatePos")
    public ResponseEntity update(@RequestBody Pos pos) {
        return new ResponseEntity(posService.updatePos(pos), HttpStatus.OK);
    }

    @GetMapping("/getPos/{id}")
    public ResponseEntity getAccountByID(@PathVariable(value = "id") Long id) {
        return new ResponseEntity(posService.getPosInfo(id), HttpStatus.OK);
    }


    @PostMapping("/save")
    public ResponseEntity addPosBulk(@RequestBody Transaction transactions) {
        try {
            return new ResponseEntity(posService.insertTransaction(transactions), HttpStatus.CREATED);
        } catch (NotFoundException n) {
            return new ResponseEntity(n.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/all")
    public ResponseEntity getAllBulk() {
//        return new ResponseEntity(posService.save(transactionEntity), HttpStatus.CREATED);

        try {
            return new ResponseEntity(posService.getAll(), HttpStatus.CREATED);
        } catch (NotFoundException n) {
            return new ResponseEntity(n.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
