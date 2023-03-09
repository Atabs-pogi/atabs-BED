package com.atabs.atabbe.service;

import com.atabs.atabbe.dao.FiberDao;
import com.atabs.atabbe.entity.FiberEntity;
import com.atabs.atabbe.entity.TuxyEntity;
import com.atabs.atabbe.helper.Message;
import com.atabs.atabbe.model.Fiber;
import com.atabs.atabbe.model.Response;
import com.atabs.atabbe.model.UpdateTuxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FiberService {

    @Autowired
    private FiberDao fiberDao;

    public List<FiberEntity> searchByName(String name) {
        List<FiberEntity> entity =  fiberDao.searchByName(name);
        return entity;
    }

    public FiberEntity getFiberInfo(long fiber_id) {
        return fiberDao.getFiberInfo(fiber_id);
    }


    public String addFiber(Fiber fiber) {

        FiberEntity fiberEntity = new FiberEntity();
        try {
            fiberEntity.setName(fiber.getName());
//            fiberEntity.setGrade(fiber.getGrade());
//            fiberEntity.setPrice(fiber.getPrice());
            fiberDao.save(fiberEntity);
            System.out.println(fiberEntity);
            return "Successful";
        } catch (Exception e) {
            throw new IllegalStateException("Invalid Data");
        }
    }

    public String updateFiber(UpdateTuxy updateTuxy) {
        try{
//            if(updateTuxy.getType().equalsIgnoreCase("GOOD")){
//                fiberDao.setUpdateGood(updateTuxy.getNewPrice(),updateTuxy.getTuxyId());
//                return "Successfully updated";
//            }else if(updateTuxy.getType().equalsIgnoreCase("DISCARTE")){
//                fiberDao.setUpdateDiscarte(updateTuxy.getNewPrice(),updateTuxy.getTuxyId());
//                return "Successfully updated";
//            }else if(updateTuxy.getType().equalsIgnoreCase("RESECO")){
//                fiberDao.setUpdateReseco(updateTuxy.getNewPrice(),updateTuxy.getTuxyId());
//                return "Successfully updated";
//            }
            return "No Choices";
        }catch (Exception e){
            return e.getMessage();
        }

    }

    public String getFiberGrade(String fName){
        return fiberDao.getFiberGrade(fName);
    }

    public List<FiberEntity> getFibers(){
        return fiberDao.findAll();
    }


    public String addFiber(FiberEntity fiberEntity) {

        try {
            fiberDao.save(fiberEntity);
            return Message.SUCCESS_MESSAGE.replace("<data>","Fiber");
        } catch (Exception e) {
            throw new IllegalStateException("Exception: " + e.getMessage());
        }
    }


}
