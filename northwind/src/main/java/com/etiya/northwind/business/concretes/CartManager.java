package com.etiya.northwind.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.etiya.northwind.business.abstracts.CartService;

import com.etiya.northwind.business.requests.carts.BuyCartRequest;
import com.etiya.northwind.business.requests.carts.CreateCartRequest;
import com.etiya.northwind.business.requests.carts.DeleteCartRequest;
import com.etiya.northwind.business.requests.carts.UpdateCartRequest;
import com.etiya.northwind.business.responses.carts.CartGetResponse;
import com.etiya.northwind.business.responses.carts.CartListResponse;
import com.etiya.northwind.core.utilities.mapping.ModelMapperService;
import com.etiya.northwind.core.utilities.results.DataResult;
import com.etiya.northwind.core.utilities.results.Result;
import com.etiya.northwind.core.utilities.results.SuccessDataResult;
import com.etiya.northwind.core.utilities.results.SuccessResult;
import com.etiya.northwind.dataAccess.abstracts.CartDetailRepository;
import com.etiya.northwind.dataAccess.abstracts.CartRepository;
import com.etiya.northwind.entities.concretes.Cart;
import com.etiya.northwind.entities.concretes.CartDetail;



@Service
public class CartManager implements CartService{
	private CartRepository cartRepository;
	private ModelMapperService  modelMapperService;
	private CartDetailRepository cartDetailRepository;

	
	@Autowired
	public CartManager(CartRepository cartRepository, ModelMapperService modelMapperService,
			CartDetailRepository cartDetailRepository) {
		this.cartRepository = cartRepository;
		this.modelMapperService = modelMapperService;
		this.cartDetailRepository = cartDetailRepository;

	}

	@Override
	public Result add(CreateCartRequest createCartRequest) {
		Cart cart = new Cart();
		cart.setCustomerId(createCartRequest.getCustomerId());
		
		this.cartRepository.save(cart);
		
		return new SuccessResult("CART.ADDED");
	}

	@Override
	public Result delete(DeleteCartRequest deleteCartRequest) {
		this.cartRepository.deleteById(deleteCartRequest.getCartId());
		
		return new SuccessResult("CART.DELETED");
	}

	@Override
	public Result update(UpdateCartRequest updateCartRequest) {
		Cart cart = this.modelMapperService.forRequest()
				.map(updateCartRequest, Cart.class);
		
		this.cartRepository.save(cart);
		
		return new SuccessResult("CART.UPDATED");
	}
	
	@Override
	public Result buyCart(BuyCartRequest buyCartRequest) {
		
		List<CartDetail> cartDetails = this.cartDetailRepository.findByCartCustomerId(buyCartRequest.getCustomerId());
		
		for (CartDetail cartDetail : cartDetails) {
			this.cartDetailRepository.deleteById(cartDetail.getId());
		}
		
		Cart cart = cartRepository.findByCustomerId(buyCartRequest.getCustomerId());
		cart.setQuantity(0);
		cart.setTotalPrice(0);
		
		this.cartRepository.save(cart);
		
		return new SuccessResult("CART.EMPTİED");
	}
		

	@Override
	public DataResult<CartGetResponse> getById(int id) {
		Cart cart = this.cartRepository.findById(id);
		CartGetResponse response = this.modelMapperService.forResponse()
				.map(cart, CartGetResponse.class);
		
		return new SuccessDataResult<CartGetResponse>(response);
	}

	@Override
	public DataResult<List<CartListResponse>> getAll() {
		List<Cart> result = this.cartRepository.findAll();
		List<CartListResponse> response = result.stream().map(cart -> this.modelMapperService.forResponse()
				.map(cart, CartListResponse.class)).collect(Collectors.toList());
		
		return new SuccessDataResult<List<CartListResponse>>(response);
	}

	@Override
	public DataResult<List<CartListResponse>> getAllByPageNumber(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo-1, pageSize);
		
		List<Cart> result = this.cartRepository.findAll(pageable).getContent();
		List<CartListResponse> response = result.stream().map(cart -> this.modelMapperService.forResponse()
				.map(cart, CartListResponse.class)).collect(Collectors.toList());
		
		return new SuccessDataResult<List<CartListResponse>>(response);
	}

	@Override
	public DataResult<List<CartListResponse>> getAllSortedByDesc(String field) {
		Sort sort = Sort.by(Sort.Order.desc(field));
		
		List<Cart> result = this.cartRepository.findAll(sort);
		List<CartListResponse> response = result.stream().map(cart -> this.modelMapperService.forResponse()
				.map(cart, CartListResponse.class)).collect(Collectors.toList());
		
		return new SuccessDataResult<List<CartListResponse>>(response);
	}

	@Override
	public DataResult<List<CartListResponse>> getAllSortedByAsc(String field) {
		Sort sort = Sort.by(Sort.Order.asc(field));
		
		List<Cart> result = this.cartRepository.findAll(sort);
		List<CartListResponse> response = result.stream().map(cart -> this.modelMapperService.forResponse()
				.map(cart, CartListResponse.class)).collect(Collectors.toList());
		
		return new SuccessDataResult<List<CartListResponse>>(response);
	}

	@Override
	public Cart findById(int cartId) {
		
		return this.cartRepository.findById(cartId);
	}
	
	
	
}
