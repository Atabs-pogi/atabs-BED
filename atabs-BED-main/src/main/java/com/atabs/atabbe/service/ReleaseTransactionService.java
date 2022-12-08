package com.atabs.atabbe.service;

import com.atabs.atabbe.dao.ReleaseTransactionDao;
import com.atabs.atabbe.entity.PosEntity;
import com.atabs.atabbe.entity.ReleaseTransactionEntity;
import com.atabs.atabbe.model.Pos;
import com.atabs.atabbe.model.ReleaseTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReleaseTransactionService {
    @Autowired
    private ReleaseTransactionDao releaseTransactionDao;

    public String addReleaseTransaction(ReleaseTransaction releaseTransaction) {
        ReleaseTransactionEntity releaseTransactionEntity= new ReleaseTransactionEntity();
        releaseTransactionEntity.setTransactionId(releaseTransaction.getTransactionId());
        releaseTransactionEntity.setReleaseTransactionId(releaseTransaction.getReleaseTransactionId());
        releaseTransactionEntity.setFarmerId(releaseTransaction.getFarmerId());
        releaseTransactionEntity.setStatus(releaseTransaction.getStatus());
        releaseTransactionEntity.setTotalPrice(releaseTransaction.getTotalPrice());
        releaseTransactionDao.save(releaseTransactionEntity);
        return "Successful";
    }

    public ReleaseTransactionEntity getReleaseInfo(long transactions_id) {
        return releaseTransactionDao.getReleaseInfo(transactions_id);
    }
}
