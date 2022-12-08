package com.atabs.atabbe.controller;

import com.atabs.atabbe.entity.FarmerEntity;
import com.atabs.atabbe.helper.FileCreated;
import com.atabs.atabbe.model.Farmer;
import com.atabs.atabbe.service.FarmerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

@RestController
@RequestMapping("farmer")
@CrossOrigin
public class FarmerController {

    @Autowired
    private FarmerService farmerService;

    @GetMapping("/search")
    public ResponseEntity search(@RequestParam("name") String name) {
        return new ResponseEntity(farmerService.searchFarmerByName(name), HttpStatus.OK);
    }

    @GetMapping("/getFarmer/{id}")
    public ResponseEntity getFarmerByID(@PathVariable(value = "id") Long id) {
        return new ResponseEntity(farmerService.getFarmerInfo(id), HttpStatus.OK);
    }

    @PostMapping("/addFarmer")


    public ResponseEntity addFarmer(@RequestBody Farmer farmer) {
        return new ResponseEntity(farmerService.addFarmer(farmer), HttpStatus.CREATED);
    }

    @PutMapping("/updateFarmer")
    public ResponseEntity updateFarmer(@RequestBody Farmer farmer) {
        return new ResponseEntity(farmerService.updateFarmer(farmer), HttpStatus.OK);
    }

//    @PutMapping("/updateFarmer/{id}")
//    public ResponseEntity updateFarmer(@PathVariable(value = "id") long id, @RequestBody Farmer farmer){
//        return new ResponseEntity(farmerService.updateFarmer(id, farmer), HttpStatus.CREATED);
//    }

}
