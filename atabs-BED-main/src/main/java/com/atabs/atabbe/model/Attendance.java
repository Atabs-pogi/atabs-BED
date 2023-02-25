package com.atabs.atabbe.model;

import java.time.LocalDateTime;

public class Attendance {

    private long id;
    private long empId;
    private String regular;
    private String tardiness;
    private String sickLeave;
    private LocalDateTime timeIn;
    private LocalDateTime timeOut;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getEmpId() {
        return empId;
    }

    public void setEmpId(long empId) {
        this.empId = empId;
    }

    public String getRegular() {
        return regular;
    }

    public void setRegular(String regular) {
        this.regular = regular;
    }

    public String getTardiness() {
        return tardiness;
    }

    public void setTardiness(String tardiness) {
        this.tardiness = tardiness;
    }

    public String getSickLeave() {
        return sickLeave;
    }

    public void setSickLeave(String sickLeave) {
        this.sickLeave = sickLeave;
    }

    public LocalDateTime getTimeIn() {
        return timeIn;
    }

    public void setTimeIn(LocalDateTime timeIn) {
        this.timeIn = timeIn;
    }

    public LocalDateTime getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(LocalDateTime timeOut) {
        this.timeOut = timeOut;
    }
}
