package com.atabs.atabbe.service;



import com.atabs.atabbe.dao.TuxyDao;
import com.atabs.atabbe.dao.TuxyLogsDao;
import com.atabs.atabbe.entity.TuxyEntity;
import com.atabs.atabbe.entity.TuxyLogsEntity;
import com.atabs.atabbe.helper.Message;
import com.atabs.atabbe.model.UpdateTuxy;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.export.SimpleDocxReportConfiguration;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleXlsxReportConfiguration;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class TuxyLogService {

    @Autowired
    private TuxyLogsDao tuxyLogsDao;
    @Autowired
    private TuxyDao tuxyDao;

    public String AddLogs(UpdateTuxy updateTuxy) {
        try{

            if(tuxyDao.findById(updateTuxy.getTuxyId()).isPresent()){
                TuxyEntity  tuxyEntity =  tuxyDao.findById(updateTuxy.getTuxyId()).get();
                TuxyLogsEntity tuxyLogs = new TuxyLogsEntity();
                tuxyLogs.setTuxyId(updateTuxy.getTuxyId());
                tuxyLogs.setTuxyName(tuxyEntity.getName());
                tuxyLogs.setUpdatedBy("User full name");
                tuxyLogs.setAction(
                        Message.UPDATE_MESSAGE_LOGS
                                .replace("<type>",updateTuxy.getType())
                                .replace("<oldPrice>",String.valueOf(updateTuxy.getOldPrice()))
                                .replace("<newPrice>",String.valueOf(updateTuxy.getNewPrice()))
                );
                tuxyLogsDao.save(tuxyLogs);
            }


            System.out.println( "Success ");
            return "Success";
        }catch (Exception e){
            System.out.println( "Success "  + e.getMessage());
            return "Exception "  + e.getMessage();


        }
    }

//    public ArrayList<TuxyLogsEntity> get() {
//        try{
//            ArrayList<TuxyLogsEntity> arrayList = new ArrayList<>();
//            for(TuxyLogsEntity entity : tuxyLogsDao.findAll()){
//                TuxyLogsEntity tuxyLogs = new TuxyLogsEntity();
//
//            }
//        }catch (Exception e){
//            return null;
//        }
//    }

    public List<TuxyLogsEntity> searchByName(String name) {
        List<TuxyLogsEntity> entityFarmers =  tuxyLogsDao.searchByName(name);
        return entityFarmers;
    }

    public byte[] generateReport(LocalDateTime startDate, LocalDateTime endDate, String format) throws JRException {
        List<TuxyLogsEntity> coops = tuxyLogsDao.findByCreateDateBetween(startDate, endDate);
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(coops);
        InputStream inputStream = getClass().getResourceAsStream("classpath:/report/tuxy/TUXYLOGS.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(inputStream);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, dataSource);
        JRExporter exporter;
        if (format.equals("pdf")) {
            exporter = new JRPdfExporter();
        } else if (format.equals("xlsx")) {
            exporter = new JRXlsxExporter();
            SimpleXlsxReportConfiguration configuration = new SimpleXlsxReportConfiguration();
            configuration.setSheetNames(new String[] { "TUXYLOGS" });
            exporter.setConfiguration(configuration);
        } else if (format.equals("docx")) {
            exporter = new JRDocxExporter();
        } else {
            throw new IllegalArgumentException("Invalid report format specified: " + format);
        }
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
        exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, baos);
        exporter.exportReport();
        return baos.toByteArray();
    }
}





