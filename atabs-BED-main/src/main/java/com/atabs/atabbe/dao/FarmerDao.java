package com.atabs.atabbe.dao;

import com.atabs.atabbe.entity.EmployeeEntity;
import com.atabs.atabbe.entity.FarmerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FarmerDao extends JpaRepository<FarmerEntity, Long> {

    @Query(value = "Select * from farmers where farmer_id =:farm_id", nativeQuery = true)
    FarmerEntity getFarmerInfo(Long farm_id);

    @Query(value = "Select COUNT(email) from farmers where email =:farm_email", nativeQuery = true)
    int findFarmerByEmail(String farm_email);

    @Query(value = "SELECT * FROM farmers WHERE first_name like %:match% OR middle_name like %:match% OR last_name like %:match%", nativeQuery = true)
    List<FarmerEntity> searchFarmerByName(String match);


    @Query(value = "Select COUNT(*) from farmers where status =:status", nativeQuery = true)
    int countFarmer(int status);

    @Query(value = "Select farmer.address, farmer.first_name,farmer.image_location from coop.farmers  as farmer join coop.transactions as trans on farmer.farmer_id = trans.farmer_id", nativeQuery = true)
    String test();


    @Query(value = "SELECT * FROM farmers WHERE farmer_id =:farmer_id", nativeQuery = true)
    List<FarmerEntity> getDetails(String farmer_id);

}
