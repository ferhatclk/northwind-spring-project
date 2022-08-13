package com.etiya.northwind.business.requests.cartDetails;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCartDetailRequest {
	@NotNull
	@Positive
	private int productId;
	
	@NotNull
	@Positive
	private int cartId;
	
	@NotNull
	@Positive
	private int quantity;
}
