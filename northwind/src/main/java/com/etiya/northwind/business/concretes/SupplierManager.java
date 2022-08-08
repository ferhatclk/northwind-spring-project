package com.etiya.northwind.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.etiya.northwind.business.abstracts.SupplierService;
import com.etiya.northwind.business.responses.suppliers.SupplierListResponse;
import com.etiya.northwind.dataAccess.abstracts.SupplierRepository;
import com.etiya.northwind.entities.concretes.Supplier;

@Service
public class SupplierManager implements SupplierService{
	private SupplierRepository supplierRepository;
	
	public SupplierManager(SupplierRepository supplierRepository) {
		this.supplierRepository = supplierRepository;
	}

	@Override
	public List<SupplierListResponse> getAll() {
		List<Supplier> result = this.supplierRepository.findAll();
		List<SupplierListResponse> response = new ArrayList<SupplierListResponse>();
		
		for (Supplier supplier: result) {
			SupplierListResponse supplierResponse = new SupplierListResponse();
			supplierResponse.setAddress(supplier.getAddress());
			supplierResponse.setCompanyName(supplier.getCompanyName());
			supplierResponse.setContactName(supplier.getContactName());
			supplierResponse.setContactTitle(supplier.getContactTitle());
			supplierResponse.setSupplierId(supplier.getSupplierId());
			response.add(supplierResponse);
		}
		
		return response;
	}

}
