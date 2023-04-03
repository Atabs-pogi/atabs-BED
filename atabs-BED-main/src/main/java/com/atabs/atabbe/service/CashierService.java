package com.atabs.atabbe.service;

import com.atabs.atabbe.dao.CashierDao;
import com.atabs.atabbe.entity.CashierEntity;
import com.atabs.atabbe.entity.PosEntity;
import com.atabs.atabbe.exception.NotFoundException;
import com.atabs.atabbe.model.Cashier;
import com.atabs.atabbe.model.Pos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class CashierService {

    @Autowired

    private CashierDao cashierDao;


    public String addCashier(Cashier cashier) {
        CashierEntity cashierEntity = new CashierEntity();
        if (String.valueOf(cashier.getMerchandisePrice()) != null) {
            cashierEntity.setCashierTotal(cashier.getCashierTotal() - cashier.getMerchandisePrice());
            cashierEntity.setMerchandisePrice(cashier.getMerchandisePrice());
            cashierEntity.setTransactionId(cashier.getTransactionId());
            cashierEntity.setFarmerId(cashier.getFarmerId());
            cashierDao.save(cashierEntity);
            return "Successful";
        } else {
            return "Invalid Data";
        }
    }

    public List<Cashier> searchCashierByName(String name) {
        List<CashierEntity> entityPos = (List<CashierEntity>) cashierDao.searchCashierByName(name);
        List<Cashier> cashiers = new ArrayList<>();
        for (CashierEntity cashier : entityPos) {
            cashiers.add(Cashier.from(cashier));
        }
        return cashiers;
    }

    public CashierEntity getCashierInfo(long cashier_id) {
        return cashierDao.getCashierInfo(cashier_id);
    }
}
