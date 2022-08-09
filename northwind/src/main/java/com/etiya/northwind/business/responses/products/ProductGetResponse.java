package com.etiya.northwind.business.responses.products;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductGetResponse {
	private String productName;
	
	private double unitPrice;
	
	private int unitsInStock;
	
	private int discontinued;
	
	private int categoryId;

	private String categoryName;
	
	private int supplierId;
	
	private String supplierCompanyName;
}
