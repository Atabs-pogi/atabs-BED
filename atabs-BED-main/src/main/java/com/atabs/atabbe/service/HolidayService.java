package com.atabs.atabbe.service;

import com.atabs.atabbe.dao.HolidayDao;
import com.atabs.atabbe.entity.HolidayEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class HolidayService {

    @Autowired
    private HolidayDao dao;

    public List<HolidayEntity> getAll(LocalDate start, LocalDate end) {
        LocalDate nStart = LocalDate.now().withDayOfYear(1);
        LocalDate nEnd = nStart.plusYears(1);
        if(start != null) {
            nStart = start;
        }
        if(end != null) {
            nEnd = end;
        }
        return dao.getHolidaysBetween(nStart, nEnd);
    }

    public String save(HolidayEntity holiday) {
        HolidayEntity existing = dao.getByDescriptionAndDate(holiday.getDescription(), holiday.getDate());
        if (existing != null) {
            return "Holiday Already Exist";
        }
        dao.save(holiday);
        return "Successful";
    }

    public String update(HolidayEntity holiday) {
        if (holiday.getId() == 0) {
            return "Id is missing";
        }
        dao.save(holiday);
        return "Successful";
    }

    public String delete(Long id) {
        HolidayEntity entity = dao.findById(id).orElse(null);
        if (entity == null) {
            return "Id does not exist";
        }
        dao.delete(entity);
        return "Successful";
    }

    @Transactional
    public String clear() {
        // Delete all holidays
        LocalDate start = LocalDate.now().withDayOfYear(1);
        LocalDate end = start.plusYears(1);
        List<HolidayEntity> existing = this.getAll(start, end);
        List<Long>ids = new ArrayList<>();
        for (HolidayEntity holiday: existing) {
            ids.add(holiday.getId());
        }
        dao.deleteAllByIdInBatch(ids);
        return "Successful";
    }
}
