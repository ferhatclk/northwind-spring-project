package com.etiya.northwind.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.etiya.northwind.business.abstracts.OrderDetailService;

import com.etiya.northwind.business.responses.orderDetails.OrderDetailListResponse;
import com.etiya.northwind.dataAccess.abstracts.OrderDetailRepository;
import com.etiya.northwind.entities.concretes.OrderDetail;

@Service
public class OrderDetailManager implements OrderDetailService{
	private OrderDetailRepository orderDetailRepository;
	
	public OrderDetailManager(OrderDetailRepository orderDetailRepository) {
		this.orderDetailRepository = orderDetailRepository;
	}

	@Override
	public List<OrderDetailListResponse> getAll() {
		List<OrderDetail> result = this.orderDetailRepository.findAll();
		List<OrderDetailListResponse> response = new ArrayList<OrderDetailListResponse>();
		
		for (OrderDetail orderDetail: result) {
			OrderDetailListResponse orderDetailResponse = new OrderDetailListResponse();
			orderDetailResponse.setDiscount(orderDetail.getDiscount());
			orderDetailResponse.setOrderId(orderDetail.getOrder().getOrderId());
			orderDetailResponse.setProductId(orderDetail.getProduct().getProductId());
			orderDetailResponse.setProductName(orderDetail.getProduct().getProductName());
			orderDetailResponse.setQuantity(orderDetail.getQuantity());
			orderDetailResponse.setUnitPrice(orderDetail.getUnitPrice());
			response.add(orderDetailResponse);
		}
		
		return response;
	}

}
