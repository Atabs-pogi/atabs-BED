package com.atabs.atabbe.controller;

import com.atabs.atabbe.entity.FarmerEntity;
import com.atabs.atabbe.model.Farmer;
import com.atabs.atabbe.service.FarmerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
//        return new ResponseEntity("test", HttpStatus.CREATED);
    }

    @PutMapping("/updateFarmer")
    public ResponseEntity updateFarmer(@RequestBody Farmer farmer) {
        return new ResponseEntity(farmerService.updateFarmer(farmer), HttpStatus.OK);
    }

    @GetMapping("/getFarmerCount")
    public ResponseEntity getFarmerCount() {
        return new ResponseEntity(farmerService.farmerCount(), HttpStatus.OK);
    }

    @GetMapping("/getAllFarmer")
    public List<FarmerEntity> findAllFarmer(){
        return farmerService.getFarmer();
    }
}
