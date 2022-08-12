package com.etiya.northwind.business.responses.carts;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartListResponse {
	private int cartId;
	
	private List<Integer> productIds;
	
	private String customerId;

	private int quantity;
	
	private double unitPrice;
}
