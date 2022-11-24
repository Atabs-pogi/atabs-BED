package com.atabs.atabbe.service;

import com.atabs.atabbe.dao.PosDao;
import com.atabs.atabbe.entity.PosEntity;
import com.atabs.atabbe.model.Pos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PosService {
    @Autowired
    private PosDao posDao;
    public String addPos(Pos pos) {
        PosEntity posEntity = new PosEntity();
        posEntity.setName(pos.getName());
        posEntity.setGrade(pos.getGrade());
        posEntity.setPrice(pos.getPrice());
        posEntity.setKilogram(pos.getKilogram());
        posEntity.setTotal(pos.getTotal());
        posDao.save(posEntity);
        return "Successful";
    }
}
