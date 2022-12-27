package com.atabs.atabbe.service;

import com.atabs.atabbe.dao.MerchantProductDao;
import com.atabs.atabbe.dao.MerchantTransactionProductDao;
import com.atabs.atabbe.entity.*;
import com.atabs.atabbe.exception.NotFoundException;
import com.atabs.atabbe.helper.LoggerHelper;
import com.atabs.atabbe.helper.Message;
import com.atabs.atabbe.model.MerchantProduct;
import com.atabs.atabbe.model.Transaction;
import com.atabs.atabbe.model.TransactionMerchant;
import com.atabs.atabbe.model.TransactionResponse;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MerchantProductService {
    @Autowired
    private MerchantProductDao merchantProductDao;

    @Autowired
    private MerchantTransactionProductDao merchantTransactionProductDao;



    public String addProduct(MerchantProduct merchantProduct){
        MerchantProductEntity merchantProductEntity= new MerchantProductEntity();
        merchantProductEntity.setItem(merchantProduct.getItem());
        merchantProductEntity.setQuantity(merchantProduct.getQuantity());
        merchantProductEntity.setPrice(merchantProduct.getPrice());
        merchantProductDao.save(merchantProductEntity);
        return "Product added successfully";
    }


    public List<MerchantProductEntity> getProduct() {
        return merchantProductDao.findAll();
    }

    public String updateProduct(MerchantProduct merchantProduct) {
        MerchantProductEntity merchantProductEntity= merchantProductDao.findById(merchantProduct.getProductId()).orElse(null);
        assert merchantProductEntity != null;
        merchantProductEntity.setItem(merchantProduct.getItem());
        merchantProductEntity.setQuantity(merchantProduct.getQuantity());
        merchantProductEntity.setPrice(merchantProduct.getPrice());
        merchantProductDao.save(merchantProductEntity);
        return "Update Successfully";
    }

    public List<MerchantProduct> searchProductByName(String name) {
        List<MerchantProductEntity> entityProducts = merchantProductDao.searchProductByName(name);
//        LoggerHelper.info("MerchantService", new Gson().toJson(entityProducts));
        List<MerchantProduct> products = new ArrayList<>();
        for (MerchantProductEntity product : entityProducts) {
            products.add(MerchantProduct.from(product));
            System.out.println(product.getProductId());
        }
        return products;
    }


    public TransactionMerchantEntity insertTransaction(TransactionMerchant transactions) throws Exception {
        try{
            Gson gson = new Gson();
            LoggerHelper.info("insertTransaction",gson.toJson(transactions));

            TransactionMerchantEntity transactionMerchantEntity = new TransactionMerchantEntity();
            transactionMerchantEntity.setTotalItem(transactions.getItems().size());

            transactionMerchantEntity.setTotalItem(transactions.getItems().size());

            double totalAmount = 0;
            ArrayList<TransactionMerchantItemEntity> transactionMerchantItemEntities = new ArrayList<>();
            for(TransactionMerchant.Items items : transactions.getItems()){

                totalAmount += items.getSubAmount();
                TransactionMerchantItemEntity transactionMerchantItemEntity = new TransactionMerchantItemEntity();
                transactionMerchantItemEntity.setMerchantId(items.getMerchantId());
                transactionMerchantItemEntity.setName(items.getName());
                transactionMerchantItemEntity.setQuantity(items.getQuantity());
                transactionMerchantItemEntity.setPrice(items.getPrice());
                transactionMerchantItemEntity.setSubAmount(items.getSubAmount());
                transactionMerchantItemEntities.add(transactionMerchantItemEntity);
            }

            transactionMerchantEntity.setTotalAmount(totalAmount);
            transactionMerchantEntity.setPaid(transactions.getPayment());
            transactionMerchantEntity.setChanged(transactions.getPayment() - totalAmount);
            transactionMerchantEntity.setItems(transactionMerchantItemEntities);
            merchantTransactionProductDao.save(transactionMerchantEntity);
            merchantTransactionProductDao.flush();
            return transactionMerchantEntity;



        } catch (Exception e){
            throw new Exception("Exception "  + e.getMessage());
        }

    }

    public ArrayList<TransactionMerchantEntity> getAll() throws Exception {
        try{
            return (ArrayList<TransactionMerchantEntity>) merchantTransactionProductDao.findAll();

        } catch (Exception e){
            throw new Exception("Exception "  + e.getMessage());
        }

    }
}
