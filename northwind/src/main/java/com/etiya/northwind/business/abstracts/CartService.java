package com.etiya.northwind.business.abstracts;


import java.util.List;

import com.etiya.northwind.business.requests.carts.BuyCartRequest;
import com.etiya.northwind.business.requests.carts.CreateCartRequest;
import com.etiya.northwind.business.requests.carts.DeleteCartRequest;
import com.etiya.northwind.business.requests.carts.UpdateCartRequest;
import com.etiya.northwind.business.responses.carts.CartGetResponse;
import com.etiya.northwind.business.responses.carts.CartListResponse;
import com.etiya.northwind.core.utilities.results.DataResult;
import com.etiya.northwind.core.utilities.results.Result;
import com.etiya.northwind.entities.concretes.Cart;

public interface CartService {
	Result add(CreateCartRequest createCartRequest);
	
	Result delete(DeleteCartRequest deleteCartRequest);
	
	Result update(UpdateCartRequest updateCartRequest);
	
	Result buyCart(BuyCartRequest buyCartRequest);
	
	DataResult<CartGetResponse>  getById(int id);
	
	DataResult<List<CartListResponse>>  getAll();
	
	DataResult<List<CartListResponse>> getAllByPageNumber(int pageNo, int pageSize);
	
	DataResult<List<CartListResponse>> getAllSortedByDesc(String field);
	
	DataResult<List<CartListResponse>> getAllSortedByAsc(String field);
	
	Cart findById(int cartId);
}
