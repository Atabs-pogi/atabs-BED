package com.atabs.atabbe.service;

import com.atabs.atabbe.dao.BackupDao;
import com.atabs.atabbe.entity.DatabaseEntity;
import com.atabs.atabbe.helper.BackUpDatabase;
import com.atabs.atabbe.helper.FileCreated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BackupService {

    @Autowired
    private BackupDao backupDao;


    public String backUp (){
        DatabaseEntity databaseEntity = new DatabaseEntity();
        String location = FileCreated.dbPathFile();
        boolean isSuccess = BackUpDatabase.backUp(FileCreated.dbPathFile(),"root","vince8516200","coop");
        if(isSuccess){
            try {
                databaseEntity.setLocation(location);
                backupDao.save(databaseEntity);
                return "Successfully backup the database \n" + "Location: " + location;
            }catch (Exception e){
                return "Exception :" + e.getMessage();
            }
        }
        return "Failed backup";
    }



    public List<DatabaseEntity> getBackUpDB(){
        return  backupDao.getDBList();
    }
}
