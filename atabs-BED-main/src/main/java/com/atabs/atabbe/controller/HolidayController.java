package com.atabs.atabbe.controller;
import com.atabs.atabbe.entity.HolidayEntity;
import com.atabs.atabbe.service.HolidayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("holiday")
public class HolidayController {

    @Autowired
    private HolidayService holidayService;


    @GetMapping("/")
    public ResponseEntity<List<HolidayEntity>> getAll(
        @RequestParam(name = "start", required = false) Date start,
        @RequestParam(name = "end", required = false) Date end
    ){
        return new ResponseEntity<>(holidayService.getAll(convertToLocalDate(start), convertToLocalDate(end)), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<List<HolidayEntity>> save(@RequestBody List<HolidayEntity> holidays) {
        return new ResponseEntity<>(holidayService.save(holidays), HttpStatus.CREATED);
    }

    private LocalDate convertToLocalDate(Date dateToConvert) {
        if(dateToConvert == null) {
            return null;
        }
        return dateToConvert.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }
}
