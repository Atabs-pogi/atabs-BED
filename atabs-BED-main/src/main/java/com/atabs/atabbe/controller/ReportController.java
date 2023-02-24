package com.atabs.atabbe.controller;

//import com.atabs.atabbe.model.ReportDetailDto;
//import com.atabs.atabbe.service.ReportService;
//import net.sf.jasperreports.engine.JRException;
//import org.apache.commons.compress.utils.IOUtils;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
////import javax.inject.Inject;
//import java.io.IOException;
//import java.io.InputStream;
//import java.sql.SQLException;
//
//@RestController
//@RequestMapping("/report")
//public class ReportController {
//    private @Inject ReportService reportService;
//
//    @PostMapping(value = "/generate", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
//    public ResponseEntity<?> generateReport(@RequestBody ReportDetailDto reportDetail)
//            throws JRException, SQLException, IOException {
//
//        try {
//            final InputStream is = reportService.exportReport(reportDetail);
//            final byte[] bytes = IOUtils.toByteArray(is);
//            return ResponseEntity.ok()
//                    .header("Content-Disposition",
//                            "attachment; filename=\"" + String.format("%s.%s", reportDetail.getFilename(),
//                                    reportDetail.getFormat()) + "\"")
//                    .body(bytes);
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.out.println("Error: "+ e);
//            return ResponseEntity.ok().body("Error in exporting report. " + e);
//        }
//    }
//
//    private class JRException extends Exception {
//    }
//}

