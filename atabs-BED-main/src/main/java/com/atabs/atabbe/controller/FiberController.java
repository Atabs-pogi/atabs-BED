package com.atabs.atabbe.controller;

import com.atabs.atabbe.entity.FiberEntity;
import com.atabs.atabbe.model.Fiber;
import com.atabs.atabbe.service.FiberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("fiber")
public class FiberController {

    @Autowired
    private FiberService fiberService;

    @GetMapping("/search")
    public ResponseEntity<java.util.List<Fiber>> search(@RequestParam("name") String name) {
        return new ResponseEntity<>(fiberService.searchFiberByName(name), HttpStatus.OK);
    }

    @GetMapping("/getFiber/{id}")
    public ResponseEntity<FiberEntity> getFiberByID(@PathVariable(value = "id") Long id) {
        return new ResponseEntity<>(fiberService.getFiberInfo(id), HttpStatus.OK);
    }

    @PostMapping("/addFiber")
    public ResponseEntity<String> addFiber(@RequestBody Fiber fiber) {
        return new ResponseEntity<>(fiberService.addFiber(fiber), HttpStatus.CREATED);
    }

    @PutMapping("/updateFiber")
    public ResponseEntity<FiberEntity> updateFiber(@RequestBody FiberEntity fiber) {
        return new ResponseEntity<>(fiberService.updateFiber(fiber), HttpStatus.OK);
    }

    @GetMapping("/getFiberName/{id}")
    public ResponseEntity<FiberEntity> getFiberByName(@PathVariable(value = "id") Long id) {
        return new ResponseEntity<>(fiberService.getFiberName(id), HttpStatus.OK);
    }

    @GetMapping("/getFiberGrade/{id}")
    public ResponseEntity<FiberEntity> getFiberByGrade(@PathVariable(value = "id") Long id) {
        return new ResponseEntity<>(fiberService.getFiberGrade(id), HttpStatus.OK);
    }
}
