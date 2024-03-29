package com.atabs.atabbe.dao;

import com.atabs.atabbe.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeDao extends JpaRepository<EmployeeEntity,Long> {

    @Query(value = "Select * from Employees where id =:emp_id",nativeQuery = true)
    EmployeeEntity getEmployeeInfo(Long emp_id);

    @Query(value = "Select COUNT(email) from Employees where email =:emp_email", nativeQuery = true)
    int findEmployeeByEmail(String emp_email);

    @Query(value = "SELECT * FROM employees WHERE CONCAT(id, '') = :match OR first_name like %:match% OR middle_name like %:match% OR last_name like %:match%" , nativeQuery = true)
    List<EmployeeEntity> searchEmployeeByName(String match);

}
