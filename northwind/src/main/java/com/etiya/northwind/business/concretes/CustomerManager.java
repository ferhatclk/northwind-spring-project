package com.etiya.northwind.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.etiya.northwind.business.abstracts.CustomerService;
import com.etiya.northwind.business.requests.customers.CreateCustomerRequest;
import com.etiya.northwind.business.requests.customers.DeleteCustomerRequest;
import com.etiya.northwind.business.requests.customers.UpdateCustomerRequest;
import com.etiya.northwind.business.responses.customers.CustomerGetResponse;
import com.etiya.northwind.business.responses.customers.CustomerListResponse;
import com.etiya.northwind.core.utilities.mapping.ModelMapperService;
import com.etiya.northwind.core.utilities.results.DataResult;
import com.etiya.northwind.core.utilities.results.Result;
import com.etiya.northwind.core.utilities.results.SuccessDataResult;
import com.etiya.northwind.core.utilities.results.SuccessResult;
import com.etiya.northwind.dataAccess.abstracts.CustomerRepository;
import com.etiya.northwind.entities.concretes.Customer;

@Service
public class CustomerManager implements CustomerService{
	private CustomerRepository customerRepository;
    private ModelMapperService modelMapperService;

    @Autowired
    public CustomerManager(CustomerRepository customerRepository, ModelMapperService modelMapperService) {
        this.customerRepository = customerRepository;
        this.modelMapperService = modelMapperService;
    }

    @Override
    public Result add(CreateCustomerRequest createCustomerRequest) {
        Customer customer = this.modelMapperService.forRequest().map(createCustomerRequest, Customer.class);
        this.customerRepository.save(customer);
		
        return new SuccessResult();
    }

    @Override
    public Result delete(DeleteCustomerRequest deleteCustomerRequest) {
        this.customerRepository.deleteById(deleteCustomerRequest.getCustomerId());
        
        return new SuccessResult();
    }

    @Override
    public Result update(UpdateCustomerRequest updateCustomerRequest) {
        Customer customer = this.modelMapperService.forRequest().map(updateCustomerRequest, Customer.class);
        this.customerRepository.save(customer);
        
        return new SuccessResult();
    }

    @Override
    public DataResult<CustomerGetResponse> getById(String customerId) {
        Customer customer = this.customerRepository.findById(customerId).get();
        CustomerGetResponse response = this.modelMapperService.forRequest().map(customer, CustomerGetResponse.class);
        
        return new SuccessDataResult<CustomerGetResponse>(response);
    }

    @Override
    public DataResult<List<CustomerListResponse>> getAll() {
        List<Customer> result = this.customerRepository.findAll();
        List<CustomerListResponse> response = result.stream().map(customer -> this.modelMapperService.forResponse()
                .map(customer, CustomerListResponse.class)).collect(Collectors.toList());

        return new SuccessDataResult<List<CustomerListResponse>>(response);
    }

	@Override
	public DataResult<List<CustomerListResponse>> getAllByPageNumber(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo-1, pageSize);
		
		List<Customer> result = this.customerRepository.findAll(pageable).getContent();
		List<CustomerListResponse> response = result.stream().map(customer -> this.modelMapperService.forResponse()
				.map(customer, CustomerListResponse.class)).collect(Collectors.toList());
		
		return new SuccessDataResult<List<CustomerListResponse>>(response);
	}

	@Override
	public DataResult<List<CustomerListResponse>> getAllSortedByDesc(String field) {
		Sort sort = Sort.by(Sort.Order.desc(field));
		List<Customer> result = this.customerRepository.findAll(sort);
        List<CustomerListResponse> response = result.stream().map(customer -> this.modelMapperService.forResponse()
                .map(customer, CustomerListResponse.class)).collect(Collectors.toList());

        return new SuccessDataResult<List<CustomerListResponse>>(response);
	}

	@Override
	public DataResult<List<CustomerListResponse>> getAllSortedByAsc(String field) {
		Sort sort = Sort.by(Sort.Order.asc(field));
		List<Customer> result = this.customerRepository.findAll(sort);
        List<CustomerListResponse> response = result.stream().map(customer -> this.modelMapperService.forResponse()
                .map(customer, CustomerListResponse.class)).collect(Collectors.toList());

        return new SuccessDataResult<List<CustomerListResponse>>(response);
	}
}
