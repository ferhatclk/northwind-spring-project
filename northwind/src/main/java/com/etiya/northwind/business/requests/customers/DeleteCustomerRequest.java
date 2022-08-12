package com.etiya.northwind.business.requests.customers;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeleteCustomerRequest {
    @NotNull
    @NotBlank
	private String customerId;
}
