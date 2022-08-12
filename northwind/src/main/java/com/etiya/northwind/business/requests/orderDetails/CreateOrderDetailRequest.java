package com.etiya.northwind.business.requests.orderDetails;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateOrderDetailRequest {
    @NotNull
    @Positive
	private int orderId;
    
    @NotNull
    @Positive
	private int productId;
    
    @NotNull
    @PositiveOrZero
	private double unitPrice;
    
    @NotNull
    @PositiveOrZero
	private int quantity;
    
    @NotNull
    @PositiveOrZero
	private double discount;
}
