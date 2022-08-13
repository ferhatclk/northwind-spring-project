package com.etiya.northwind.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.etiya.northwind.business.abstracts.CartDetailService;
import com.etiya.northwind.business.requests.cartDetails.CreateCartDetailRequest;
import com.etiya.northwind.business.requests.cartDetails.DeleteCartDetailRequest;
import com.etiya.northwind.business.requests.cartDetails.UpdateCartDetailRequest;
import com.etiya.northwind.business.responses.cartDetails.CartDetailGetResponse;
import com.etiya.northwind.business.responses.cartDetails.CartDetailListResponse;
import com.etiya.northwind.core.utilities.results.DataResult;
import com.etiya.northwind.core.utilities.results.Result;

@RestController
@RequestMapping("/api/cartdetails")
public class CartDetailsController {
	private CartDetailService cartDetailService;

	@Autowired
	public CartDetailsController(CartDetailService cartDetailService) {
		this.cartDetailService = cartDetailService;
	}
	
	@PostMapping("/add")
	public Result add(CreateCartDetailRequest createCartDetailRequest) {
		return this.cartDetailService.add(createCartDetailRequest);
		
	}
	
	@PostMapping("/delete")
	public Result delete(DeleteCartDetailRequest deleteCartDetailRequest) {
		return this.cartDetailService.delete(deleteCartDetailRequest);
	}
	
	@PostMapping("/update")
	public Result update(UpdateCartDetailRequest updateCartDetailRequest) {
		return this.cartDetailService.update(updateCartDetailRequest);
	}
	
	@GetMapping("/getbyid")
	public DataResult<CartDetailGetResponse> getById(@RequestParam int id) {
		return this.cartDetailService.getById(id);
	}
	
	@GetMapping("/getall")
	public DataResult<List<CartDetailListResponse>> getAll(){
		return this.cartDetailService.getAll();
	}
	
	@GetMapping("/getbypageno")
	public DataResult<List<CartDetailListResponse>> getByPageNo(int pageNo, int pageSize){
		return this.cartDetailService.getAllByPageNumber(pageNo, pageSize);
	}
	
	@GetMapping("/getallsortedbydesc")
	public DataResult<List<CartDetailListResponse>> getAllSortedByDesc(@RequestParam String field){
		return this.cartDetailService.getAllSortedByDesc(field);
	}
	
	@GetMapping("/getallsortedbyasc")
	public DataResult<List<CartDetailListResponse>> getAllSortedByAsc(@RequestParam String field){
		return this.cartDetailService.getAllSortedByAsc(field);
	}
}
