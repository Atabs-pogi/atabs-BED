package com.atabs.atabbe.controller;

import com.atabs.atabbe.entity.BirTaxEntity;
import com.atabs.atabbe.service.BirTaxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("tax")
@CrossOrigin
public class BirTaxController {
    @Autowired
    private BirTaxService birTaxService;

    @GetMapping("/")
    public ResponseEntity<List<BirTaxEntity>> getAll(){
        return new ResponseEntity<>(birTaxService.getAll(), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<List<BirTaxEntity>> save(@RequestBody List<BirTaxEntity> birTax) {
        return new ResponseEntity<>(birTaxService.save(birTax), HttpStatus.CREATED);
    }

    @PutMapping("/")
    public ResponseEntity<BirTaxEntity>  update(@RequestBody BirTaxEntity birTax) {
        return new ResponseEntity<>(birTaxService.update(birTax), HttpStatus.CREATED);
    }

}
