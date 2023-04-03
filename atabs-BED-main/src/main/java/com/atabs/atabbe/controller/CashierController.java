package com.atabs.atabbe.controller;

import com.atabs.atabbe.entity.CashierEntity;
import com.atabs.atabbe.model.Cashier;
import com.atabs.atabbe.service.CashierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("cashier")
@CrossOrigin
public class CashierController {
    @Autowired
    private CashierService cashierService;

    @PostMapping("/addCashier")
    public ResponseEntity<String> addCashier(@RequestBody Cashier cashier) {
        return new ResponseEntity<>(cashierService.addCashier(cashier), HttpStatus.OK);
    }
    @GetMapping("/search")
    public ResponseEntity<java.util.List<Cashier>> search(@RequestParam("name") String name) {
        return new ResponseEntity(cashierService.searchCashierByName(name), HttpStatus.OK);
    }
    @GetMapping("/getCashier/{id}")
    public ResponseEntity<CashierEntity> getAccountByID(@PathVariable(value = "id") Long id) {
        return new ResponseEntity<>(cashierService.getCashierInfo(id), HttpStatus.OK);
    }
}
