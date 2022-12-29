package com.atabs.atabbe.service;

import com.atabs.atabbe.dao.BillsStatementDao;
import com.atabs.atabbe.entity.BillsStatementEntity;
import com.atabs.atabbe.entity.MerchantProductEntity;
import com.atabs.atabbe.model.BillsStatement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillsStatementService {

    @Autowired
    private BillsStatementDao billsStatementDao;

    public String addBills(BillsStatement billsStatement) {
        BillsStatementEntity billsStatementEntity= new BillsStatementEntity();
        billsStatementEntity.setName(billsStatement.getName());
        billsStatementEntity.setType(billsStatement.getType());
        billsStatementEntity.setAccountNo(billsStatement.getAccountNo());
        billsStatementEntity.setAmount(billsStatement.getAmount());
        billsStatementDao.save(billsStatementEntity);
        return "Bills added successfully";
    }

    public List<BillsStatementEntity> getBills() {
        return billsStatementDao.findAll();
    }

    public String updateBills(BillsStatement billsStatement) {
        BillsStatementEntity billsStatementEntity= billsStatementDao.findById(billsStatement.getId()).orElse(null);
        assert billsStatementEntity != null;
        billsStatementEntity.setName(billsStatement.getName());
        billsStatementEntity.setType(billsStatement.getType());
        billsStatementEntity.setAccountNo(billsStatement.getAccountNo());
        billsStatementEntity.setAmount(billsStatement.getAmount());
        billsStatementDao.save(billsStatementEntity);
        return "Update Successfully";
    }
}
