package com.atabs.atabbe.service;


//import com.atabs.atabbe.model.ReportDetailDto;
//import net.sf.jasperreports.engine.*;
//import net.sf.jasperreports.engine.export.JRPdfExporter;
//import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;
//import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
//import net.sf.jasperreports.engine.util.JRLoader;
//import net.sf.jasperreports.export.SimpleExporterInput;
//import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
//import net.sf.jasperreports.export.SimplePdfExporterConfiguration;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.core.io.Resource;
//import org.springframework.core.io.ResourceLoader;
//import org.springframework.stereotype.Service;
//
//import javax.inject.Inject;
//import javax.sql.DataSource;
//import java.io.*;
//import java.sql.SQLException;
//import java.util.Map;
//
//@Service
//public class ReportService {
//
//
//    private
//    @Inject DataSource dataSource;
//    private  @Inject ResourceLoader resourceLoader;
//
//    @Value("${path-slash}")
//    private String pathSlash;
//
//    public InputStream exportReport(final ReportDetailDto reportDetail)
//            throws JRException, SQLException, IOException {
//        InputStream reportStream = null;
//        Resource resource = resourceLoader.getResource("classpath:report/" + reportDetail.getModule()
//                .concat("/")
//                .concat(reportDetail.getFilename())
//                .concat(".jrxml"));
//        try (InputStream jrxml = resource.getInputStream()) {
//            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//            JasperCompileManager.compileReportToStream(jrxml, byteArrayOutputStream);
//            reportStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
//        }
//
//        Map<String, Object> params = reportDetail.getParams();
//
//        params.put("SUBREPORT", "reports/" + reportDetail.getModule() + "/");
//
//        final byte[] report = generateReportFile(reportStream, reportDetail.getFormat(), params);
//
//        try (FileOutputStream fileOutputStream = new FileOutputStream(
//                String.format("%s,%s", reportDetail.getFilename(), reportDetail.getFormat()))) {
//            fileOutputStream.write(report);
//            fileOutputStream.flush();
//        }
//        final InputStream myInputStream = new ByteArrayInputStream(report);
//        return myInputStream;
//    }
//
//
//    @SuppressWarnings("rawtypes")
//    private JRAbstractExporter getExporter(String reportFormat) {
//        switch (reportFormat) {
//
//            case "doc": {
//                return new JRDocxExporter();
//            }
//
//            case "xlsx": {
//                return new JRXlsxExporter();
//            }
//            case "pdf": {
//                final JRPdfExporter exporter = new JRPdfExporter();
//                final SimplePdfExporterConfiguration configuration = new SimplePdfExporterConfiguration();
//                configuration.setCompressed(true);
//                exporter.setConfiguration(configuration);
//                return exporter;
//            }
//            default:
//                throw new IllegalArgumentException("Unknown export type " + reportFormat);
//        }
//
//    }
//
//    @SuppressWarnings({ "unchecked", "rawtypes" })
//    private byte[] generateReportFile(InputStream reportStream, String reportFormat, Map<String, Object> params)
//            throws JRException, SQLException {
//        final JasperReport jasperReport = (JasperReport) JRLoader.loadObject(reportStream);
//        if (jasperReport == null) {
//            throw new JRException("Cannot build report from stream");
//        }
//
//        jasperReport.setProperty(JRTextField.PROPERTY_PRINT_KEEP_FULL_TEXT, "true");
//        final JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, dataSource.getConnection());
//        final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//        final JRAbstractExporter exporter = getExporter(reportFormat);
//        exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
//        exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(outputStream));
//        exporter.exportReport();
//
//        return outputStream.toByteArray();
//    }
//
//    private String getParent(String resourcePath) {
//        int index = resourcePath.lastIndexOf('/');
//        if (index > 0) {
//            return resourcePath.substring(0, index)+"/";
//        }
//        return "/";
//    }
//}





