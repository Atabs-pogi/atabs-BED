package com.atabs.atabbe.controller;

import com.atabs.atabbe.entity.FarmerEntity;
import com.atabs.atabbe.helper.FileCreated;
import com.atabs.atabbe.model.Farmer;
import com.atabs.atabbe.service.FarmerService;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    Logger log = LoggerFactory.getLogger(FarmerController.class);

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
    public ResponseEntity addFarmer(@ModelAttribute("farmer") Farmer farmer, @RequestParam("img") MultipartFile file) {
        Gson gson = new Gson();

        log.info("applicantInfo: "+ gson.toJson(farmer));
        log.info("key: "+ file);
        System.out.println("img " +  file.getName());
        StringBuilder filenames= new StringBuilder();
        String filename = farmer.getFirstName() + Objects.requireNonNull(file.getOriginalFilename()).substring(file.getOriginalFilename().length()-4);
        Path fileNameAndPath= Paths.get(FileCreated.uploadDirectory,filename);
        try {
            Files.write(fileNameAndPath,file.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        farmer.setfPhoto(filename);

        return new ResponseEntity(farmerService.addFarmer(farmer), HttpStatus.CREATED);
//        return new ResponseEntity("test", HttpStatus.CREATED);
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
