package com.jsonpdf.controller;

import java.io.*;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLong;

import com.jsonpdf.model.Employee;
import net.sf.jasperreports.engine.JRDataSource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import javax.servlet.http.HttpServletResponse;
import java.util.*;
import org.apache.log4j.Logger;

@RestController
public class ReportController {

    private final AtomicLong counter = new AtomicLong();
    private static Logger log = Logger.getLogger(ReportController.class.getName());

    @RequestMapping(value="/report", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity report(@RequestBody String payload, @RequestParam(value="name") String reportTemplate,
                                 HttpServletResponse response) throws Exception {

        log.info("payload: [" + payload + "] reportTemplate[" + reportTemplate + "] count[" + counter.incrementAndGet() + " calls since start");

        ObjectMapper mapper = new ObjectMapper();
        Employee[] emps = mapper.readValue(payload, Employee[].class);
        List<Employee> list = Arrays.asList(emps);


        InputStream jasperStream = new ClassPathResource("report/" + reportTemplate + ".jasper").getInputStream();

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(baos);

        buildPDF(jasperStream, dos, new HashMap<String, Object>(), list);

        log.info(Arrays.toString(emps));

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        response.setHeader("Content-Disposition","attachment;filename=" + reportTemplate+ ".pdf");
        ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(baos.toByteArray(), headers, HttpStatus.OK);
        return responseEntity;
    }

    public static byte[] buildPDF(InputStream _inputStream, OutputStream _outputStream, Map<String, Object> _parameters, List _list) {
        long start = System.currentTimeMillis();
        byte[] bytes = null;
        try{
            JRDataSource ds = new JRBeanCollectionDataSource(_list);
            JasperRunManager.runReportToPdfStream(_inputStream, _outputStream, _parameters, ds);

        }catch (JRException exc){
            log.error(exc, exc);
        }
        long end = System.currentTimeMillis();
        log.info("Jasper Report load took(ms): " + (end - start));
        return bytes;
    }
}