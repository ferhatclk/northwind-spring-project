package com.etiya.northwind.business.requests.categories;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCategoryRequest {
	@NotNull
    @Positive
	private int categoryId;
	
	@NotNull
	@NotBlank
	private String categoryName;
}
