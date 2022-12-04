package com.atabs.atabbe.controller;


import com.atabs.atabbe.dao.CreditDao;
import com.atabs.atabbe.model.Credit;
import com.atabs.atabbe.service.CreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("credit")
@CrossOrigin
public class CreditController {

    @Autowired
    private CreditService creditService;

    @PostMapping("/addBal")
    public ResponseEntity addBal(@RequestBody Credit credit) {
        return new ResponseEntity(creditService.addBal(credit), HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity search(@RequestParam("name") String name) {
        return new ResponseEntity(creditService.searchCreditByName(name), HttpStatus.OK);
    }
}
