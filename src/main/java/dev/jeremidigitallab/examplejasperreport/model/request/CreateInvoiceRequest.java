package dev.jeremidigitallab.examplejasperreport.model.request;

import dev.jeremidigitallab.examplejasperreport.model.Customer;
import dev.jeremidigitallab.examplejasperreport.model.Product;
import lombok.Data;

@Data
public class CreateInvoiceRequest {

	private String invoiceNumber;
	private String invoiceDate;
	private Customer customer;
	private Product product;
	
}
