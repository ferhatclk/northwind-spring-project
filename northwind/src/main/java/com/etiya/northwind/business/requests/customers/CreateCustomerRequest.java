package com.etiya.northwind.business.requests.customers;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCustomerRequest {
    @NotEmpty
    @NotBlank
	private String customerId;
    
    @NotNull
    @NotBlank
	private String companyName;
    
    @NotNull
    @NotBlank
	private String contactName;
    
	private String contactTitle;
	
	private String address;
	
	@NotNull
	@Positive
	private int cityId;
}
