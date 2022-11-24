package com.atabs.atabbe.service;

import com.atabs.atabbe.dao.FiberDao;
import com.atabs.atabbe.entity.EmployeeEntity;
import com.atabs.atabbe.entity.FiberEntity;
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

    public List<Fiber> searchFiberByName(String name){
        List<FiberEntity> entityFibers = (List<FiberEntity>) fiberDao.searchFiberByName(name);
        List<Fiber> fibers = new ArrayList<>();
        for (FiberEntity fiber: entityFibers) {
            fibers.add(Fiber.from(fiber));
            System.out.println(fiber.getId());
        }
        return fibers;
    }
    public FiberEntity getFiberInfo(long fiber_id){
        return fiberDao.getFiberInfo(fiber_id);
    }

    public String addFiber(Fiber fiber){
        FiberEntity fiberEntity = new FiberEntity();
        fiberEntity.setName(fiber.getName());
        fiberEntity.setGrade(fiber.getGrade());
        fiberEntity.setPrice(fiber.getPrice());
        fiberDao.save(fiberEntity);
        return "Successful";

    }

    public FiberEntity updateFiber(FiberEntity fiber){
        FiberEntity fiberEntity = fiberDao.findById(fiber.getId()).orElse(null);
        if (fiberEntity != null) {
            fiberEntity.setName(fiber.getName());
            fiberEntity.setGrade(fiber.getGrade());
            fiberEntity.setPrice(fiber.getPrice());
            fiberEntity.setStatus(fiber.getStatus());
            return fiberDao.save(fiberEntity);
        }else {
            throw new IllegalStateException("This ID cannot be found");
        }
    }
}
