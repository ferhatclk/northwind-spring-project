package com.etiya.northwind.business.requests.orderDetails;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeleteOrderDetailRequest {
    @NotNull
    @Positive
	private int orderId;
    
    @NotNull
    @Positive
	private int productId;
}
