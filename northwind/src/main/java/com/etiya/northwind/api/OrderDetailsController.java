package com.etiya.northwind.api;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.etiya.northwind.business.abstracts.OrderDetailService;
import com.etiya.northwind.business.requests.orderDetails.CreateOrderDetailRequest;
import com.etiya.northwind.business.requests.orderDetails.DeleteOrderDetailRequest;
import com.etiya.northwind.business.requests.orderDetails.UpdateOrderDetailRequest;
import com.etiya.northwind.business.responses.orderDetails.OrderDetailGetResponse;
import com.etiya.northwind.business.responses.orderDetails.OrderDetailListResponse;

@RestController
@RequestMapping("/api/orderdetails")
public class OrderDetailsController {
	private OrderDetailService orderDetailService;

	public OrderDetailsController(OrderDetailService orderDetailService) {
		this.orderDetailService = orderDetailService;
	}
	
	@PostMapping("/add")
	public void add(@RequestBody CreateOrderDetailRequest createOrderDetailRequest) {
		this.orderDetailService.add(createOrderDetailRequest);
	}
	
	@PostMapping("/delete")
	public void delete(@RequestBody DeleteOrderDetailRequest deleteOrderDetailRequest) {
		this.orderDetailService.delete(deleteOrderDetailRequest);
	}
	
	@PostMapping("/update")
	public void update(@RequestBody UpdateOrderDetailRequest updateOrderDetailRequest) {
		this.orderDetailService.update(updateOrderDetailRequest);
	}
	
	@GetMapping("/getbyid")
	public OrderDetailGetResponse getById(int orderId, int productId) {
		return this.orderDetailService.getById(orderId, productId);
	}
	
	@GetMapping("/getall")
	public List<OrderDetailListResponse> getAll(){
		return this.orderDetailService.getAll();
	}
	
	@GetMapping("/getbypageno")
	public List<OrderDetailListResponse> getByPageNo(int pageNo, int pageSize){
		return this.orderDetailService.getByPageNumber(pageNo, pageSize);
	}
	
	@GetMapping("/getallsortedbydesc")
	public List<OrderDetailListResponse> getAllSortedByDesc(@RequestParam String field){
		return this.orderDetailService.getAllSortedByDesc(field);
	}
	
	@GetMapping("/getallsortedbyasc")
	public List<OrderDetailListResponse> getAllSortedByAsc(@RequestParam String field){
		return this.orderDetailService.getAllSortedByAsc(field);
	}
}
