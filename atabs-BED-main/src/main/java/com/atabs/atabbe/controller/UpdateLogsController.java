package com.atabs.atabbe.controller;



import com.atabs.atabbe.model.UpdateTuxy;
import com.atabs.atabbe.service.TuxyLogService;
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
        return new ResponseEntity(tuxyService.AddLogs(updateTuxy), HttpStatus.CREATED);
    }

    
    @GetMapping("/search")
    public ResponseEntity search(@RequestParam("name") String name) {
        return new ResponseEntity(tuxyService.searchByName(name), HttpStatus.CREATED);
    }






}
