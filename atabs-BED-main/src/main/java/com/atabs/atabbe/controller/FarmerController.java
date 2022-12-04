package com.atabs.atabbe.controller;

import com.atabs.atabbe.entity.FarmerEntity;
import com.atabs.atabbe.model.Farmer;
import com.atabs.atabbe.service.FarmerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("farmer")
@CrossOrigin
public class FarmerController {

    @Autowired
    private FarmerService farmerService;

    @GetMapping("/search")
    public ResponseEntity<java.util.List<Farmer>> search(@RequestParam("name") String name) {
        return new ResponseEntity<>(farmerService.searchFarmerByName(name), HttpStatus.OK);
    }

    @GetMapping("/getFarmer/{id}")
    public ResponseEntity<FarmerEntity> getFarmerByID(@PathVariable(value = "id") Long id) {
        return new ResponseEntity<>(farmerService.getFarmerInfo(id), HttpStatus.OK);
    }

    @PostMapping("/addFarmer")
    public ResponseEntity<String> addFarmer(@RequestBody Farmer farmer) {
        return new ResponseEntity<>(farmerService.addFarmer(farmer), HttpStatus.CREATED);
    }

    @PutMapping("/updateFarmer")
    public ResponseEntity<Farmer> updateFarmer(@RequestBody Farmer farmer) {
        return new ResponseEntity<>(farmerService.updateFarmer(farmer), HttpStatus.OK);
    }

//    @PutMapping("/updateFarmer/{id}")
//    public ResponseEntity updateFarmer(@PathVariable(value = "id") long id, @RequestBody Farmer farmer){
//        return new ResponseEntity(farmerService.updateFarmer(id, farmer), HttpStatus.CREATED);
//    }

}
