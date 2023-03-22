package com.atabs.atabbe.service;

import com.atabs.atabbe.dao.FiberDao;
import com.atabs.atabbe.dao.FiberNewDao;
import com.atabs.atabbe.entity.EmployeeEntity;
import com.atabs.atabbe.entity.FiberEntity;
import com.atabs.atabbe.entity.FiberNewEntity;
import com.atabs.atabbe.exception.NotFoundException;
import com.atabs.atabbe.model.Employee;
import com.atabs.atabbe.model.FiberNew;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class FiberNewService {
    @Autowired
    private FiberNewDao fiberNewDao;

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd");
    LocalDateTime now = LocalDateTime.now();

    public String generateFiber(FiberNew fiberNew) throws NotFoundException {
        Integer fiber = fiberNewDao.getFiberId();
        if (fiber == null) {
            fiber = 100;
        }
        FiberNewEntity fiberNewEntity = new FiberNewEntity();
        fiberNewEntity.setExcellentFiberKg(fiberNew.getExcellentFiberKg());
        fiberNewEntity.setGoodFiberKg(fiberNew.getGoodFiberKg());
        fiberNewEntity.setResecoFiberKg(fiberNew.getResecoFiberKg());
        fiberNewEntity.setReferenceCode(String.valueOf(dtf.format(now))+fiber);
        fiberNewDao.save(fiberNewEntity);
        return "Generate Successfully";
    }

    public FiberNewEntity getFiberByID(long id) throws NotFoundException {
        FiberNewEntity fiberNew = fiberNewDao.findById(id).orElse(null);
        if (fiberNew == null) {
            throw new NotFoundException("Fiber New Entity Not Found");
        }
        return fiberNew;
    }

    public String updateFiber(FiberNew fiberNew) {
        FiberNewEntity fiberNewEntity= fiberNewDao.getRefCode(fiberNew.getReferenceCode());
        fiberNewEntity.setExcellentFiberAmount(fiberNew.getExcellentFiberAmount());
        fiberNewEntity.setGoodFiberAmount(fiberNew.getGoodFiberAmount());
        fiberNewEntity.setResecoFiberAmount(fiberNew.getResecoFiberAmount());
        fiberNewEntity.setFiberTotalAmount(fiberNew.totalAmount());
        fiberNewDao.save(fiberNewEntity);
        return "Update Successfully";
    }


    public List<FiberNew> searchFiberByName(String name) {
        List<FiberNewEntity> entityFibers = fiberNewDao.searchFiberByName(name);
        List<FiberNew> fibers = new ArrayList<>();
        for (FiberNewEntity fiber : entityFibers) {
            fibers.add(FiberNew.from(fiber));
        }
        return fibers;
    }

}
