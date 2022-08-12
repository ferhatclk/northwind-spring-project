package com.etiya.northwind.business.requests.suppliers;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeleteSupplierRequest {
	@NotNull
    @Positive
	private int supplierId;
}
