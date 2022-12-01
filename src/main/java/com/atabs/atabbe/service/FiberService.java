package com.atabs.atabbe.service;

import com.atabs.atabbe.dao.FiberDao;
import com.atabs.atabbe.dao.FiberUpdatesDao;
import com.atabs.atabbe.entity.EmployeeEntity;
import com.atabs.atabbe.entity.FiberEntity;
import com.atabs.atabbe.entity.FiberUpdatesEntity;
import com.atabs.atabbe.model.Employee;
import com.atabs.atabbe.model.Fiber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FiberService {

    @Autowired
    private FiberDao fiberDao;
    @Autowired
    private FiberUpdatesDao fiberUpdatesDao;

    public List<Fiber> searchFiberByName(String name){
        List<FiberEntity> entityFibers = (List<FiberEntity>) fiberDao.searchFiberByName(name);
        List<Fiber> fibers = new ArrayList<>();
        for (FiberEntity fiber: entityFibers) {
            fibers.add(Fiber.from(fiber));
        }
        return fibers;
    }
    public FiberEntity getFiberInfo(long fiber_id){
        return fiberDao.getFiberInfo(fiber_id);
    }

    public String addFiber(Fiber fiber){
        FiberEntity fiberEntity = new FiberEntity();
        int duplicate = fiberDao.findDuplicate(fiber.getName(), fiber.getGrade());
        if(duplicate <= 0){
            fiberEntity.setName(fiber.getName());
            fiberEntity.setGrade(fiber.getGrade());
            fiberEntity.setPrice(fiber.getPrice());
            fiberDao.save(fiberEntity);
            return "Successful";
        }else {
            return "This item already exist in the database.";
        }
    }

    public FiberEntity updateFiber(FiberEntity fiber){
        FiberEntity fiberEntity = fiberDao.findById(fiber.getId()).orElse(null);
        FiberUpdatesEntity fiberUpdatesEntity = new FiberUpdatesEntity();
        double oldPrice = fiberDao.findOldPrice(fiber.getId());
        if (fiberEntity != null) {
            fiberEntity.setName(fiber.getName());
            fiberEntity.setGrade(fiber.getGrade());
            fiberEntity.setPrice(fiber.getPrice());
            fiberEntity.setStatus(fiber.getStatus());
            fiberDao.save(fiberEntity);
            fiberUpdatesEntity.setPreviousPrice(oldPrice);
            fiberUpdatesEntity.setUpdatePrice(fiber.getPrice());
            fiberUpdatesEntity.setFiberId(fiber.getId());
            fiberUpdatesDao.save(fiberUpdatesEntity);
            return fiberEntity;
        }else {
            throw new IllegalStateException("This ID cannot be found");
        }
    }
}
