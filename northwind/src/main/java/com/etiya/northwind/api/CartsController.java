package com.etiya.northwind.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.etiya.northwind.business.abstracts.CartService;
import com.etiya.northwind.business.requests.carts.BuyCartRequest;
import com.etiya.northwind.business.requests.carts.CreateCartRequest;
import com.etiya.northwind.business.requests.carts.DeleteCartRequest;
import com.etiya.northwind.business.requests.carts.UpdateCartRequest;
import com.etiya.northwind.business.responses.carts.CartGetResponse;
import com.etiya.northwind.business.responses.carts.CartListResponse;
import com.etiya.northwind.core.utilities.results.DataResult;
import com.etiya.northwind.core.utilities.results.Result;

@RestController
@RequestMapping("/api/carts")
public class CartsController {
	private CartService cartService;
	
	@Autowired
	public CartsController(CartService cartService) {
		this.cartService = cartService;
	}
	
	@PostMapping("/add")
	public Result add(CreateCartRequest createCartRequest) {
		return this.cartService.add(createCartRequest);
		
	}
	
	@PostMapping("/delete")
	public Result delete(DeleteCartRequest deleteCartRequest) {
		return this.cartService.delete(deleteCartRequest);
		
	}
	
	@PostMapping("/update")
	public Result update(UpdateCartRequest updateCartRequest) {
		return this.cartService.update(updateCartRequest);
		
	}
	
	@PostMapping("/buycart")
	public Result buyCart(BuyCartRequest buyCartRequest) {
		return this.cartService.buyCart(buyCartRequest);
	}
	
	@GetMapping("/getbyid")
	public DataResult<CartGetResponse> getById(@RequestParam int id) {
		return this.cartService.getById(id);
	}
	
	@GetMapping("/getall")
	public DataResult<List<CartListResponse>> getAll(){
		return this.cartService.getAll();
	}
	
	@GetMapping("/getbypageno")
	public DataResult<List<CartListResponse>> getByPageNo(int pageNo, int pageSize){
		return this.cartService.getAllByPageNumber(pageNo, pageSize);
	}
	
	@GetMapping("/getallsortedbydesc")
	public DataResult<List<CartListResponse>> getAllSortedByDesc(@RequestParam String field){
		return this.cartService.getAllSortedByDesc(field);
	}
	
	@GetMapping("/getallsortedbyasc")
	public DataResult<List<CartListResponse>> getAllSortedByAsc(@RequestParam String field){
		return this.cartService.getAllSortedByAsc(field);
	}
	
}
