package com.atabs.atabbe.controller;

import com.atabs.atabbe.entity.EmployeeEntity;
import com.atabs.atabbe.entity.FarmerEntity;
import com.atabs.atabbe.exception.NotFoundException;
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
import java.util.List;
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
    public ResponseEntity addEmployee(@RequestBody Employee employee) {

        try {
            return new ResponseEntity(employeeService.addEmployee(employee), HttpStatus.CREATED);
        } catch (NotFoundException n) {
            return new ResponseEntity(n.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/updateEmployee")
    public ResponseEntity updateEmployee(@RequestBody Employee employee) {
        return new ResponseEntity(employeeService.updateEmployee(employee), HttpStatus.OK);
    }
    @GetMapping("/getEmployeeCount")
    public ResponseEntity getEmployeeCount() {
        return new ResponseEntity(employeeService.employeeCount(), HttpStatus.OK);
    }

    @GetMapping("/getAllEmployee")
    public List<EmployeeEntity> findAllEmployee(){
        return employeeService.getEmployee();
    }
}