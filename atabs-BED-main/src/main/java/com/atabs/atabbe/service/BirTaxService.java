package com.atabs.atabbe.service;

import com.atabs.atabbe.dao.BirTaxDao;
import com.atabs.atabbe.entity.BirTaxEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class BirTaxService {

    @Autowired
    private BirTaxDao dao;

    public List<BirTaxEntity> getAll(){
        return (ArrayList<BirTaxEntity>) dao.findAll();
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
