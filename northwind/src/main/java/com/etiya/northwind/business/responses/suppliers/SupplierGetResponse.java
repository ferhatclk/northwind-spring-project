package com.etiya.northwind.business.responses.suppliers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SupplierGetResponse {
	private String companyName;
	
	private String contactName;
	
	private String contactTitle;
	
	private String address;
}
