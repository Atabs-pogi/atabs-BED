package com.atabs.atabbe.controller;


import com.atabs.atabbe.entity.TuxyEntity;
import com.atabs.atabbe.service.TuxyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("tuxy")
@CrossOrigin
public class TuxyController {

    @Autowired
    private TuxyService tuxyService;

    @PostMapping("/addTuxy")
    public ResponseEntity addTuxy(@RequestBody TuxyEntity tuxyEntity) {
        return new ResponseEntity(tuxyService.save(tuxyEntity), HttpStatus.CREATED);
    }


    @GetMapping("/getTuxyList")
    public ResponseEntity listTuxy() {
        return new ResponseEntity(tuxyService.getTuxyList(), HttpStatus.CREATED);
    }
}