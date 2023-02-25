package com.atabs.atabbe.controller;

import com.atabs.atabbe.model.Attendance;
import com.atabs.atabbe.service.AccountService;
import com.atabs.atabbe.service.AttendaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("attendance")
@CrossOrigin
public class AttendanceController {
    @Autowired
    private AttendaceService attendaceService;

    @PostMapping
    private ResponseEntity timeIn(@RequestBody Attendance attendance){
        return new ResponseEntity(attendaceService.timeIn(attendance), HttpStatus.OK);

    }
}
