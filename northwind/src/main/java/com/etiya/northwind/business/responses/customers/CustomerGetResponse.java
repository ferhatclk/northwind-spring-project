package com.etiya.northwind.business.responses.customers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerGetResponse {
	private String companyName;
	
	private String contactName;
	
	private String contactTitle;
	
	private String address;
	
	private String city;
}
