package com.etiya.northwind.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="carts")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cart {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cart_id")
	private int cartId;
	
	@Column(name="quantity")
	private int quantity;
	
	@Column(name="total_price")
	private double totalPrice;
	
	@Column(name="customer_id")
	private String customerId;
	
	@OneToOne()
	@JoinColumn(name="customer_id", insertable = false, updatable = false)
	private Customer customer;
	
	@OneToMany(mappedBy = "cart")
	private List<CartDetail> cartDetails;

}
