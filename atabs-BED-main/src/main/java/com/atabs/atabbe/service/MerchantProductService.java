package com.atabs.atabbe.service;

import com.atabs.atabbe.dao.MerchantProductDao;
import com.atabs.atabbe.dao.MerchantTransactionProductDao;
import com.atabs.atabbe.entity.*;
import com.atabs.atabbe.exception.NotFoundException;
import com.atabs.atabbe.helper.LoggerHelper;
import com.atabs.atabbe.helper.Message;
import com.atabs.atabbe.model.TransactionMerchant;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MerchantProductService {
    @Autowired
    private MerchantProductDao merchantProductDao;

    @Autowired
    private MerchantTransactionProductDao merchantTransactionProductDao;


    public String addProduct(MerchantProductEntity merchantProduct) {

        MerchantProductEntity merchantProductEntity = new MerchantProductEntity();
        int itemExist = merchantProductDao.findProductByItem(merchantProduct.getProductName());
        if (itemExist > 0){
            throw new IllegalStateException("This item is already exist"); //mamaya
        }
        merchantProductEntity.setProductCategory(merchantProduct.getProductCategory());
        merchantProductEntity.setProductName(merchantProduct.getProductName());
        merchantProductEntity.setUnit(merchantProduct.getUnit());
        merchantProductEntity.setUnitPrice(merchantProduct.getUnitPrice());
        merchantProductEntity.setCostPrice(merchantProduct.getCostPrice());
        merchantProductEntity.setOriginalPrice(merchantProduct.getUnitPrice());
        merchantProductEntity.setQuantity(merchantProduct.getQuantity());
        merchantProductEntity.setMinimumStock(merchantProduct.getMinimumStock());
        merchantProductDao.save(merchantProductEntity);
        return "Product added successfully";
    }

    public List<MerchantProductEntity> getProduct() {
        return merchantProductDao.findAll();
    }

    public String updateProduct(MerchantProductEntity merchantProduct) {
        MerchantProductEntity merchantProductEntity = merchantProductDao.findById(merchantProduct.getId()).orElse(null);
        assert merchantProductEntity != null;
        merchantProductEntity.setProductCategory(merchantProduct.getProductCategory());
        merchantProductEntity.setProductName(merchantProduct.getProductName());
        merchantProductEntity.setUnit(merchantProduct.getUnit());
        merchantProductEntity.setUnitPrice(merchantProduct.getUnitPrice());
        merchantProductEntity.setCostPrice(merchantProduct.getCostPrice());
        merchantProductEntity.setQuantity(merchantProduct.getQuantity());
        merchantProductEntity.setMinimumStock(merchantProduct.getMinimumStock());
        merchantProductDao.save(merchantProductEntity);
        return "Update Successfully";
    }

    public List<MerchantProductEntity> searchProductByName(String name) {
        return  merchantProductDao.searchProductByName(name);
    }


    public TransactionMerchantEntity insertTransaction(TransactionMerchant transactions) throws Exception {
        try {
            Gson gson = new Gson();
            LoggerHelper.info("insertTransaction", gson.toJson(transactions));

            TransactionMerchantEntity transactionMerchantEntity = new TransactionMerchantEntity();
            transactionMerchantEntity.setTotalItem(transactions.getItems().size());


            double totalAmount = 0;
            ArrayList<TransactionMerchantItemEntity> transactionMerchantItemEntities = new ArrayList<>();

            for(TransactionMerchant.Items items : transactions.getItems()){
                LoggerHelper.info("insertTransaction",gson.toJson(items));
                boolean isExist = merchantProductDao.existsById(items.getProductId());

                if(isExist){
                    MerchantProductEntity merchantProductEntity = merchantProductDao.findById(items.getProductId()).get();
                    double subAmount  = (merchantProductEntity.getUnitPrice() * items.getQuantity());
                    totalAmount += subAmount;
                    TransactionMerchantItemEntity transactionMerchantItemEntity = new TransactionMerchantItemEntity();
                    transactionMerchantItemEntity.setProductId(items.getProductId());
                    transactionMerchantItemEntity.setName(merchantProductEntity.getProductName());
                    transactionMerchantItemEntity.setQuantity(items.getQuantity());
                    transactionMerchantItemEntity.setPrice(merchantProductEntity.getUnitPrice());
                    transactionMerchantItemEntity.setSubAmount(subAmount);
                    transactionMerchantItemEntities.add(transactionMerchantItemEntity);
                }else{
                    throw new NotFoundException(Message.ERROR_MESSAGE_FOR_NOT_EXIST.replace("<object>","product id"));
                }
            }

            transactionMerchantEntity.setTotalAmount(totalAmount);
            transactionMerchantEntity.setPaid(transactions.getPayment());
            transactionMerchantEntity.setChanged(transactions.getPayment() - totalAmount);
            transactionMerchantEntity.setItems(transactionMerchantItemEntities);
            merchantTransactionProductDao.save(transactionMerchantEntity);
           // LoggerHelper.info("insertTransaction", gson.toJson( updateTransactionQTY(transactions)));

            merchantTransactionProductDao.flush();
            updateTransactionQTY(transactions);
//            LoggerHelper.info("insertTransaction", gson.toJson( updateTransactionQTY(transactions)));

            return transactionMerchantEntity;

        }catch (NotFoundException e){
            throw new NotFoundException(e.getMessage());
        } catch (Exception e){
            throw new Exception("Exception "  + e.getMessage());
        }
    }


    private TransactionMerchantEntity updateTransactionQTY(TransactionMerchant transactions) throws Exception {
        try {
//            Gson gson = new Gson();
//            LoggerHelper.info("updateTransactionQTY", gson.toJson(transactions));

            TransactionMerchantEntity transactionMerchantEntity = new TransactionMerchantEntity();
            transactionMerchantEntity.setTotalItem(transactions.getItems().size());

            double totalAmount = 0;
            ArrayList<MerchantProductEntity> transactionMerchantItemEntities = new ArrayList<>();

            for(TransactionMerchant.Items items : transactions.getItems()){
                //LoggerHelper.info("TransactionMerchant for loop",gson.toJson(items));
                boolean isExist = merchantProductDao.existsById(items.getProductId());

                if(isExist){
                    MerchantProductEntity merchantProductEntity = merchantProductDao.findById(items.getProductId()).get();
                    merchantProductEntity.setQuantity(merchantProductEntity.getQuantity() - items.getQuantity());
                    //LoggerHelper.info("TransactionMerchant is exist", gson.toJson( merchantProductEntity));
                    transactionMerchantItemEntities.add(merchantProductEntity);
                }else{
                    throw new NotFoundException(Message.ERROR_MESSAGE_FOR_NOT_EXIST.replace("<object>","product id"));
                }
            }

            merchantProductDao.saveAll(transactionMerchantItemEntities);
            merchantProductDao.flush();

            return transactionMerchantEntity;

        }catch (NotFoundException e){
            throw new NotFoundException(e.getMessage());
        } catch (Exception e){
            throw new Exception("Exception "  + e.getMessage());
        }

    }

    public ArrayList<TransactionMerchantEntity> getAll() throws Exception {
        try {
            return (ArrayList<TransactionMerchantEntity>) merchantTransactionProductDao.findAll(Sort.by(Sort.Direction.DESC, "transMerchantId"));
//            return (ArrayList<TransactionMerchantEntity>) merchantTransactionProductDao.findAll(Sort.by(Sort.Direction.ASC, "seatNumber"));
        } catch (Exception e) {
            throw new Exception("Exception " + e.getMessage());
        }
    }
}
