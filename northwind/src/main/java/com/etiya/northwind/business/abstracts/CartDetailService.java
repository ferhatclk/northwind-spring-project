package com.etiya.northwind.business.abstracts;

import java.util.List;

import com.etiya.northwind.business.requests.cartDetails.CreateCartDetailRequest;
import com.etiya.northwind.business.requests.cartDetails.DeleteCartDetailRequest;
import com.etiya.northwind.business.requests.cartDetails.UpdateCartDetailRequest;
import com.etiya.northwind.business.responses.cartDetails.CartDetailGetResponse;
import com.etiya.northwind.business.responses.cartDetails.CartDetailListResponse;
import com.etiya.northwind.core.utilities.results.DataResult;
import com.etiya.northwind.core.utilities.results.Result;

public interface CartDetailService {
	Result add(CreateCartDetailRequest createCartProductRequest);
	
	Result delete(DeleteCartDetailRequest deleteCartProductRequest);
	
	Result update(UpdateCartDetailRequest updateCartProductRequest);
	
	DataResult<CartDetailGetResponse>  getById(int id);
	
	DataResult<List<CartDetailListResponse>>  getAll();
	
	DataResult<List<CartDetailListResponse>> getAllByPageNumber(int pageNo, int pageSize);
	
	DataResult<List<CartDetailListResponse>> getAllSortedByDesc(String field);
	
	DataResult<List<CartDetailListResponse>> getAllSortedByAsc(String field);
	
}
