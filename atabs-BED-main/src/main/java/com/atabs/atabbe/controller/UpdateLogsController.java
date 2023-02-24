package com.atabs.atabbe.controller;

import com.atabs.atabbe.dao.TuxyLogsDao;
import com.atabs.atabbe.model.UpdateTuxy;
import com.atabs.atabbe.service.TuxyLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import net.sf.jasperreports.engine.JRException;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@RestController
@RequestMapping("updateLogs")
@CrossOrigin
public class UpdateLogsController {

    @Autowired
    private TuxyLogService tuxyService;
    @Autowired
    private TuxyLogsDao tuxyLogsDao;

    @PostMapping("/add")
    public ResponseEntity addTuxy(@RequestBody UpdateTuxy updateTuxy) {
        return new ResponseEntity(tuxyService.AddLogs(updateTuxy), HttpStatus.CREATED);
    }
    
    @GetMapping("/search")
    public ResponseEntity search(@RequestParam("name") String name) {
        return new ResponseEntity(tuxyService.searchByName(name), HttpStatus.CREATED);
    }

    @GetMapping(value = "/report", produces = { MediaType.APPLICATION_PDF_VALUE, MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_OCTET_STREAM_VALUE,
            "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet",
            "application/vnd.openxmlformats-officedocument.wordprocessingml.document" })
    public ResponseEntity<byte[]> generateReport(@RequestParam String startDate, @RequestParam String endDate,
                                                 @RequestParam String format) throws ParseException, JRException {
        LocalDateTime startDateTime = LocalDateTime.parse(startDate, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        LocalDateTime endDateTime = LocalDateTime.parse(endDate, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        byte[] reportBytes = tuxyService.generateReport(startDateTime, endDateTime, format);
        HttpHeaders headers = new HttpHeaders();
        headers.setCacheControl(CacheControl.noCache().getHeaderValue());
        headers.setContentType(getMediaType(format));
        headers.set(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=" + "TUXYLOGS_" + startDate + "_to_" + endDate + "." + format);
        ResponseEntity<byte[]> response = new ResponseEntity<>(reportBytes, headers, HttpStatus.OK);
        return response;
    }

    private MediaType getMediaType(String format) {
        switch (format) {
            case "pdf":
                return MediaType.APPLICATION_PDF;
            case "json":
                return MediaType.APPLICATION_JSON;
            case "xml":
                return MediaType.APPLICATION_XML;
            case "xlsx":
                return new MediaType("application", "vnd.openxmlformats-officedocument.spreadsheetml.sheet");
            case "docx":
                return new MediaType("application", "vnd.openxmlformats-officedocument.wordprocessingml.document");
            default:
                return MediaType.APPLICATION_OCTET_STREAM;
        }
    }
}















