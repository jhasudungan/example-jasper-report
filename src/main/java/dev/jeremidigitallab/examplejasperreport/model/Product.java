package dev.jeremidigitallab.examplejasperreport.model;

import lombok.Data;

@Data
public class Product {

	private String productId;
	private String productName;
	private String unitPrice;
	private String buyQuantity;
	private String totalPrice;
	
}
