package com.atabs.atabbe.service;

import com.atabs.atabbe.dao.PayrollDeductibleDao;
import com.atabs.atabbe.dao.EmployeeDao;
import com.atabs.atabbe.dao.PayrollDao;
import com.atabs.atabbe.dao.PayrollDetailDao;
import com.atabs.atabbe.entity.PayrollDeductibleEntity;
import com.atabs.atabbe.entity.EmployeeEntity;
import com.atabs.atabbe.entity.PayrollDetailEntity;
import com.atabs.atabbe.entity.PayrollEntity;
import com.atabs.atabbe.exception.NotFoundException;
import com.atabs.atabbe.model.PayrollDeductible;
import com.atabs.atabbe.model.Payroll;
import com.atabs.atabbe.model.PayrollDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class PayrollService {

    @Autowired
    private PayrollDao payrollDao;
    @Autowired
    private PayrollDetailDao payrollDetailDao;
    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private PayrollDeductibleDao payrollDeductibleDao;

    public List<PayrollEntity> getAllByPeriod(LocalDate period){
        return payrollDao.getPayrollByPeriod(this.getPeriodStart(period), this.getPeriodEnd(period));
    }

    public  List<PayrollEntity> getAllByPeriodStartAndPeriodEnd(LocalDate periodStart, LocalDate periodEnd) {
        return payrollDao.getPayrollByPeriod(periodStart, periodEnd);
    }

    public List<EmployeeEntity> getEmployeePayrollStatus(LocalDate period){
        List<EmployeeEntity> employees = employeeDao.findAll();
        List<PayrollEntity> payrolls = payrollDao.findAll();
        List<Long>ids = payrollDao.getEmployeesPeriod(this.getPeriodStart(period), this.getPeriodEnd(period));
        for (EmployeeEntity employee : employees) {
            for (PayrollEntity payroll: payrolls) {
                if (payroll.getEmployee().getId() == employee.getId()){
                    employee.setReviewed(true);
                }
            }
        }
        return employees;
    }
    @Transactional
    public Payroll saveEmployeePayroll(Payroll payroll) throws NotFoundException {
        EmployeeEntity employee =  employeeDao.findById(payroll.getEmployeeId()).orElse(null);
        if(employee == null){
            throw new NotFoundException("Employee not found");
        }
        PayrollEntity entity = payrollDao.getEmployeePayrollByPeriod(
                payroll.getEmployeeId(),
                payroll.getPeriodStart(),
                payroll.getPeriodEnd()
        );
        if(entity == null) {
            entity = new PayrollEntity();
        }
        entity.setPeriodStart(payroll.getPeriodStart());
        entity.setPeriodEnd(payroll.getPeriodEnd());
        entity.setEmployee(employee);
        entity.setBaseSalary(payroll.getBaseSalary());
        payrollDao.save(entity);
        payroll.setId(entity.getId());
        //Save items (payroll details)
        List<PayrollDetails> items = payroll.getItems();
        for (PayrollDetails item: items) {
            PayrollDetailEntity detailEntity = payrollDetailDao.getByPeriod(entity.getId(), item.getDate());
            //check existing
            if(detailEntity == null){
                detailEntity = new PayrollDetailEntity();
                detailEntity.setPayrollId(entity.getId());
            }
            detailEntity.setDate(item.getDate());
            detailEntity.setRegular(item.getRegular());
            detailEntity.setOt(item.getOt());
            detailEntity.setTardiness(item.getTardiness());
            detailEntity.setVacation(item.getVacation());
            detailEntity.setSick(item.getSick());
            payrollDetailDao.save(detailEntity);
            item.setId(detailEntity.getId());
            item.setPayrollId(entity.getId());
        }
        //Save deductibles (payroll deductibles)
        List<PayrollDeductible> deductibles = payroll.getDeductibles();
        for (PayrollDeductible deductible : deductibles) {
            PayrollDeductibleEntity deductibleEntity = payrollDeductibleDao.getExistingDeductible(entity.getId(),deductible.getDescription() );
            if(deductibleEntity == null) {
                deductibleEntity = new PayrollDeductibleEntity();
                deductibleEntity.setPayrollId(entity.getId());
            }
            deductibleEntity.setDescription(deductible.getDescription());
            deductibleEntity.setValue(deductible.getValue());
            payrollDeductibleDao.save(deductibleEntity);
            deductible.setId(deductibleEntity.getId());
            deductible.setPayrollId(entity.getId());
        }
        return payroll;
    }

    private LocalDate getPeriodStart(LocalDate period) {
        LocalDate start = null;
        if (period.getDayOfMonth() < 15) {
            start = period.withDayOfMonth(1);
        }else if (period.getDayOfMonth() > 15) {
            start = period.withDayOfMonth(16);
        }
        return start;
    }

    private LocalDate getPeriodEnd(LocalDate period) {
        LocalDate end = null;
        if (period.getDayOfMonth() < 15) {
            end = period.withDayOfMonth(15);
        }else if (period.getDayOfMonth() > 15) {
            end = period.withDayOfMonth(period.lengthOfMonth());
        }
        return end;
    }
}
