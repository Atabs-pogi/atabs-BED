package com.atabs.atabbe.controller;

import com.atabs.atabbe.entity.FiberNewEntity;
import com.atabs.atabbe.exception.NotFoundException;
import com.atabs.atabbe.model.Fiber;
import com.atabs.atabbe.model.FiberNew;
import com.atabs.atabbe.service.FiberNewService;
import com.atabs.atabbe.service.FiberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("fiber")
@CrossOrigin
public class FiberNewController {
    @Autowired
    private FiberNewService fiberNewService;

    @PostMapping("/generateFiber")
    private ResponseEntity generateFiber(@RequestBody FiberNew fiberNew) throws NotFoundException {
        return new ResponseEntity(fiberNewService.generateFiber(fiberNew), HttpStatus.OK);
    }

    @PostMapping("/UpdateFiber")
    private ResponseEntity UpdateFiber(@RequestBody FiberNew fiberNew) {
        return new ResponseEntity(fiberNewService.updateFiber(fiberNew), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity getFiberByID(@PathVariable("id") long id) throws NotFoundException {
        return new ResponseEntity(fiberNewService.getFiberByID(id), HttpStatus.OK);
    }
    @GetMapping("/search")
    public ResponseEntity search(@RequestParam("name") String name) {
        return new ResponseEntity(fiberNewService.searchFiberByName(name), HttpStatus.OK);
    }


}
