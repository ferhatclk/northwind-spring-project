package com.etiya.northwind.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.etiya.northwind.business.abstracts.CustomerService;
import com.etiya.northwind.business.responses.customers.CustomerListResponse;
import com.etiya.northwind.dataAccess.abstracts.CustomerRepository;
import com.etiya.northwind.entities.concretes.Customer;

@Service
public class CustomerManager implements CustomerService{
	private CustomerRepository customerRepository;

	public CustomerManager(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	@Override
	public List<CustomerListResponse> getAll() {
		List<Customer> result = this.customerRepository.findAll();
		List<CustomerListResponse> response = new ArrayList<CustomerListResponse>();
		
		for (Customer customer : result) {
			CustomerListResponse customerResponse = new CustomerListResponse();
			customerResponse.setAddress(customer.getAddress());
			customerResponse.setCity(customer.getCity());
			customerResponse.setCompanyName(customer.getCompanyName());
			customerResponse.setContactName(customer.getContactName());
			customerResponse.setContactTitle(customer.getContactTitle());
			customerResponse.setCustomerId(customer.getCustomerId());
			response.add(customerResponse);
		}
		
		return response;
	}
}
