package com.etiya.northwind.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="cart_details")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="product_quantity")
	private int productQuantity;
	
	@Column(name="product_unit_price")
	private double productUnitPrice;
	
	@Column(name="product_id")
	private int productId;
	
	@ManyToOne()
	@JoinColumn(name="product_id", insertable = false, updatable = false)
	private Product product;
	
	@ManyToOne()
	@JoinColumn(name="cart_id")
	private Cart cart;
	
	
}
