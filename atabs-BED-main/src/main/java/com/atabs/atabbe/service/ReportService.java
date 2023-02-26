package com.atabs.atabbe.service;


import com.atabs.atabbe.dao.FarmerDao;
import com.atabs.atabbe.dao.TuxyLogsDao;
import com.atabs.atabbe.entity.EmployeeEntity;
import com.atabs.atabbe.entity.FarmerEntity;
import com.atabs.atabbe.entity.TuxyLogsEntity;
import com.atabs.atabbe.model.ReportDetailDto;
import com.google.gson.Gson;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;
import net.sf.jasperreports.export.SimpleXlsxReportConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.io.*;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;

@Service
public class ReportService {


    private
    @Autowired
    DataSource dataSource;
    private  @Autowired
    ResourceLoader resourceLoader;

    @Value("${path-slash}")
    private String pathSlash;

    public InputStream exportReport(final ReportDetailDto reportDetail)
            throws JRException, SQLException, IOException {
        InputStream reportStream = null;
        Resource resource = resourceLoader.getResource("classpath:report/" + reportDetail.getModule()
                .concat("/")
                .concat(reportDetail.getFilename())
                .concat(".jrxml"));
        try (InputStream jrxml = resource.getInputStream()) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            JasperCompileManager.compileReportToStream(jrxml, byteArrayOutputStream);
            reportStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        }

        Map<String, Object> params = reportDetail.getParams();

        params.put("SUBREPORT", "reports/" + reportDetail.getModule() + "/");
        System.out.println(params);
        System.out.println(params.get("Date_Start"));
        System.out.println(params.get("Date_End"));
//        Date date1 = null;
//        Date date2 = null;
//        DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
//        try {
//            date1 = format.parse(params.get("date_start").toString());
//            date2 = format.parse(params.get("date_end").toString());
//        } catch (ParseException e) {
//            throw new RuntimeException(e);
//        }
//
//
//        System.out.println("sDate1"+"\t"+date1);
//        System.out.println("sDate2"+"\t"+date2);
//        params.put("Date_Start", date1);
//        params.put("Date_End", date2);
        final byte[] report = generateReportFile(reportStream, reportDetail.getFormat(), params);

        try (FileOutputStream fileOutputStream = new FileOutputStream(
                String.format("%s,%s", reportDetail.getFilename(), reportDetail.getFormat()))) {
            fileOutputStream.write(report);
            fileOutputStream.flush();
        }
        final InputStream myInputStream = new ByteArrayInputStream(report);
        return myInputStream;
    }


    @SuppressWarnings("rawtypes")
    private JRAbstractExporter getExporter(String reportFormat) {
        switch (reportFormat) {

            case "doc": {
                return new JRDocxExporter();
            }

            case "xlsx": {
                return new JRXlsxExporter();
            }
            case "pdf": {
                final JRPdfExporter exporter = new JRPdfExporter();
                final SimplePdfExporterConfiguration configuration = new SimplePdfExporterConfiguration();
                configuration.setCompressed(true);
                exporter.setConfiguration(configuration);
                return exporter;
            }
            default:
                throw new IllegalArgumentException("Unknown export type " + reportFormat);
        }

    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    private byte[] generateReportFile(InputStream reportStream, String reportFormat, Map<String, Object> params)
            throws JRException, SQLException {
        final JasperReport jasperReport = (JasperReport) JRLoader.loadObject(reportStream);
        if (jasperReport == null) {
            throw new JRException("Cannot build report from stream");
        }

        jasperReport.setProperty(JRTextField.PROPERTY_PRINT_KEEP_FULL_TEXT, "true");
        final JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, dataSource.getConnection());
        final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        final JRAbstractExporter exporter = getExporter(reportFormat);
        exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
        exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(outputStream));
        exporter.exportReport();

        return outputStream.toByteArray();
    }


    @SuppressWarnings({ "unchecked", "rawtypes" })
    private byte[] sample(InputStream reportStream, String reportFormat, Map<String, Object> params)
            throws JRException, SQLException {
        final JasperReport jasperReport = (JasperReport) JRLoader.loadObject(reportStream);
        if (jasperReport == null) {
            throw new JRException("Cannot build report from stream");
        }
        List<FarmerEntity> coops = farmerDao.getDetails(String.valueOf(130099952));
        Gson gson = new Gson();
        System.out.println(gson.toJson(coops));
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(coops);

//        InputStream inputStream = getClass().getResourceAsStream("classpath:/report/tuxy/TUXYLOGS.jrxml");
//        JasperReport jasperReport = JasperCompileManager.compileReport(inputStream);
//        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, dataSource);

        jasperReport.setProperty(JRTextField.PROPERTY_PRINT_KEEP_FULL_TEXT, "true");
        final JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, dataSource);
        final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        final JRAbstractExporter exporter = getExporter(reportFormat);
        exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
        exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(outputStream));
        exporter.exportReport();

        return outputStream.toByteArray();
    }

    @Autowired
    private TuxyLogsDao tuxyLogsDao;

    @Autowired
    private FarmerDao farmerDao;
    public byte[] generateReport( String format) throws JRException {
//        List<TuxyLogsEntity> coops = tuxyLogsDao.findByCreateDateBetween(startDate, endDate);
        List<FarmerEntity> coops = farmerDao.getDetails(String.valueOf(130099952));
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
        org.apache.commons.io.output.ByteArrayOutputStream baos = new org.apache.commons.io.output.ByteArrayOutputStream();
        exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
        exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, baos);
        exporter.exportReport();
        return baos.toByteArray();
    }

    private String getParent(String resourcePath) {
        int index = resourcePath.lastIndexOf('/');
        if (index > 0) {
            return resourcePath.substring(0, index)+"/";
        }
        return "/";
    }
}





