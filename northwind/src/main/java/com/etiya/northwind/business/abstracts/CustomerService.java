package com.etiya.northwind.business.abstracts;

import java.util.List;

import com.etiya.northwind.business.requests.customers.CreateCustomerRequest;
import com.etiya.northwind.business.requests.customers.DeleteCustomerRequest;
import com.etiya.northwind.business.requests.customers.UpdateCustomerRequest;
import com.etiya.northwind.business.responses.customers.CustomerGetResponse;
import com.etiya.northwind.business.responses.customers.CustomerListResponse;
import com.etiya.northwind.core.utilities.results.DataResult;
import com.etiya.northwind.core.utilities.results.Result;


public interface CustomerService {
	Result add(CreateCustomerRequest createCustomerRequest);
	Result delete(DeleteCustomerRequest deleteCustomerRequest);
	Result update(UpdateCustomerRequest updateCustomerRequest);
	DataResult<CustomerGetResponse>  getById(String customerId);
	DataResult< List<CustomerListResponse>> getAll();
	DataResult<List<CustomerListResponse>> getAllByPageNumber(int pageNo, int pageSize);
	DataResult<List<CustomerListResponse>> getAllSortedByDesc(String field);
	DataResult<List<CustomerListResponse>> getAllSortedByAsc(String field);
	
}
