package dev.jeremidigitallab.examplejasperreport.function;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import dev.jeremidigitallab.examplejasperreport.model.request.CreateInvoiceRequest;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

@Component
public class GenerateReport {
	
	public ByteArrayResource generateInvoice(CreateInvoiceRequest createInvoiceRequest) throws FileNotFoundException, JRException {
		
		// 1. Get The JRXML 
		File file = ResourceUtils.getFile("classpath:example-invoice.jrxml");
		
		// 2. Create JasperReport object
		JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
		
		// 3. Build Parameters for reports
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("INVOICE_NUMBER", createInvoiceRequest.getInvoiceNumber());
		parameters.put("INVOICE_DATE", createInvoiceRequest.getInvoiceDate());
		parameters.put("CUSTOMER_NAME", createInvoiceRequest.getCustomer().getCustomerName());
		parameters.put("CUSTOMER_ADDRESS", createInvoiceRequest.getCustomer().getCustomerAddress());
		parameters.put("CUSTOMER_EMAIL", createInvoiceRequest.getCustomer().getCustomerEmail());
		parameters.put("CUSTOMER_PHONE_NUMBER", createInvoiceRequest.getCustomer().getCustomerPhoneNumber());
		parameters.put("PRODUCT_ID", createInvoiceRequest.getProduct().getProductId());
		parameters.put("PRODUCT_NAME", createInvoiceRequest.getProduct().getProductName());
		parameters.put("UNIT_PRICE", createInvoiceRequest.getProduct().getUnitPrice());
		parameters.put("BUY_QUANTITY", createInvoiceRequest.getProduct().getBuyQuantity());
		parameters.put("TOTAL_PRICE", createInvoiceRequest.getProduct().getTotalPrice());
		
		// 4. Fill and Create Report
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, new JREmptyDataSource());
		
		// 5. Return As bytes
		return new ByteArrayResource(JasperExportManager.exportReportToPdf(jasperPrint));	
	}
}
