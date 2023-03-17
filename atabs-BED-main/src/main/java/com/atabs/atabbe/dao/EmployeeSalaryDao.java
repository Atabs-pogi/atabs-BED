package com.atabs.atabbe.dao;

import com.atabs.atabbe.entity.EmployeeSalaryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeSalaryDao extends JpaRepository<EmployeeSalaryEntity, Long> {

    @Query(value = "SELECT * FROM employee_salary WHERE eff_date = (SELECT MAX(eff_date) FROM employee_salary)", nativeQuery = true)
    List <EmployeeSalaryEntity> getAllSalary();

    @Query(value = "SELECT * FROM employee_salary WHERE emp_id = :empId AND eff_date = (SELECT MAX(eff_date) FROM employee_salary WHERE emp_id = :empId)", nativeQuery = true)
    EmployeeSalaryEntity getSalaryByEmployeeId(long empId);
}
