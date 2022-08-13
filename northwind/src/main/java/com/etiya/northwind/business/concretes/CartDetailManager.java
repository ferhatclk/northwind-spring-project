package com.etiya.northwind.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.etiya.northwind.business.abstracts.CartDetailService;
import com.etiya.northwind.business.abstracts.CartService;
import com.etiya.northwind.business.abstracts.ProductService;
import com.etiya.northwind.business.requests.cartDetails.CreateCartDetailRequest;
import com.etiya.northwind.business.requests.cartDetails.DeleteCartDetailRequest;
import com.etiya.northwind.business.requests.cartDetails.UpdateCartDetailRequest;
import com.etiya.northwind.business.responses.cartDetails.CartDetailGetResponse;
import com.etiya.northwind.business.responses.cartDetails.CartDetailListResponse;
import com.etiya.northwind.core.utilities.mapping.ModelMapperService;
import com.etiya.northwind.core.utilities.results.DataResult;
import com.etiya.northwind.core.utilities.results.Result;
import com.etiya.northwind.core.utilities.results.SuccessDataResult;
import com.etiya.northwind.core.utilities.results.SuccessResult;
import com.etiya.northwind.dataAccess.abstracts.CartDetailRepository;
import com.etiya.northwind.entities.concretes.Cart;
import com.etiya.northwind.entities.concretes.CartDetail;
import com.etiya.northwind.entities.concretes.Product;

@Service
public class CartDetailManager implements CartDetailService{
	private CartDetailRepository cartDetailRepository;
	private ModelMapperService modelMapperService;
	private ProductService productService;
	private CartService cartService;
	
	@Autowired
	public CartDetailManager(CartDetailRepository cartDetailRepository, ModelMapperService modelMapperService,
			ProductService productService, CartService cartService) {
		this.cartDetailRepository = cartDetailRepository;
		this.modelMapperService = modelMapperService;
		this.productService = productService;
		this.cartService = cartService;
	}


	@Override
	public Result add(CreateCartDetailRequest createCartProductRequest) {
		CartDetail cartDetail = this.modelMapperService.forRequest()
				.map(createCartProductRequest, CartDetail.class);
		
		Product product = this.productService.getByProduct(cartDetail.getProduct().getProductId()) ;
		
		setQuantityUnitPrice(cartDetail);
		
		cartDetail.setProductQuantity(createCartProductRequest.getQuantity());
		cartDetail.setProductUnitPrice(product.getUnitPrice());
		this.cartDetailRepository.save(cartDetail);
		
		return new SuccessResult("CART.PRODUCT.ADDED");
	}

	@Override
	public Result delete(DeleteCartDetailRequest deleteCartProductRequest) {
		
		CartDetail cartDetail = this.cartDetailRepository.findById(deleteCartProductRequest.getId());
		
		Cart cart =	cartDetail.getCart();
		
		cart.setQuantity(cart.getQuantity() - cartDetail.getProductQuantity());
		cart.setTotalPrice(cart.getTotalPrice() - (cartDetail.getProductUnitPrice()*cartDetail.getProductQuantity()));
		
		cartDetail.setCart(null);
		
		this.cartDetailRepository.deleteById(deleteCartProductRequest.getId());
		
		return new SuccessResult("CART.PRODUCT.DELETED");
	}

	@Override
	public Result update(UpdateCartDetailRequest updateCartProductRequest) {
		CartDetail cartDetail = this.cartDetailRepository.findById(updateCartProductRequest.getId());
		
		Product product = this.productService.getByProduct(updateCartProductRequest.getProductId()) ;
		
		Cart cart = this.cartService.findById(cartDetail.getCart().getCartId()) ;

		updateCartQuantityUnitPrice(cartDetail);
		
		cartDetail.setCart(cart);
		cartDetail.setId(updateCartProductRequest.getId());
		cartDetail.setProductId(product.getProductId());
		cartDetail.setProductUnitPrice(product.getUnitPrice());
		cartDetail.setProductQuantity(updateCartProductRequest.getQuantity());
		
		updateQuantityUnitPrice(cartDetail);
		
		this.cartDetailRepository.save(cartDetail);
		
		return new SuccessResult("CART.PRODUCT.UPDATED");
	}

	@Override
	public DataResult<CartDetailGetResponse> getById(int id) {
		CartDetail cartDetail = this.cartDetailRepository.findById(id);
		CartDetailGetResponse response = this.modelMapperService.forResponse()
				.map(cartDetail, CartDetailGetResponse.class);
		
		return new SuccessDataResult<CartDetailGetResponse>(response);
	}


	@Override
	public DataResult<List<CartDetailListResponse>> getAll() {
		List<CartDetail> result = this.cartDetailRepository.findAll();
		List<CartDetailListResponse> response = result.stream().map(cartDetail -> this.modelMapperService.forResponse()
				.map(cartDetail, CartDetailListResponse.class)).collect(Collectors.toList());
		
		return new SuccessDataResult<List<CartDetailListResponse>>(response);
	}


	@Override
	public DataResult<List<CartDetailListResponse>> getAllByPageNumber(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo-1, pageSize);
		
		List<CartDetail> result = this.cartDetailRepository.findAll(pageable).getContent();
		List<CartDetailListResponse> response = result.stream().map(cartDetail -> this.modelMapperService.forResponse()
				.map(cartDetail, CartDetailListResponse.class)).collect(Collectors.toList());
		
		return new SuccessDataResult<List<CartDetailListResponse>>(response);
	}


	@Override
	public DataResult<List<CartDetailListResponse>> getAllSortedByDesc(String field) {
		Sort sort = Sort.by(Sort.Order.desc(field));
		
		List<CartDetail> result = this.cartDetailRepository.findAll(sort);
		List<CartDetailListResponse> response = result.stream().map(cartDetail -> this.modelMapperService.forResponse()
				.map(cartDetail, CartDetailListResponse.class)).collect(Collectors.toList());
		
		return new SuccessDataResult<List<CartDetailListResponse>>(response);
	}


	@Override
	public DataResult<List<CartDetailListResponse>> getAllSortedByAsc(String field) {
		Sort sort = Sort.by(Sort.Order.asc(field));
		
		List<CartDetail> result = this.cartDetailRepository.findAll(sort);
		List<CartDetailListResponse> response = result.stream().map(cartDetail -> this.modelMapperService.forResponse()
				.map(cartDetail, CartDetailListResponse.class)).collect(Collectors.toList());
		
		return new SuccessDataResult<List<CartDetailListResponse>>(response);
	}
	
	private void setQuantityUnitPrice(CartDetail cartDetail) {
		Product product = this.productService.getByProduct(cartDetail.getProduct().getProductId()) ;
		Cart cart = this.cartService.findById(cartDetail.getCart().getCartId()) ;
		
		cart.setQuantity(cart.getQuantity() + cartDetail.getCart().getQuantity());
		cart.setTotalPrice(cart.getTotalPrice() + (product.getUnitPrice()*cartDetail.getCart().getQuantity()));	
	
	}
	
	private void updateCartQuantityUnitPrice(CartDetail cartDetail) {
		Product product = this.productService.getByProduct(cartDetail.getProduct().getProductId()) ;
		Cart cart = this.cartService.findById(cartDetail.getCart().getCartId());
		
		cart.setQuantity(cart.getQuantity() - cartDetail.getProductQuantity());
		cart.setTotalPrice(cart.getTotalPrice() - (product.getUnitPrice()*cartDetail.getProductQuantity()));
		
	}
	
	private void updateQuantityUnitPrice(CartDetail cartDetail) {
		Product product = this.productService.getByProduct(cartDetail.getProduct().getProductId()) ;
		Cart cart = this.cartService.findById(cartDetail.getCart().getCartId()) ;
		
		cart.setQuantity(cart.getQuantity() + cartDetail.getProductQuantity());
		cart.setTotalPrice(cart.getTotalPrice() + (product.getUnitPrice()*cartDetail.getProductQuantity()));	
		
	}


}
