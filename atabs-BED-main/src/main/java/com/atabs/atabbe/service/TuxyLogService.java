package com.atabs.atabbe.service;



import com.atabs.atabbe.dao.TuxyDao;
import com.atabs.atabbe.dao.TuxyLogsDao;
import com.atabs.atabbe.entity.TuxyEntity;
import com.atabs.atabbe.entity.TuxyLogsEntity;
import com.atabs.atabbe.helper.Message;
import com.atabs.atabbe.model.UpdateTuxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class TuxyLogService {

    @Autowired
    private TuxyLogsDao tuxyLogsDao;
    @Autowired
    private TuxyDao tuxyDao;

    public String AddLogs(UpdateTuxy updateTuxy) {
        try{

            if(tuxyDao.findById(updateTuxy.getTuxyId()).isPresent()){
                TuxyEntity  tuxyEntity =  tuxyDao.findById(updateTuxy.getTuxyId()).get();
                TuxyLogsEntity tuxyLogs = new TuxyLogsEntity();
                tuxyLogs.setTuxyId(updateTuxy.getTuxyId());
                tuxyLogs.setTuxyName(tuxyEntity.getName());
                tuxyLogs.setUpdatedBy("User full name");
                tuxyLogs.setAction(
                        Message.UPDATE_MESSAGE_LOGS
                                .replace("<type>",updateTuxy.getType())
                                .replace("<oldPrice>",String.valueOf(updateTuxy.getOldPrice()))
                                .replace("<newPrice>",String.valueOf(updateTuxy.getNewPrice()))
                );
                tuxyLogsDao.save(tuxyLogs);
            }


            System.out.println( "Success ");
            return "Success";
        }catch (Exception e){
            System.out.println( "Success "  + e.getMessage());
            return "Exception "  + e.getMessage();


        }
    }

//    public ArrayList<TuxyLogsEntity> get() {
//        try{
//            ArrayList<TuxyLogsEntity> arrayList = new ArrayList<>();
//            for(TuxyLogsEntity entity : tuxyLogsDao.findAll()){
//                TuxyLogsEntity tuxyLogs = new TuxyLogsEntity();
//
//            }
//        }catch (Exception e){
//            return null;
//        }
//    }

    public List<TuxyLogsEntity> searchByName(String name) {
        List<TuxyLogsEntity> entityFarmers =  tuxyLogsDao.searchByName(name);
        return entityFarmers;
    }




}
