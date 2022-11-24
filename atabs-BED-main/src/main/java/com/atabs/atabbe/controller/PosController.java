package com.atabs.atabbe.controller;

import com.atabs.atabbe.entity.PosEntity;
import com.atabs.atabbe.model.Pos;
import com.atabs.atabbe.service.PosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("Pos")
@CrossOrigin
public class PosController {

    @Autowired
    private PosService posService;

    @PostMapping("/addPos")
    public ResponseEntity addPos(@RequestBody Pos pos){
        double total = pos.getKilogram() * pos.getPrice();
        pos.setTotal(total);
        return new ResponseEntity(posService.addPos(pos), HttpStatus.CREATED);
    }
}
