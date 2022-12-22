package com.atabs.atabbe.service;

import com.atabs.atabbe.dao.MerchantProductDao;
import com.atabs.atabbe.entity.MerchantProductEntity;
import com.atabs.atabbe.helper.LoggerHelper;
import com.atabs.atabbe.model.MerchantProduct;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MerchantProductService {
    @Autowired
    private MerchantProductDao merchantProductDao;
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
        LoggerHelper.info("MerchantService", new Gson().toJson(entityProducts));
        List<MerchantProduct> products = new ArrayList<>();
        for (MerchantProductEntity product : entityProducts) {
            products.add(MerchantProduct.from(product));
            System.out.println(product.getProductId());
        }
        return products;
    }
}
