package com.etiya.northwind.business.responses.carts;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartGetResponse {
	private int cartId;
	
	private List<Integer> productId;
	
	private String customerId;

	private int quantity;
	
	private double unitPrice;
}
