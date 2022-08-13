package com.etiya.northwind.business.responses.carts;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartGetResponse {
	private int cartId;
	
	private String customerId;

	private int quantity;
	
	private double totalPrice;
}
