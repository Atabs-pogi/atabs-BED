package com.atabs.atabbe.dao;

import com.atabs.atabbe.entity.EmployeeSalaryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeSalaryDao extends JpaRepository<EmployeeSalaryEntity, Long> {

    @Query(value = "SELECT * FROM employee_salary WHERE emp_id = :empId", nativeQuery = true)
    EmployeeSalaryEntity getSalaryByEmployeeId(long empId);
}
