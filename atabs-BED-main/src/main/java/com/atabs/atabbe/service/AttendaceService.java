package com.atabs.atabbe.service;

import com.atabs.atabbe.dao.AccountDao;
import com.atabs.atabbe.dao.AttendanceDao;
import com.atabs.atabbe.dao.EmployeeDao;
import com.atabs.atabbe.entity.AttendanceEntity;
import com.atabs.atabbe.entity.EmployeeEntity;
import com.atabs.atabbe.model.Attendance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class AttendaceService {

    @Autowired
    private AttendanceDao attendanceDao;
    @Autowired
    private EmployeeDao employeeDao;
    LocalDateTime dateTime;
    LocalDateTime reset;
    LocalDateTime gracePeriod;



    public String timeIn(Attendance attendance) {
        dateTime.format(DateTimeFormatter.ofPattern("HH:MM:SS"));
        reset.equals("12:00:00");
        gracePeriod.equals("8:15:00");
        EmployeeEntity employeeEntity= new EmployeeEntity();
        employeeEntity = employeeDao.getEmployeeInfo(attendance.getEmpId());
        AttendanceEntity attendanceEntity= attendanceDao.findById(attendance.getEmpId()).orElse(null);
        assert attendanceEntity != null;
        if(employeeEntity!=null){
            if(attendance.getTimeIn()!=null) {
                attendanceEntity.setTimeOut(dateTime);
                attendanceEntity.setEmployeeEntity(employeeEntity);

            }else {
                if(gracePeriod.isEqual(dateTime)){
                    attendanceEntity.setTimeIn(dateTime);
                    attendanceEntity.setEmployeeEntity(employeeEntity);
                }else{
                    attendanceEntity.setTimeIn(dateTime);
                    attendanceEntity.setTardiness(attendance.getTardiness()+1);
                    attendanceEntity.setEmployeeEntity(employeeEntity);
                }

            }
        }else if(dateTime == reset){
            attendanceEntity.setAbsent(attendance.getAbsent()+1);
        }
        attendanceDao.save(attendanceEntity);
        return "Successfully";



    }
}
