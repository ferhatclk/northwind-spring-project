package com.etiya.northwind.business.responses.orderDetails;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailGetResponse {
	private double unitPrice;
	
	private int quantity;
	
	private double discount;
	
	private int orderId;
	
	private int productId;
	
	private String productName;
}
