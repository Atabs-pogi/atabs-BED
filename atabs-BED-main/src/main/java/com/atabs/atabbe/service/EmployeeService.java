package com.atabs.atabbe.service;

import com.atabs.atabbe.dao.AccountDao;
import com.atabs.atabbe.dao.EmployeeDao;
import com.atabs.atabbe.entity.AccountEntity;
import com.atabs.atabbe.entity.EmployeeEntity;
import com.atabs.atabbe.entity.FarmerEntity;
import com.atabs.atabbe.exception.NotFoundException;
import com.atabs.atabbe.helper.Message;
import com.atabs.atabbe.model.Account;
import com.atabs.atabbe.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeDao employeeDao;

    public List<Employee> searchEmployeeByName(String name) {
        List<EmployeeEntity> entityEmployees = (List<EmployeeEntity>) employeeDao.searchEmployeeByName(name);
        List<Employee> employees = new ArrayList<>();
        for (EmployeeEntity employee : entityEmployees) {
            employees.add(Employee.from(employee));
        }
        return employees;
    }

    public List<EmployeeEntity> getEmployee() {
        return employeeDao.findAll();
    }

    public EmployeeEntity getEmployeeInfo(long emp_id) {
        return employeeDao.getEmployeeInfo(emp_id);
    }

    public String addEmployee(Employee employee) throws Exception {
        try {
            EmployeeEntity employeeEntity = new EmployeeEntity();
            int emailExist = employeeDao.findEmployeeByEmail(employee.getEmail());
            if (emailExist > 0) {
                throw new NotFoundException(Message.ERROR_MESSAGE_FOR_IST_EXIST.replace("<object>","email"));

            } else {
                employeeEntity.setId(employee.getId());
                employeeEntity.setFirstName(employee.getFirstName());
                employeeEntity.setMiddleName(employee.getMiddleName());
                employeeEntity.setLastName(employee.getLastName());
                employeeEntity.setBirthday(employee.getBirthday());
                employeeEntity.setMobileNumber(employee.getMobileNumber());
                employeeEntity.setEmail(employee.getEmail());
                employeeEntity.setImageLocation(employee.getImageLocation());
                employeeEntity.setPostalCode(employee.getPostalCode());
                if (employee.getAddress() != null)
                    employeeEntity.setAddress(employee.getAddress().toString());
                employeeEntity.setSex(employee.getSex());
                employeeDao.save(employeeEntity);
                return "Successful";
            }
        } catch (NotFoundException e){
            throw new NotFoundException(e.getMessage());
        } catch (Exception e){
            throw new Exception("Exception "  + e.getMessage());
        }




    }

    public Employee updateEmployee(Employee employee) {
        EmployeeEntity employeeEntity = employeeDao.findById(employee.getId()).orElse(null);
        if (employeeEntity != null) {
            employeeEntity.setId(employee.getId());
            employeeEntity.setFirstName(employee.getFirstName());
            employeeEntity.setMiddleName(employee.getMiddleName());
            employeeEntity.setBirthday(employee.getBirthday());
            employeeEntity.setLastName(employee.getLastName());
            employeeEntity.setMobileNumber(employee.getMobileNumber());
            employeeEntity.setEmail(employee.getEmail());
            employeeEntity.setPostalCode(employee.getPostalCode());
            employeeEntity.setImageLocation(employee.getImageLocation());
            if (employee.getAddress() != null)
                employeeEntity.setAddress(employee.getAddress().toString());
            employeeEntity.setSex(employee.getSex());
            employeeDao.save(employeeEntity);
            return employee;
        } else {
            throw new IllegalStateException("This ID cannot be found");
        }
    }

    public int employeeCount() {
        int  count = employeeDao.countEmployee(1);
        return count;
    }
}