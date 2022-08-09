package com.etiya.northwind.business.responses.products;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductListResponse {
	private int productId;
	
	private String productName;
	
	private double unitPrice;
	
	private int unitsInStock;
	
	private int discontinued;
	
	private int categoryCategoryId;

	private String categoryCategoryName;
	
	private int supplierSupplierId;
	
	private String supplierCompanyName;
	
	private int totalData;
}
