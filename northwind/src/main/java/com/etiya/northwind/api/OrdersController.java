package com.etiya.northwind.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.etiya.northwind.business.abstracts.OrderService;
import com.etiya.northwind.business.requests.orders.CreateOrderRequest;
import com.etiya.northwind.business.requests.orders.DeleteOrderRequest;
import com.etiya.northwind.business.requests.orders.UpdateOrderRequest;
import com.etiya.northwind.business.responses.orders.OrderGetResponse;
import com.etiya.northwind.business.responses.orders.OrderListResponse;
import com.etiya.northwind.core.utilities.results.DataResult;
import com.etiya.northwind.core.utilities.results.Result;

@RestController
@RequestMapping("/api/orders")
public class OrdersController {
	private OrderService orderService;
	
	@Autowired
	public OrdersController(OrderService orderService) {
		this.orderService = orderService;
	}
	
	@PostMapping("/add")
    public Result add(@RequestBody CreateOrderRequest createOrderRequest){
        return this.orderService.add(createOrderRequest);
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody DeleteOrderRequest deleteOrderRequest){
        return this.orderService.delete(deleteOrderRequest);
    }

    @PostMapping("/update")
    public Result update(@RequestBody UpdateOrderRequest updateOrderRequest){
        return this.orderService.update(updateOrderRequest);
    }


    @GetMapping("/getbyid")
    public DataResult<OrderGetResponse> getById(@RequestParam int id){
        return this.orderService.getById(id);
    }
	
	@GetMapping("/getall")
	public DataResult<List<OrderListResponse>> getAll(){
		return this.orderService.getAll();
	}
	
	@GetMapping("/getbypageno")
	public DataResult<List<OrderListResponse>> getByPageNumber(int pageNo, int pageSize){
		return this.orderService.getAllByPageNumber(pageNo, pageSize);
	}
	
	@GetMapping("/getallsortedbydesc")
	public DataResult<List<OrderListResponse>> getAllSortedByDesc(@RequestParam String field){
		return this.orderService.getAllSortedByDesc(field);
	}
	
	@GetMapping("/getallsortedbyasc")
	public DataResult<List<OrderListResponse>> getAllSortedByAsc(@RequestParam String field){
		return this.orderService.getAllSortedByAsc(field);
	}
}
