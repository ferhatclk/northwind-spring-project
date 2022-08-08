package com.etiya.northwind.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.etiya.northwind.business.abstracts.OrderService;
import com.etiya.northwind.business.responses.orders.OrderListResponse;
import com.etiya.northwind.dataAccess.abstracts.OrderRepository;
import com.etiya.northwind.entities.concretes.Order;


@Service
public class OrderManager implements OrderService{
	private OrderRepository orderRepository;
	
	public OrderManager(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}

	@Override
	public List<OrderListResponse> getAll() {
		List<Order> result = this.orderRepository.findAll();
		List<OrderListResponse> response = new ArrayList<OrderListResponse>();
		
		for (Order order: result) {
			OrderListResponse orderResponse = new OrderListResponse();
			orderResponse.setCustomerCompanyName(order.getCustomer().getCompanyName());
			orderResponse.setCustomerId(order.getCustomer().getCustomerId());
			orderResponse.setEmployeeFirstName(order.getEmployee().getFirstName());
			orderResponse.setEmployeeId(order.getEmployee().getEmployeeId());
			orderResponse.setOrderDate(order.getOrderDate());
			orderResponse.setOrderId(order.getOrderId());
			orderResponse.setRequiredDate(order.getRequiredDate());
			orderResponse.setShippedDate(order.getShippedDate());
			response.add(orderResponse);
		}
		
		return response;
	}

}
