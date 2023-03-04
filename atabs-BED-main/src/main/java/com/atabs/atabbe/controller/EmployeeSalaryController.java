package com.atabs.atabbe.controller;

import com.atabs.atabbe.entity.EmployeeEntity;
import com.atabs.atabbe.entity.EmployeeSalaryEntity;
import com.atabs.atabbe.entity.HolidayEntity;
import com.atabs.atabbe.entity.PayrollEntity;
import com.atabs.atabbe.exception.NotFoundException;
import com.atabs.atabbe.model.EmployeeSalary;
import com.atabs.atabbe.model.Payroll;
import com.atabs.atabbe.service.EmployeeSalaryService;
import com.atabs.atabbe.service.PayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("salary")
public class EmployeeSalaryController {

    @Autowired
    private EmployeeSalaryService service;
    @GetMapping("/")
    public ResponseEntity<List<EmployeeSalaryEntity>> getAllSalary(){
        return new ResponseEntity<>(service.getAllSalary(), HttpStatus.OK);
    }

    @GetMapping("/{empId}")
    public ResponseEntity<EmployeeSalaryEntity> getSalary(@PathVariable(name = "empId")Long empId) throws NotFoundException{
        return new ResponseEntity<>(service.getSalary(empId), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<EmployeeSalaryEntity> saveSalary(@RequestBody EmployeeSalary salary) throws NotFoundException {
        return new ResponseEntity<>(service.saveSalary(salary), HttpStatus.CREATED);
    }

    @PutMapping("/")
    public ResponseEntity<EmployeeSalaryEntity> updateSalary(@RequestBody EmployeeSalary salary) throws NotFoundException {
        return new ResponseEntity<>(service.updateSalary(salary), HttpStatus.CREATED);
    }
}
