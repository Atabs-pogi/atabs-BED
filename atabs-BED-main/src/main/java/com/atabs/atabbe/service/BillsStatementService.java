package com.atabs.atabbe.service;

import com.atabs.atabbe.dao.BillTransactionDao;
import com.atabs.atabbe.dao.BillsStatementDao;
import com.atabs.atabbe.entity.*;
import com.atabs.atabbe.model.BillsStatement;
import com.atabs.atabbe.model.ReleaseTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BillsStatementService {

    @Autowired
    private BillsStatementDao billsStatementDao;
    @Autowired
    private BillTransactionDao billTransactionDao;

    public String addBills(BillsStatement billsStatement) {
        BillsStatementEntity billsStatementEntity= new BillsStatementEntity();
        billsStatementEntity.setName(billsStatement.getName());
        billsStatementEntity.setType(billsStatement.getType());
        billsStatementEntity.setDueDate(billsStatement.getDueDate());
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
        billsStatementEntity.setDueDate(billsStatement.getDueDate());
        billsStatementDao.save(billsStatementEntity);
        return "Update Successfully";
    }

    public List<BillsStatement> searchBillsByName(String name) {
        List<BillsStatementEntity> entityBills=billsStatementDao.searchBillsByName(name);
        List<BillsStatement> bills= new ArrayList<>();
        for(BillsStatementEntity billing:entityBills){
            bills.add(BillsStatement.from(billing));
        }
        return bills;

    }
    public List<String> getListName() {
        List<String> entityBills = billsStatementDao.listName();
        return entityBills;

    }


    public String addReleaseTransaction(BillsTransaction billsTransaction) {
        billTransactionDao.save(billsTransaction);
        return "Successful";
    }

    public ArrayList<BillsTransaction> getAll() throws Exception {
        try{
            return (ArrayList<BillsTransaction>) billTransactionDao.findAll();

        } catch (Exception e){
            throw new Exception("Exception "  + e.getMessage());
        }

    }
}
