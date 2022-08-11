package com.etiya.northwind.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.etiya.northwind.business.abstracts.EmployeeService;
import com.etiya.northwind.business.requests.employees.CreateEmployeeRequest;
import com.etiya.northwind.business.requests.employees.DeleteEmployeeRequest;
import com.etiya.northwind.business.requests.employees.UpdateEmployeeRequest;
import com.etiya.northwind.business.responses.employees.EmployeeGetResponse;
import com.etiya.northwind.business.responses.employees.EmployeeListResponse;
import com.etiya.northwind.core.exceptions.BusinessException;
import com.etiya.northwind.core.utilities.mapping.ModelMapperService;
import com.etiya.northwind.core.utilities.results.DataResult;
import com.etiya.northwind.core.utilities.results.Result;
import com.etiya.northwind.core.utilities.results.SuccessDataResult;
import com.etiya.northwind.core.utilities.results.SuccessResult;
import com.etiya.northwind.dataAccess.abstracts.EmployeeRepository;

import com.etiya.northwind.entities.concretes.Employee;

@Service
public class EmployeeManager implements EmployeeService{
	private EmployeeRepository employeeRepository;
    private ModelMapperService modelMapperService;
    
    @Autowired
    public EmployeeManager(EmployeeRepository employeeRepository, ModelMapperService modelMapperService) {
        this.employeeRepository = employeeRepository;
        this.modelMapperService = modelMapperService;
    }

    @Override
    public Result add(CreateEmployeeRequest createEmployeeRequest) {
    	checkIfReportsCount(createEmployeeRequest.getReports());
    	
        Employee employee = this.modelMapperService.forRequest().map(createEmployeeRequest, Employee.class);
        this.employeeRepository.save(employee);
		
        return new SuccessResult();
    }

    @Override
    public Result delete(DeleteEmployeeRequest deleteEmployeeRequest) {
        this.employeeRepository.deleteById(deleteEmployeeRequest.getEmployeeId());
        
        return new SuccessResult();
    }

    @Override
    public Result update(UpdateEmployeeRequest updateEmployeeRequest) {
    	checkIfReportsCount(updateEmployeeRequest.getReports());
    	
    	Employee employee = this.modelMapperService.forRequest().map(updateEmployeeRequest, Employee.class);
        this.employeeRepository.save(employee);
        
        return new SuccessResult();
    }

    @Override
    public DataResult<EmployeeGetResponse> getById(int id) {
        Employee employee = this.employeeRepository.findById(id).get();
        EmployeeGetResponse response = this.modelMapperService.forRequest().map(employee, EmployeeGetResponse.class);
        
        return new SuccessDataResult<EmployeeGetResponse>(response) ;
    }

    @Override
    public DataResult<List<EmployeeListResponse>> getAll() {
        List<Employee> result = this.employeeRepository.findAll();
        List<EmployeeListResponse> response = result.stream().map(employee -> this.modelMapperService.forResponse()
                .map(employee, EmployeeListResponse.class)).collect(Collectors.toList());
        
        return new SuccessDataResult<List<EmployeeListResponse>>(response) ;
    }

	@Override
	public DataResult<List<EmployeeListResponse>> getAllByPageNumber(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo, pageSize);
		
		List<Employee> result = this.employeeRepository.findAll(pageable).getContent();
        List<EmployeeListResponse> response = result.stream().map(employee -> this.modelMapperService.forResponse()
                .map(employee, EmployeeListResponse.class)).collect(Collectors.toList());
        
        return new SuccessDataResult<List<EmployeeListResponse>>(response) ;
	}

	@Override
	public DataResult<List<EmployeeListResponse>> getAllSortedByDesc(String field) {
		Sort sort = Sort.by(Sort.Order.desc(field));
		
		List<Employee> result = this.employeeRepository.findAll(sort);
        List<EmployeeListResponse> response = result.stream().map(employee -> this.modelMapperService.forResponse()
                .map(employee, EmployeeListResponse.class)).collect(Collectors.toList());
       
        return new SuccessDataResult<List<EmployeeListResponse>>(response) ;
	}

	@Override
	public DataResult<List<EmployeeListResponse>> getAllSortedByAsc(String field) {
		Sort sort = Sort.by(Sort.Order.asc(field));
		
		List<Employee> result = this.employeeRepository.findAll(sort);
        List<EmployeeListResponse> response = result.stream().map(employee -> this.modelMapperService.forResponse()
                .map(employee, EmployeeListResponse.class)).collect(Collectors.toList());
        
        return new SuccessDataResult<List<EmployeeListResponse>>(response) ;
	}
	
	private void checkIfReportsCount(int reports) {
		List<Employee> employees = employeeRepository.findByReports(reports);
		for (Employee employee : employees) {
			System.out.println(employee.getReports()); 
		}
		if(employees.size() > 9)
			throw new BusinessException("REPORTS.COUNT.EXCEEDED");
	}

}
