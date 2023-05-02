package com.atabs.atabbe.dao;

import com.atabs.atabbe.entity.FarmerEntity;
import com.atabs.atabbe.entity.FiberEntity;
import com.atabs.atabbe.entity.MerchantProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MerchantProductDao extends JpaRepository<MerchantProductEntity, Long> {

    @Query(value = "Select * from merchant_product where product_id =:mrc_id", nativeQuery = true)
    MerchantProductEntity getProductInfo(Long mrc_id);

    @Query(value = "SELECT * FROM merchant_product WHERE item like %:match% OR price like %:match%", nativeQuery = true)
    List<MerchantProductEntity> searchProductByName(String match);

    @Query(value = "SELECT COUNT(product_name) FROM merchant_product WHERE product_name =:productName", nativeQuery = true)
    int findProductByItem(String productName);
}
