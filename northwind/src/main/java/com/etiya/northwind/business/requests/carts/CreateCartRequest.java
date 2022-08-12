package com.etiya.northwind.business.requests.carts;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCartRequest {

	private int productId;
	
	private String customerId;

	private int quantity;
	
	private double unitPrice;
}
