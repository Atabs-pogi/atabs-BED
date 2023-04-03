package com.atabs.atabbe.service;

import com.atabs.atabbe.dao.CashierDao;
import com.atabs.atabbe.entity.CashierEntity;
import com.atabs.atabbe.model.Cashier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public List<CashierEntity> searchCashierByName(String name) {
        return cashierDao.searchCashierByName(name);
    }

    public CashierEntity getCashierInfo(long cashier_id) {
        return cashierDao.getCashierInfo(cashier_id);
    }
}
