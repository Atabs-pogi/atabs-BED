package com.atabs.atabbe.service;

import com.atabs.atabbe.dao.PosDao;
import com.atabs.atabbe.dao.TransactionDao;
import com.atabs.atabbe.entity.PosEntity;
import com.atabs.atabbe.entity.TransactionEntity;
import com.atabs.atabbe.entity.TransactionItemEntity;
import com.atabs.atabbe.model.Pos;
import com.atabs.atabbe.model.Transaction;
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

    public List<Pos> searchPosByName(String name) {
        List<PosEntity> entityPos = (List<PosEntity>) posDao.searchPosByName(name);
        List<Pos> pos = new ArrayList<>();
        for (PosEntity Poss : entityPos) {
            pos.add(Pos.from(Poss));
        }
        return pos;
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


    public String save(TransactionEntity transactionEntity) {
        try{
            transactionDao.save(transactionEntity);
            return "Success";
        }catch (Exception e){
            return "Exception "  + e.getMessage();
        }
    }


    public String insertTransaction(ArrayList<Transaction> transactions) {
        try{
            TransactionEntity transactionEntity = new TransactionEntity();

            transactionEntity.setFarmerId(transactions.get(0).getFarmerId());
            transactionEntity.setTotalAmount(transactions.get(0).getTotalAmount());

            ArrayList<TransactionItemEntity> transactionItemEntities = new ArrayList<>();
            for(Transaction transaction : transactions){
                TransactionItemEntity transactionItem = new TransactionItemEntity();
                transactionItem.setTuxyId(transaction.getTuxyId());

                transactionItem.setExcellentAmount(transaction.getGoodAmount());
                transactionItem.setExcellentKilo(transaction.getGoodKg());

                transactionItem.setDiscarteAmount(transaction.getDiscarteAmount());
                transactionItem.setDiskarteKilo(transaction.getDiscarteKg());

                transactionItem.setResecoKilo(transaction.getResecoKg());
                transactionItem.setResecoAmount(transaction.getResecoAmount());

                transactionItemEntities.add(transactionItem);

            }


            transactionEntity.setItems(transactionItemEntities);


            transactionDao.save(transactionEntity);
            return "Success";
        }catch (Exception e){
            return "Exception "  + e.getMessage();
        }
    }
}
