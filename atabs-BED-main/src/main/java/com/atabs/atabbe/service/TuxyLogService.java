package com.atabs.atabbe.service;



import com.atabs.atabbe.dao.TuxyLogsDao;
import com.atabs.atabbe.entity.TuxyLogsEntity;
import com.atabs.atabbe.helper.Message;
import com.atabs.atabbe.model.UpdateTuxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class TuxyLogService {

    @Autowired
    private TuxyLogsDao tuxyLogsDao;


    public String save(UpdateTuxy updateTuxy) {
        try{

            TuxyLogsEntity tuxyLogs = new TuxyLogsEntity();
            tuxyLogs.setTuxyId(updateTuxy.getTuxyId());
            tuxyLogs.setUpdatedBy("User full name");
            tuxyLogs.setAction(
                    Message.UPDATE_MESSAGE_LOGS
                            .replace("<type>",updateTuxy.getType())
                            .replace("<oldPrice>",String.valueOf(updateTuxy.getOldPrice()))
                            .replace("<newPrice>",String.valueOf(updateTuxy.getNewPrice()))
            );
            tuxyLogsDao.save (tuxyLogs);
            return "Success";
        }catch (Exception e){
            return "Exception "  + e.getMessage();
        }
    }



    public ArrayList<TuxyLogsEntity> get() {
        try{

            return (ArrayList<TuxyLogsEntity>) tuxyLogsDao.findAll ();
        }catch (Exception e){
            return null;
        }
    }


}
