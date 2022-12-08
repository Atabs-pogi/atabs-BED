package com.atabs.atabbe.service;

import com.atabs.atabbe.dao.TuxyDao;
import com.atabs.atabbe.entity.TuxyEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TuxyService {

    @Autowired
    private TuxyDao tuxyDao;


    public String save(TuxyEntity tuxyEntity) {
        try{
            tuxyDao.save(tuxyEntity);
            return "Success";
        }catch (Exception e){
            return "Exception "  + e.getMessage();
        }
    }


    public ArrayList<TuxyEntity> getTuxyList(){
        return (ArrayList<TuxyEntity>) tuxyDao.findAll();
    }
}