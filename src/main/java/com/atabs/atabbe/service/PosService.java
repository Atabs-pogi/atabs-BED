package com.atabs.atabbe.service;

import com.atabs.atabbe.dao.PosDao;
import com.atabs.atabbe.dao.TransactionDao;
import com.atabs.atabbe.entity.PosEntity;
import com.atabs.atabbe.entity.TransactionEntity;
import com.atabs.atabbe.exception.NotFoundException;
import com.atabs.atabbe.model.Pos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PosService {
    @Autowired
    private PosDao posDao;


    @Autowired
    private TransactionDao transactionDao;

//    public String addPos(Pos pos) {
//        PosEntity posEntity = new PosEntity();
//        posEntity.setPlantName(pos.getPlantName());
//        posEntity.setPlantGrade(pos.getPlantGrade());
//        posEntity.setPlantKilogram(pos.getPlantKilogram());
//        posEntity.setPlantPrice(pos.getPlantPrice());
//        posEntity.setPlantTotal(pos.getPlantPrice() * pos.getPlantKilogram());
//        posEntity.setFarmerId(pos.getFarmerId());
//        posDao.save(posEntity);
//        return "Successful";
//    }

    public List<Pos> searchPosByName(String name) {
        List<PosEntity> entityPos = (List<PosEntity>) posDao.searchPosByName(name);
        List<Pos> pos = new ArrayList<>();
        for (PosEntity Poss : entityPos) {
            pos.add(Pos.from(Poss));
        }
        return pos;
    }

    public ArrayList<TransactionEntity> getTransactionList(){
        return (ArrayList<TransactionEntity>) transactionDao.findAll();
    }


    public PosEntity getPosInfo(long transactions_id) {
        return posDao.getPosInfo(transactions_id);
    }

    public Pos updatePos(Pos pos) {
        PosEntity posEntity = posDao.findById(pos.getTransactionsId()).orElse(null);
        if (posEntity != null) {
            posEntity.setPlantKilogram(pos.getPlantKilogram());
            posDao.updatePos(posEntity.getPlantKilogram(), (posEntity.getPlantPrice() * posEntity.getPlantKilogram()), posEntity.getTransactionsId());
        }
        return pos;
    }

    public Object bulkTransactionInsert(Pos pos) {

        List<PosEntity> bulkTransaction = new ArrayList<>();
        pos.getBulkTransaction().forEach(each ->{
            PosEntity posEntity= new PosEntity();
            posEntity.setTransactionsId(each.getTransactionsId());
            posEntity.setFarmerId(each.getFarmerId());
            posEntity.setPlantName(each.getPlantName());
            posEntity.setPlantKilogram(each.getPlantKilogram());
            posEntity.setPlantPrice(each.getPlantPrice());
            posEntity.setPlantTotal(each.getPlantTotal());
            bulkTransaction.add(posEntity);
        });
        posDao.saveAll(bulkTransaction);
        return  new Object();
    }


    public String save(TransactionEntity transactionEntity) throws Exception{
            int farmerIDExist = posDao.findFarmerId(transactionEntity.getFarmerId());
            if(farmerIDExist > 0){
                transactionDao.save(transactionEntity);
                return "Success";
            }
            throw new NotFoundException("Farmer ID does not exist");
    }
}
