package com.etiya.northwind.business.requests.employees;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateEmployeeRequest {
    @NotNull
    @Positive
	private int employeeId;
    
    @NotNull
    @NotBlank
	private String firstName;
    
    @NotNull
    @NotBlank
	private String lastName;
    
	private String title;
	
	private LocalDate birthDate;
	
    @NotNull
    @NotBlank
	private String address;
    
	private int reportsTo;
}
