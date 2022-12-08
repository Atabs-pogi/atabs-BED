package com.atabs.atabbe.service;

import com.atabs.atabbe.dao.CreditDao;
import com.atabs.atabbe.entity.CreditEntity;
import com.atabs.atabbe.entity.PosEntity;
import com.atabs.atabbe.model.Credit;
import com.atabs.atabbe.model.Pos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CreditService {

    @Autowired
    private CreditDao creditDao;

    public String addBal(Credit credit) {
        CreditEntity creditEntity = new CreditEntity();
        creditEntity.setBalance(credit.getBalance());
        creditEntity.setCashierId(credit.getCashiedId());
        creditEntity.setCredit(credit.getCredit());
        creditEntity.setCashierName(credit.getCashierName());
        creditDao.save(creditEntity);
        return "Successful";
    }

    public List<Credit> searchCreditByName(String name) {
        List<CreditEntity> entityCredit = (List<CreditEntity>) creditDao.searchCreditByName(name);
        List<Credit> credit = new ArrayList<>();
        for (CreditEntity credits : entityCredit) {
            credit.add(Credit.from(credits));
        }
        return credit;
    }
}
