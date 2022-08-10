package com.etiya.northwind.business.abstracts;

import java.util.List;



import com.etiya.northwind.business.requests.products.CreateProductRequest;
import com.etiya.northwind.business.requests.products.DeleteProductRequest;
import com.etiya.northwind.business.requests.products.UpdateProductRequest;
import com.etiya.northwind.business.responses.products.ProductGetResponse;
import com.etiya.northwind.business.responses.products.ProductListResponse;


public interface ProductService {
	void add(CreateProductRequest createProductRequest);
	void delete(DeleteProductRequest deleteProductRequest);
	void update(UpdateProductRequest updateProductRequest);
	ProductGetResponse getById(int id);
	List<ProductListResponse> getAll();
	List<ProductListResponse> getAll(int pageNo,int pageSize);
    List<ProductListResponse> getAllSortedByDesc(String field);
    List<ProductListResponse> getAllSortedByAsc(String field);
}
