package com.etiya.northwind.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.etiya.northwind.business.abstracts.EmployeeService;

import com.etiya.northwind.business.responses.employees.EmployeeListResponse;
import com.etiya.northwind.dataAccess.abstracts.EmployeeRepository;

import com.etiya.northwind.entities.concretes.Employee;

@Service
public class EmployeeManager implements EmployeeService{
	private EmployeeRepository employeeRepository;
	
	public EmployeeManager(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@Override
	public List<EmployeeListResponse> getAll() {
		List<Employee> result = this.employeeRepository.findAll();
		List<EmployeeListResponse> response = new ArrayList<EmployeeListResponse>();
		
		for (Employee employee : result) {
			EmployeeListResponse employeeResponse = new EmployeeListResponse();
			employeeResponse.setAddress(employee.getAddress());
			employeeResponse.setBirthDate(employee.getBirthDate());
			employeeResponse.setEmployeeId(employee.getEmployeeId());
			employeeResponse.setFirstName(employee.getFirstName());
			employeeResponse.setLastName(employee.getLastName());
			employeeResponse.setTitle(employee.getTitle());
			response.add(employeeResponse);
		}
		
		return response;
	}

}
