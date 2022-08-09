package com.etiya.northwind.business.requests.products;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateProductRequest {
	private int productId;
	private String productName;
	private double unitPrice;
	private int unitsInStock;
	private int discontinued;
	private int categoryId;
	private int supplierId;
}
