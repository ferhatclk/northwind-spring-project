package com.etiya.northwind.entities.concretes;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="order_details")
@Data
@AllArgsConstructor
@NoArgsConstructor
@IdClass(OrderDetail.class)
public class OrderDetail implements Serializable{
//	private static final long serialVersionUID = 1L;
	
	@Column(name="unit_price")
	private double unitPrice;
	
	@Column(name="quantity")
	private int quantity;
	
	@Column(name="discount")
	private double discount;
	
	@Id
	@ManyToOne
	@JoinColumn(name="order_id")
	private Order order;
	
	@Id
	@ManyToOne
	@JoinColumn(name="product_id")
	private Product product;
}
