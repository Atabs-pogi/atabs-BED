package com.atabs.atabbe.controller;

import com.atabs.atabbe.entity.FiberEntity;
import com.atabs.atabbe.model.Fiber;
import com.atabs.atabbe.model.UpdateTuxy;
import com.atabs.atabbe.service.FiberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("fiberX")
@CrossOrigin
public class FiberController {

    @Autowired
    private FiberService fiberService;

//    @GetMapping("/search")
//    public ResponseEntity<FiberEntity> search(@RequestParam("name") String name) {
//        return new ResponseEntity(fiberService.searchByName(name), HttpStatus.OK);
//    }

    @GetMapping("/getFiber/{id}")
    public ResponseEntity<FiberEntity> getFiberByID(@PathVariable(value = "id") Long id) {
        return new ResponseEntity<>(fiberService.getFiberInfo(id), HttpStatus.OK);
    }

    @PostMapping("/addFiber")
    public ResponseEntity<String> addFiber(@RequestBody Fiber fiber) {
        return new ResponseEntity<>(fiberService.addFiber(fiber), HttpStatus.CREATED);
    }

    @PostMapping("/addFibers")
    public ResponseEntity addFiber(@RequestBody FiberEntity fiberEntity) {
        return new ResponseEntity<>(fiberService.addFiber(fiberEntity), HttpStatus.CREATED);
    }

    @PutMapping("/updateFiber")
    public ResponseEntity updateFiber(@RequestBody UpdateTuxy updateTuxy) {
        return new ResponseEntity<>(fiberService.updateFiber(updateTuxy), HttpStatus.OK);
    }

    @GetMapping("/getFiberGrade/{name}")
    public ResponseEntity<String> getFiberGrade(@PathVariable(value = "name") String name){
        return new ResponseEntity<>(fiberService.getFiberGrade(name),HttpStatus.OK);
    }

    @GetMapping("getAllFibers")
    public List<FiberEntity> findAllFibers(){
        return fiberService.getFibers();
    }

}
