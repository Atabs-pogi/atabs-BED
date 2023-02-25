package com.atabs.atabbe.service;

import com.atabs.atabbe.dao.AccountDao;
import com.atabs.atabbe.dao.AttendanceDao;
import com.atabs.atabbe.dao.EmployeeDao;
import com.atabs.atabbe.entity.AttendanceEntity;
import com.atabs.atabbe.entity.EmployeeEntity;
import com.atabs.atabbe.model.Attendance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AttendaceService {

    @Autowired
    private AttendanceDao attendanceDao;
    @Autowired
    private EmployeeDao employeeDao;


    public String timeIn(Attendance attendance) {
        EmployeeEntity employeeEntity= new EmployeeEntity();
        employeeEntity = employeeDao.getEmployeeInfo(attendance.getEmpId());
        AttendanceEntity attendanceEntity= attendanceDao.findById(attendance.getEmpId()).orElse(null);
        assert attendanceEntity != null;
        if(employeeEntity!=null){
            if(attendance.getTimeIn()!=null){
                attendanceEntity.setTimeOut(LocalDateTime.now());
                attendanceEntity.setEmployeeEntity(employeeEntity);
            }else {
                attendanceEntity.setTimeIn(LocalDateTime.now());
                attendanceEntity.setEmployeeEntity(employeeEntity);
            }
        }else{
            attendanceEntity.setSickLeave(attendance.getSickLeave());
        }
        attendanceDao.save(attendanceEntity);
        return "Successfully";



    }
}
