package com.atabs.atabbe.controller;



import com.atabs.atabbe.entity.TuxyEntity;
import com.atabs.atabbe.entity.TuxyLogsEntity;
import com.atabs.atabbe.model.UpdateTuxy;
import com.atabs.atabbe.service.TuxyLogService;
import com.atabs.atabbe.service.TuxyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("updateLogs")
@CrossOrigin
public class UpdateLogsController {

    @Autowired
    private TuxyLogService tuxyService;

    @PostMapping("/add")
    public ResponseEntity addTuxy(@RequestBody UpdateTuxy updateTuxy) {
        return new ResponseEntity(tuxyService.save(updateTuxy), HttpStatus.CREATED);
    }


    @GetMapping("/get")
    public ResponseEntity getTuxy() {
        return new ResponseEntity(tuxyService.get(), HttpStatus.CREATED);
    }






}
