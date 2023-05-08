package dev.jeremidigitallab.examplejasperreport.controller;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import dev.jeremidigitallab.examplejasperreport.function.GenerateReport;
import dev.jeremidigitallab.examplejasperreport.model.request.CreateInvoiceRequest;
import net.sf.jasperreports.engine.JRException;

@Controller
@RequestMapping("/report")
public class ReportController {

	@Autowired
	GenerateReport generateReport;
	
	@PostMapping("/generate-invoice")
	public ResponseEntity<Resource> generateInvoice(HttpServletResponse response, @RequestBody CreateInvoiceRequest request) throws FileNotFoundException, JRException, IOException {
		
		// 1. Headers For "Download-able" Resource
		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=invoice.pdf");
        
        return ResponseEntity
        		.ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(generateReport.generateInvoice(request));
	}
}

