package com.atabs.atabbe.controller;

import com.atabs.atabbe.entity.FiberEntity;
import com.atabs.atabbe.model.Farmer;
import com.atabs.atabbe.model.Fiber;
import com.atabs.atabbe.service.FiberService;
import net.bytebuddy.description.type.TypeDescription;
import org.aspectj.bridge.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("fiber")
@CrossOrigin
public class FiberController {

    @Autowired
    private FiberService fiberService;

    @GetMapping("/search")
    public ResponseEntity search(@RequestParam("name") String name){
        return new ResponseEntity(fiberService.searchFiberByName(name), HttpStatus.OK);
    }

    @GetMapping("/getFiber/{id}")
    public ResponseEntity getFiberByID(@PathVariable(value = "id") Long id){
        return new ResponseEntity(fiberService.getFiberInfo(id), HttpStatus.OK);
    }

    @PostMapping("/addFiber")
    public ResponseEntity addFiber(@RequestBody Fiber fiber){
        return new ResponseEntity(fiberService.addFiber(fiber), HttpStatus.CREATED);
    }

    @PutMapping("/updateFiber")
    public ResponseEntity updateFiber (@RequestBody FiberEntity fiber){
        return new ResponseEntity(fiberService.updateFiber(fiber), HttpStatus.OK);
    }
}
