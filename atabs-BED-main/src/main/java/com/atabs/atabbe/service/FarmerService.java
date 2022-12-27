package com.atabs.atabbe.service;

import com.atabs.atabbe.dao.FarmerDao;
import com.atabs.atabbe.entity.FarmerEntity;
import com.atabs.atabbe.helper.LoggerHelper;
import com.atabs.atabbe.model.Farmer;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FarmerService {

    @Autowired
    private FarmerDao farmerDao;

//    @Autowired
//    private FarmerTenDao farmerTenDao;

    public List<Farmer> searchFarmerByName(String name) {
        List<FarmerEntity> entityFarmers = farmerDao.searchFarmerByName(name);
        LoggerHelper.info("FarmerService", new Gson().toJson(entityFarmers));
        List<Farmer> farmers = new ArrayList<>();
        for (FarmerEntity farmer : entityFarmers) {
            farmers.add(Farmer.from(farmer));
            System.out.println(farmer.getId());
        }
        return farmers;
    }

    public FarmerEntity getFarmerInfo(long farmer_id) {
        return farmerDao.getFarmerInfo(farmer_id);
    }

    public String addFarmer(Farmer farmer) {
        FarmerEntity farmerEntity = new FarmerEntity();
        int emailExist = farmerDao.findFarmerByEmail(farmer.getEmail());
        if (emailExist > 0) {
            return "This email is already taken";
        } else {
            farmerEntity.setFirstName(farmer.getFirstName());
            farmerEntity.setMiddleName(farmer.getMiddleName());
            farmerEntity.setLastName(farmer.getLastName());
            if (farmer.getBirthday() != null) {
                farmerEntity.setBirthday(farmer.getBirthday());
            }
            farmerEntity.setMobileNumber(farmer.getMobileNumber());
            farmerEntity.setEmail(farmer.getEmail());
            if (farmer.getAddress() != null) {
                farmerEntity.setAddress(farmer.getAddress().toString());
            }
            farmerEntity.setImageLocation(farmer.getImageLocation());
            farmerEntity.setSex(farmer.getSex());
            farmerEntity.setStatus(farmerEntity.getStatus());
            farmerDao.save(farmerEntity);
            return "";
        }
    }

    public Farmer updateFarmer(Farmer farmer) {
        FarmerEntity farmerEntity = farmerDao.findById(farmer.getId()).orElse(null);
        if (farmerEntity != null) {
            farmerEntity.setFirstName(farmer.getFirstName());
            farmerEntity.setMiddleName(farmer.getMiddleName());
            farmerEntity.setLastName(farmer.getLastName());
            if (farmer.getBirthday() != null) {
                farmerEntity.setBirthday(farmer.getBirthday());
            }
            farmerEntity.setMobileNumber(farmer.getMobileNumber());
            farmerEntity.setEmail(farmer.getEmail());
            if (farmer.getAddress() != null) {
                farmerEntity.setAddress(farmer.getAddress().toString());
            }
            farmerEntity.setSex(farmer.getSex());
            farmerEntity.setStatus(farmer.getStatus());
            farmerDao.save(farmerEntity);
            return farmer;
        } else {
            throw new IllegalStateException("This ID cannot be found");
        }
    }

    public int farmerCount() {
        int  count = farmerDao.countFarmer(1);
        return count;
    }
//    public TopTenFarmers test() {
//        TopTenFarmers  count = farmerTenDao.test();
//        return count;
//    }



}
