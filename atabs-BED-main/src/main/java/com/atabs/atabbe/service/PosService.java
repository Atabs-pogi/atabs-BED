package com.atabs.atabbe.service;

import com.atabs.atabbe.dao.FarmerDao;
import com.atabs.atabbe.dao.PosDao;
import com.atabs.atabbe.dao.TransactionDao;
import com.atabs.atabbe.dao.TuxyDao;
import com.atabs.atabbe.entity.PosEntity;
import com.atabs.atabbe.entity.TransactionEntity;
import com.atabs.atabbe.entity.TransactionItemEntity;
import com.atabs.atabbe.entity.TuxyEntity;
import com.atabs.atabbe.exception.NotFoundException;
import com.atabs.atabbe.helper.LoggerHelper;
import com.atabs.atabbe.helper.Message;
import com.atabs.atabbe.model.Pos;
import com.atabs.atabbe.model.Transaction;
import com.atabs.atabbe.model.TransactionResponse;
import com.atabs.atabbe.model.UpdateTransaction;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

@Service
public class PosService {
    @Autowired
    private PosDao posDao;

    @Autowired
    private FarmerDao farmerDao;

    @Autowired
    private TransactionDao transactionDao;


    @Autowired
    private TuxyDao tuxyDao;

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


    public String insertTransaction(Transaction transactions) throws Exception {
        try{
            Gson gson = new Gson();
            LoggerHelper.info("POSSERVICE",gson.toJson(transactions));
            boolean isExist = farmerDao.existsById(transactions.getFarmerId());

            ArrayList<TransactionItemEntity> transactionItemEntities = new ArrayList<>();
            if(isExist){
                double price = 0;
                double totalAmount = 0;
                for(Transaction.Items transaction_items : transactions.getItems()){
                    LoggerHelper.info("POSSERVICE",gson.toJson(transaction_items.getTuxyId()));

                    boolean isTuxyExist = tuxyDao.existsById(transaction_items.getTuxyId());

                    if (isTuxyExist){
                        TuxyEntity tuxyEntity =  tuxyDao.findById(transaction_items.getTuxyId()).get();

                        TransactionItemEntity transactionItem = new TransactionItemEntity();
                        transactionItem.setTuxyId(transaction_items.getTuxyId());
                        transactionItem.setTuxyName(tuxyEntity.getName());
                        transactionItem.setType(transaction_items.getQuality());
                        transactionItem.setQuantity(transaction_items.getQuantity());

                        if(transaction_items.getQuality().equalsIgnoreCase("EXCELLENT")){
                            price = tuxyEntity.getGoodPrice() * transaction_items.getQuantity();
                            totalAmount += price;
                            transactionItem.setValue(tuxyEntity.getGoodPrice());
                            transactionItem.setPrice(price);
                            transactionItemEntities.add(transactionItem);
                        }else if(transaction_items.getQuality().equalsIgnoreCase("GOOD")){
                            price = tuxyEntity.getDiscartePrice() * transaction_items.getQuantity();
                            totalAmount += price;
                            transactionItem.setValue(tuxyEntity.getDiscartePrice());
                            transactionItem.setPrice(price);
                            transactionItemEntities.add(transactionItem);
                        }else if(transaction_items.getQuality().equalsIgnoreCase("RESECO")){
                            price = tuxyEntity.getResecoPrice() * transaction_items.getQuantity();
                            totalAmount += price;
                            transactionItem.setValue(tuxyEntity.getResecoPrice());
                            transactionItem.setPrice(price);
                            transactionItemEntities.add(transactionItem);
                        }


                        LoggerHelper.info("POSSERVICE",gson.toJson(tuxyEntity));

                    }else{
                        throw new NotFoundException(Message.ERROR_MESSAGE_FOR_NOT_EXIST.replace("<object>","tuxy"));
                    }
                }

                LoggerHelper.info("POSSERVICE",gson.toJson(transactionItemEntities));
                TransactionEntity transaction = new TransactionEntity();
                transaction.setFarmerId(transactions.getFarmerId());
                transaction.setTotalAmount(totalAmount);
                transaction.setItems(transactionItemEntities);
                transactionDao.save(transaction);
                transactionDao.flush();
                TransactionResponse transactionResponse = new TransactionResponse();
                transactionResponse.setTransactionId(transaction.getTransactionsId());
//                return  transactionResponse ;
                return  String.valueOf(transaction.getTransactionsId()) ;
            }
            throw new NotFoundException(Message.ERROR_MESSAGE_FOR_NOT_EXIST.replace("<object>","farmer"));


        } catch (NotFoundException e){
            throw new NotFoundException(e.getMessage());
        } catch (Exception e){
            throw new Exception("Exception "  + e.getMessage());
        }

    }




    public ArrayList<TransactionEntity> getAll(int status) throws Exception {
        try{
            return (ArrayList<TransactionEntity>) transactionDao.transactionList(status);

        } catch (Exception e){
            throw new Exception("Exception "  + e.getMessage());
        }

    }

    public ArrayList<TransactionEntity> getAll() throws Exception {
        try{
            return (ArrayList<TransactionEntity>) transactionDao.findAll(Sort.by(Sort.Direction.DESC, "transactionDate"));

        } catch (Exception e){
            throw new Exception("Exception "  + e.getMessage());
        }

    }


    public String updateTransaction(UpdateTransaction updateTransaction) throws Exception {
        try{
            int result =  transactionDao.updateTransaction(
                    updateTransaction.getStatus(),
                    updateTransaction.getMerchantPayment(),
                    updateTransaction.getTransaction_id(),
                    LocalDateTime.now()
            );
            return result == 1? "Successfully transaction" : "Failed transaction";

        } catch (Exception e){
            throw new Exception("Exception "  + e.getMessage());
        }

    }
}
