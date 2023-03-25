package com.atabs.atabbe.service;

import com.atabs.atabbe.dao.FiberDao;
import com.atabs.atabbe.dao.FiberNewDao;
import com.atabs.atabbe.dao.FiberPriceDao;
import com.atabs.atabbe.entity.FiberNewEntity;
import com.atabs.atabbe.entity.FiberPricesEntity;
import com.atabs.atabbe.exception.NotFoundException;
import com.atabs.atabbe.model.FiberNew;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class FiberNewService {
    @Autowired
    private FiberNewDao fiberNewDao;
    @Autowired
    private FiberDao fiberDao;
    @Autowired
    private FiberPriceDao fiberPriceDao;



    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd");
    LocalDateTime now = LocalDateTime.now();

    public FiberNewEntity generateFiber(FiberNew fiberNew) throws NotFoundException {
        Integer fiber = fiberNewDao.getFiberId();
        if (fiber == null) {
            fiber = 99;
        }
        FiberNewEntity fiberNewEntity = new FiberNewEntity();
        fiberNewEntity.setExcellentFiberKg(fiberNew.getExcellentFiberKg());
        fiberNewEntity.setGoodFiberKg(fiberNew.getGoodFiberKg());
        fiberNewEntity.setResecoFiberKg(fiberNew.getResecoFiberKg());
        fiberNewEntity.setReferenceCode(String.valueOf(dtf.format(now))+fiber);
        fiberNewDao.save(fiberNewEntity);
        return fiberNewEntity;
    }

    public FiberNewEntity getFiberByID(long id) throws NotFoundException {
        FiberNewEntity fiberNew = fiberNewDao.findById(id).orElse(null);
        if (fiberNew == null) {
            throw new NotFoundException("Fiber New Entity Not Found");
        }
        return fiberNew;
    }

    public FiberPricesEntity getLastestPrices() {
        return fiberPriceDao.getLatestPrice();
    }

    @Transactional
    public FiberNewEntity updateFiber(FiberNew fiberNew) {

        double excellentAmount = 0;
        double goodAmount = 0;
        double resecoAmount = 0;
        double totalAmount = 0;
        FiberNewEntity fiberNewEntity= fiberNewDao.getRefCode(fiberNew.getReferenceCode());
        FiberPricesEntity prices = new FiberPricesEntity();

        excellentAmount = fiberNewEntity.getExcellentFiberKg() * fiberNew.getExcellentFiberPrice();
        goodAmount = fiberNewEntity.getGoodFiberKg() * fiberNew.getGoodFiberPrice();
        resecoAmount = fiberNewEntity.getResecoFiberKg() * fiberNew.getResecoFiberPrice();
        totalAmount = excellentAmount + goodAmount + resecoAmount;

        prices.setExcellentFiberPrice(fiberNew.getExcellentFiberPrice());
        prices.setGoodFiberPrice(fiberNew.getGoodFiberPrice());
        prices.setResecoFiberPrice(fiberNew.getResecoFiberPrice());
        fiberPriceDao.save(prices);

        fiberNewEntity.setExcellentFiberAmount(formatDecimal(excellentAmount));
        fiberNewEntity.setGoodFiberAmount(formatDecimal(goodAmount));
        fiberNewEntity.setResecoFiberAmount(formatDecimal(resecoAmount));
        fiberNewEntity.setFiberTotalAmount(formatDecimal(totalAmount));
        fiberNewEntity.setStatus(1);
        fiberNewDao.save(fiberNewEntity);
        return fiberNewEntity;
    }

    public List<FiberNewEntity> searchFiberByName(String name) {
        return fiberNewDao.searchFiberByName(name);
    }

    private double formatDecimal(double value) {
        DecimalFormat df = new DecimalFormat("#.##");
        df.setMinimumFractionDigits(2);
        df.setMaximumFractionDigits(2);
        String formattedValue = df.format(value);
        return Double.parseDouble(formattedValue);
    }

}
