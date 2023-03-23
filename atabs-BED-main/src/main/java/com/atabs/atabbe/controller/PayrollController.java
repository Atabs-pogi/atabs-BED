package com.atabs.atabbe.controller;


import com.atabs.atabbe.dto.PayrollSummaryDTO;
import com.atabs.atabbe.entity.EmployeeEntity;
import com.atabs.atabbe.entity.PayrollEntity;
import com.atabs.atabbe.exception.NotFoundException;
import com.atabs.atabbe.model.Payroll;
import com.atabs.atabbe.model.MandatoryDeduction;
import com.atabs.atabbe.model.OtherDeduction;
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
@RequestMapping("payroll")
@CrossOrigin
public class PayrollController {

    @Autowired
    private PayrollService service;

    @GetMapping("/review")
    public ResponseEntity<List<EmployeeEntity>> getEmployeePayrollStatus(
            @RequestParam("start") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate periodStart,
            @RequestParam("end") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate periodEnd){
        return new ResponseEntity<>(service.getEmployeePayrollStatus(periodStart, periodEnd), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<PayrollEntity> createEmployeePayroll(@RequestBody Payroll payroll) throws NotFoundException {
        return new ResponseEntity<>(service.createPayroll(payroll), HttpStatus.OK);
    }

    @PostMapping("/mandatoryDeduction")
    public ResponseEntity<PayrollEntity> saveMandatoryDeduction(@RequestBody List<MandatoryDeduction> mandatoryDeductions) throws NotFoundException {
        return new ResponseEntity<>(service.saveMandatoryDeduction(mandatoryDeductions), HttpStatus.OK);
    }

    @PostMapping("/otherDeduction")
    public ResponseEntity<PayrollEntity> saveOtherDeduction(@RequestBody List<OtherDeduction> otherDeductions) throws NotFoundException {
        return new ResponseEntity<>(service.saveOtherDeduction(otherDeductions), HttpStatus.OK);
    }

    @GetMapping("/employee")
    public ResponseEntity<PayrollEntity> getEmployeePayrollByPeriod(
            @RequestParam("empId") Long empId,
            @RequestParam("start") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate periodStart,
            @RequestParam("end") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate periodEnd)
    {
        return new ResponseEntity<>(service.getEmployeePayrollByPeriod(empId, periodStart, periodEnd), HttpStatus.OK);
    }

    @GetMapping("/employees")
    public ResponseEntity<List<PayrollEntity>> getAllEmployeesPayrollByPeriod(
            @RequestParam("start") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate periodStart,
            @RequestParam("end") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate periodEnd)
    {
        return new ResponseEntity<>(service.getAllEmployeesPayrollByPeriod(periodStart, periodEnd), HttpStatus.OK);
    }

    @GetMapping("/summary")
    public ResponseEntity<PayrollSummaryDTO> getPayrollSummary(
            @RequestParam("start") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate periodStart,
            @RequestParam("end") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate periodEnd) throws NotFoundException {
        return new ResponseEntity<>(service.getPayrollSummary(periodStart, periodEnd), HttpStatus.OK);
    }

    @GetMapping("/{period}")
    public ResponseEntity<List<PayrollEntity>> getAllByPeriod(@PathVariable(name = "period")String period){
        return new ResponseEntity<>(service.getAllByPeriod(parseStringDate(period)), HttpStatus.OK);
    }

    private LocalDate convertToLocalDate(Date dateToConvert) {
        if(dateToConvert == null) {
            return null;
        }
        return dateToConvert.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }

    private LocalDate parseStringDate(String period ) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(period, formatter);
    }
}
