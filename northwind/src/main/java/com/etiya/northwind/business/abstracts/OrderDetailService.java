package com.etiya.northwind.business.abstracts;

import java.util.List;

import com.etiya.northwind.business.requests.orderDetails.CreateOrderDetailRequest;
import com.etiya.northwind.business.requests.orderDetails.DeleteOrderDetailRequest;
import com.etiya.northwind.business.requests.orderDetails.UpdateOrderDetailRequest;
import com.etiya.northwind.business.responses.orderDetails.OrderDetailGetResponse;
import com.etiya.northwind.business.responses.orderDetails.OrderDetailListResponse;

public interface OrderDetailService {
	void add(CreateOrderDetailRequest createOrderDetailRequest);
	void delete(DeleteOrderDetailRequest deleteOrderDetailRequest);
	void update(UpdateOrderDetailRequest updateOrderDetailRequest);
	List<OrderDetailListResponse> getAll();
	List<OrderDetailListResponse> getByPageNumber(int pageNo, int pageSize);
	List<OrderDetailListResponse> getAllSortedByDesc(String field);
	List<OrderDetailListResponse> getAllSortedByAsc(String field);
	OrderDetailGetResponse getById(int orderId, int productId);
}
