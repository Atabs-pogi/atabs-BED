package com.atabs.atabbe.controller;


import com.atabs.atabbe.entity.TransactionEntity;
import com.atabs.atabbe.model.Pos;
import com.atabs.atabbe.service.PosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("pos")
@CrossOrigin
public class PosController {

    @Autowired
    private PosService posService;




    @PostMapping("/addPos")
    public ResponseEntity<Object> addPosBulk(@RequestBody Pos pos) {
        return new ResponseEntity<>(posService.bulkTransactionInsert(pos), HttpStatus.CREATED);
    }

    @GetMapping("/search")
    public ResponseEntity<java.util.List<Pos>> search(@RequestParam("name") String name) {
        return new ResponseEntity<>(posService.searchPosByName(name), HttpStatus.OK);
    }

    @PutMapping("/updatePos")
    public ResponseEntity<Pos> update(@RequestBody Pos pos) {
        return new ResponseEntity<>(posService.updatePos(pos), HttpStatus.OK);
    }

    @GetMapping("/getPos/{id}")
    public ResponseEntity<com.atabs.atabbe.entity.PosEntity> getAccountByID(@PathVariable(value = "id") Long id) {
        return new ResponseEntity<>(posService.getPosInfo(id), HttpStatus.OK);
    }


    @PostMapping("/save")
    public ResponseEntity<String> addPosBulk(@RequestBody TransactionEntity transactionEntity) {
        return new ResponseEntity<>(posService.save(transactionEntity), HttpStatus.CREATED);
    }

    @GetMapping("/save")
    public ResponseEntity<String> getAllBulk(@RequestBody TransactionEntity transactionEntity) {
        return new ResponseEntity<>(posService.save(transactionEntity), HttpStatus.CREATED);
    }


}
