package com.atabs.atabbe.dao;

import com.atabs.atabbe.entity.EmployeeSalaryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeSalaryDao extends JpaRepository<EmployeeSalaryEntity, Long> {

    @Query(value = "SELECT s1.* FROM coop.employee_salary s1 LEFT JOIN coop.employee_salary s2 ON s1.emp_id = s2.emp_id AND s1.eff_date < s2.eff_date WHERE s2.emp_id IS NULL", nativeQuery = true)
    List <EmployeeSalaryEntity> getAllSalary();

    @Query(value = "SELECT * FROM employee_salary WHERE emp_id = :empId AND eff_date = (SELECT MAX(eff_date) FROM employee_salary WHERE emp_id = :empId)", nativeQuery = true)
    EmployeeSalaryEntity getSalaryByEmployeeId(long empId);
}
