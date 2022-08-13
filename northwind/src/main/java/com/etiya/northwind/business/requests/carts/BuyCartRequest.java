package com.etiya.northwind.business.requests.carts;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BuyCartRequest {
	@NotNull
	@NotBlank
	private String customerId;
	
}
