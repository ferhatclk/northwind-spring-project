package com.etiya.northwind.business.responses.cartDetails;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartDetailListResponse {
	private int id;
	
	private int productId;
	
	private int productQuantity;
	
	private double productUnitPrice;
	
	private int cartCartId;
}
