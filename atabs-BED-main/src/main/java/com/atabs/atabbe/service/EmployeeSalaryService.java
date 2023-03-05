package com.atabs.atabbe.service;

import com.atabs.atabbe.dao.EmployeeDao;
import com.atabs.atabbe.dao.EmployeeSalaryDao;
import com.atabs.atabbe.entity.EmployeeEntity;
import com.atabs.atabbe.entity.EmployeeSalaryEntity;
import com.atabs.atabbe.entity.HolidayEntity;
import com.atabs.atabbe.exception.NotFoundException;
import com.atabs.atabbe.model.EmployeeSalary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeSalaryService {

    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private EmployeeSalaryDao salaryDao;

    public List<EmployeeSalaryEntity> getAllSalary() {
        return salaryDao.findAll();
    }

    public EmployeeSalaryEntity getSalary(long empId) throws NotFoundException {
        EmployeeEntity employee =  employeeDao.findById(empId).orElse(null);
        if(employee == null){
            throw new NotFoundException("Employee not found");
        }
        return salaryDao.getSalaryByEmployeeId(empId);
    }

    public EmployeeSalaryEntity saveSalary(EmployeeSalary salary) throws NotFoundException {
        EmployeeEntity employee =  employeeDao.findById(salary.getEmployeeId()).orElse(null);
        if(employee == null){
            throw new NotFoundException("Employee not found");
        }
        EmployeeSalaryEntity salaryEntity = salaryDao.getSalaryByEmployeeId(salary.getEmployeeId());
        if (salaryEntity != null) {
            throw new NotFoundException("Employee Salary already exist");
        }
        EmployeeSalaryEntity entity = new EmployeeSalaryEntity();
        entity.setEffDate(salary.getEffDate());
        entity.setExpDate(salary.getExpDate());
        entity.setDailyBasic(salary.getDailyBasic());
        entity.setMonthlyBasic(salary.getMonthlyBasic());
        entity.setBankAccountInfo(salary.getBankAccountInfo());
        entity.setTaxInfo(salary.getTaxInfo());
        entity.setEmployee(employee);
        salaryDao.save(entity);
        return entity;
    }

    public EmployeeSalaryEntity updateSalary(EmployeeSalary salary) throws NotFoundException {
        EmployeeEntity employee =  employeeDao.findById(salary.getEmployeeId()).orElse(null);
        if(employee == null){
            throw new NotFoundException("Employee not found");
        }
        EmployeeSalaryEntity salaryEntity = salaryDao.getSalaryByEmployeeId(salary.getEmployeeId());
        if (salaryEntity == null) {
            throw new NotFoundException("Employee Salary not found");
        }
        EmployeeSalaryEntity entity = new EmployeeSalaryEntity();
        entity.setEffDate(salary.getEffDate());
        entity.setExpDate(salary.getExpDate());
        entity.setDailyBasic(salary.getDailyBasic());
        entity.setMonthlyBasic(salary.getMonthlyBasic());
        entity.setBankAccountInfo(salary.getBankAccountInfo());
        entity.setTaxInfo(salary.getTaxInfo());
        entity.setEmployee(employee);
        salaryDao.save(entity);
        return entity;
    }
}
