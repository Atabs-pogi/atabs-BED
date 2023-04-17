package com.atabs.atabbe.service;


import com.atabs.atabbe.dao.TuxyDao;
import com.atabs.atabbe.dao.TuxyLogsDao;
import com.atabs.atabbe.entity.FarmerEntity;
import com.atabs.atabbe.entity.TuxyEntity;
import com.atabs.atabbe.exception.NotFoundException;
import com.atabs.atabbe.model.Farmer;
import com.atabs.atabbe.model.UpdateTuxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
public class TuxyService {

    @Autowired
    private TuxyDao tuxyDao;
    @Autowired
    private TuxyLogService tuxyLogService;


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

    public String update(TuxyEntity tuxyEntity) {
        try{
            tuxyDao.save(tuxyEntity);
            return "Success";
        }catch (Exception e){
            return "Exception "  + e.getMessage();
        }
    }


    public String updateTuxy(TuxyEntity tuxyEntity) throws Exception{
        if(tuxyDao.findById(tuxyEntity.getTuxyId()).isPresent()){
            try{
                TuxyEntity entity = tuxyDao.findById(tuxyEntity.getTuxyId()).get();
                if(entity.getGoodPrice() != tuxyEntity.getGoodPrice()){
                    System.out.println( "Good " + entity.getGoodPrice());
                    System.out.println("Good " + tuxyEntity.getGoodPrice());
                    UpdateTuxy updateTuxy = new UpdateTuxy();
                    updateTuxy.setType("Good");
                    updateTuxy.setTuxyId(entity.getTuxyId());
                    updateTuxy.setOldPrice(entity.getGoodPrice());
                    updateTuxy.setNewPrice(tuxyEntity.getGoodPrice());
                    entity.setGoodPrice(tuxyEntity.getGoodPrice());
                    tuxyLogService.AddLogs(updateTuxy);
                }

                if(entity.getDiscardedPrice() != tuxyEntity.getDiscardedPrice()){
                    System.out.println( "getDiscardedPrice " + entity.getDiscardedPrice());
                    System.out.println("getDiscardedPrice " + tuxyEntity.getDiscardedPrice());
                    UpdateTuxy updateTuxy = new UpdateTuxy();
                    updateTuxy.setType("Discarded");
                    updateTuxy.setTuxyId(entity.getTuxyId());
                    updateTuxy.setOldPrice(entity.getDiscardedPrice());
                    updateTuxy.setNewPrice(tuxyEntity.getDiscardedPrice());
                    entity.setDiscardedPrice(tuxyEntity.getDiscardedPrice());
                    tuxyLogService.AddLogs(updateTuxy);
                }

                if(entity.getResecoPrice() != tuxyEntity.getResecoPrice()){
                    System.out.println( "getResecoPrice " + entity.getResecoPrice());
                    System.out.println("getResecoPrice " + tuxyEntity.getResecoPrice());
                    UpdateTuxy updateTuxy = new UpdateTuxy();
                    updateTuxy.setType("Reseco");
                    updateTuxy.setTuxyId(entity.getTuxyId());
                    updateTuxy.setOldPrice(entity.getResecoPrice());
                    updateTuxy.setNewPrice(tuxyEntity.getResecoPrice());
                    entity.setResecoPrice(tuxyEntity.getResecoPrice());
                    tuxyLogService.AddLogs(updateTuxy);
                }
                tuxyDao.save(entity);
                return "Successfully updated";
            }catch (Exception e){
                throw new Exception(e.getMessage());
            }
        }
        throw new NotFoundException("Tuxy id does not exist");
    }


    public List<TuxyEntity> searchByName(String name) {
        List<TuxyEntity> entityFarmers =  tuxyDao.searchByName(name);
        return entityFarmers;
    }
}
