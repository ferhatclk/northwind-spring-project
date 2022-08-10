package com.etiya.northwind.business.abstracts;

import java.util.List;

import com.etiya.northwind.business.requests.employees.CreateEmployeeRequest;
import com.etiya.northwind.business.requests.employees.DeleteEmployeeRequest;
import com.etiya.northwind.business.requests.employees.UpdateEmployeeRequest;
import com.etiya.northwind.business.responses.employees.EmployeeGetResponse;
import com.etiya.northwind.business.responses.employees.EmployeeListResponse;


public interface EmployeeService {
	void add(CreateEmployeeRequest createEmployeeRequest);
	void delete(DeleteEmployeeRequest deleteEmployeeRequest);
	void update(UpdateEmployeeRequest updateEmployeeRequest);
	List<EmployeeListResponse> getAll();
	List<EmployeeListResponse> getByPageNumber(int pageNo, int pageSize);
	List<EmployeeListResponse> getAllSortedByDesc(String field);
	List<EmployeeListResponse> getAllSortedByAsc(String field);
	EmployeeGetResponse getById(int id);
}
