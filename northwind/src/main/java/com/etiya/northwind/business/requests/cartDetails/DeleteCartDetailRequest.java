package com.etiya.northwind.business.requests.cartDetails;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeleteCartDetailRequest {
	@NotNull
	@Positive
	private int id;
	
}
