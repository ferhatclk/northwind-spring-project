package com.etiya.northwind.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.etiya.northwind.business.abstracts.OrderDetailService;
import com.etiya.northwind.business.abstracts.OrderService;
import com.etiya.northwind.business.abstracts.ProductService;
import com.etiya.northwind.business.requests.orderDetails.CreateOrderDetailRequest;
import com.etiya.northwind.business.requests.orderDetails.DeleteOrderDetailRequest;
import com.etiya.northwind.business.requests.orderDetails.UpdateOrderDetailRequest;
import com.etiya.northwind.business.responses.orderDetails.OrderDetailGetResponse;
import com.etiya.northwind.business.responses.orderDetails.OrderDetailListResponse;
import com.etiya.northwind.core.utilities.mapping.ModelMapperService;
import com.etiya.northwind.dataAccess.abstracts.OrderDetailRepository;
import com.etiya.northwind.entities.concretes.OrderDetail;

@Service
public class OrderDetailManager implements OrderDetailService{
	private OrderDetailRepository orderDetailRepository;
	private ModelMapperService modelMapperService;
	private ProductService productService;
	private OrderService orderService;
	
	public OrderDetailManager(OrderDetailRepository orderDetailRepository, ModelMapperService modelMapperService
			,ProductService productService,OrderService orderService) {
		this.orderDetailRepository = orderDetailRepository;
		this.modelMapperService = modelMapperService;
		this.orderService = orderService;
		this.productService = productService;
	}

	@Override
	public List<OrderDetailListResponse> getAll() {
		List<OrderDetail> result = this.orderDetailRepository.findAll();
		List<OrderDetailListResponse> response = result.stream().map(orderDetail -> this.modelMapperService.forResponse()
				.map(orderDetail, OrderDetailListResponse.class)).collect(Collectors.toList());
		
		return response;
	}

	@Override
	public void add(CreateOrderDetailRequest createOrderDetailRequest) {
//		OrderDetail orderDetail = new OrderDetail();
//		orderDetail.setOrder(orderService.getById(createOrderDetailRequest.getOrderId()));
//		
		OrderDetail orderDetail = this.modelMapperService.forRequest()
				.map(createOrderDetailRequest, OrderDetail.class);
		
		this.orderDetailRepository.save(orderDetail);
	}

	@Override
	public void delete(DeleteOrderDetailRequest deleteOrderDetailRequest) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(UpdateOrderDetailRequest updateOrderDetailRequest) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public OrderDetailGetResponse getById(int orderId, int productId) {
		OrderDetail orderDetail = this.orderDetailRepository.getByOrder_OrderIdAndProduct_ProductId(orderId, productId);
		OrderDetailGetResponse response = this.modelMapperService.forResponse()
				.map(orderDetail, OrderDetailGetResponse.class);
		return response;
	}

}
