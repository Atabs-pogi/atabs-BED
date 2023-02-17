package com.atabs.atabbe.controller;



import com.atabs.atabbe.entity.FiberEntity;
import com.atabs.atabbe.entity.TuxyEntity;
import com.atabs.atabbe.exception.NotFoundException;
import com.atabs.atabbe.model.UpdateTuxy;
import com.atabs.atabbe.service.FiberService;
import com.atabs.atabbe.service.TuxyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("tuxy")
@CrossOrigin
public class TuxyController {

    @Autowired
    private TuxyService tuxyService;

    @Autowired
    private FiberService fiberService;

    @PostMapping("/addTuxy")
    public ResponseEntity addTuxy(@RequestBody TuxyEntity tuxyEntity) {
        return new ResponseEntity(tuxyService.save(tuxyEntity), HttpStatus.CREATED);
    }


    @GetMapping("/getTuxyList")
    public ResponseEntity listTuxy() {
        return new ResponseEntity(tuxyService.getTuxyList(), HttpStatus.CREATED);
    }


    @PutMapping("/updateTuxy")
    public ResponseEntity updateTuxy(@RequestBody TuxyEntity tuxyEntity) {
        try {
            return new ResponseEntity<>(tuxyService.updateTuxy(tuxyEntity), HttpStatus.OK);
        } catch (NotFoundException n) {
            return new ResponseEntity(n.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/search")
    public ResponseEntity search(@RequestParam("name") String name) {
        return new ResponseEntity(tuxyService.searchByName(name), HttpStatus.OK);
    }
}
