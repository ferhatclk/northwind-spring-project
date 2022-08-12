package com.etiya.northwind.business.requests.orders;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateOrderRequest {
	@NotNull
	@Positive
	private int orderId;
	

	private LocalDate orderDate;
	private LocalDate requiredDate;
	private LocalDate shippedDate;
	
    @NotNull
    @NotBlank
	private String customerId;
    
    @NotNull
    @Positive
	private int employeeId;
}
