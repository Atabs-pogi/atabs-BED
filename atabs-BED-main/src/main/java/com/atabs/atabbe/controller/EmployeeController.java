package com.atabs.atabbe.controller;

import com.atabs.atabbe.helper.FileCreated;
import com.atabs.atabbe.model.Account;
import com.atabs.atabbe.model.Employee;
import com.atabs.atabbe.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

@RestController
@RequestMapping("employee")
@CrossOrigin
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;


    @GetMapping("/search")
    public ResponseEntity search(@RequestParam("name") String name) {
        return new ResponseEntity(employeeService.searchEmployeeByName(name), HttpStatus.OK);
    }

    @GetMapping("/getEmployee/{id}")
    public ResponseEntity getEmployeeByID(@PathVariable(value = "id") Long id) {
        return new ResponseEntity(employeeService.getEmployeeInfo(id), HttpStatus.OK);
    }

    @PostMapping("/addEmployee")
    public ResponseEntity addEmployee(@RequestBody Employee employee, Account account) {
        return new ResponseEntity(employeeService.addEmployee(employee, account), HttpStatus.CREATED);
    }

    @PutMapping("/updateEmployee")
    public ResponseEntity updateEmployee(@RequestBody Employee employee) {
        return new ResponseEntity(employeeService.updateEmployee(employee), HttpStatus.OK);
    }
    @GetMapping("/getEmployeeCount")
    public ResponseEntity getEmployeeCount() {
        return new ResponseEntity(employeeService.employeeCount(), HttpStatus.OK);
    }
}