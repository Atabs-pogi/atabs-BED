package com.atabs.atabbe.service;

import com.atabs.atabbe.dao.BirTaxDao;
import com.atabs.atabbe.entity.BirTaxEntity;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class BirTaxService {

    @Autowired
    private BirTaxDao dao;

    public List<BirTaxEntity> getAll(){
        return (ArrayList<BirTaxEntity>) dao.findAll();
    }

    public String upload() {
        try {
            InputStream inputStream = file.getInputStream();
            Workbook workbook = new XSSFWorkbook(inputStream);
            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                SecurityProperties.User user = new SecurityProperties.User();
                user.setName(row.getCell(0).getStringCellValue());
                user.setEmail(row.getCell(1).getStringCellValue());
                user.setPhone(row.getCell(2).getStringCellValue());
                userRepository.save(user);
            }

            return "File uploaded successfully!";
        } catch (IOException e) {
            e.printStackTrace();
            return "Error uploading file.";
        }
    }



    @Transactional
    public List<BirTaxEntity> save(List<BirTaxEntity> birTax) {
        return dao.saveAll(birTax);
    }

    @Transactional
    public BirTaxEntity update(BirTaxEntity birTax){
        birTax = dao.findById(birTax.getId()).orElse(null);
        if (birTax != null) {
            birTax.setMinimum(birTax.getMinimum());
            birTax.setMaximum(birTax.getMaximum());
            birTax.setFixTax(birTax.getFixTax());
            birTax.setTaxRateOnExcess(birTax.getFixTax());
            return birTax;
        }else {
            throw new IllegalStateException("This ID cannot be found");
        }
    }
}
