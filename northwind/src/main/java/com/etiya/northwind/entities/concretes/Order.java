package com.etiya.northwind.entities.concretes;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="orders")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
	@Id
	@Column(name="order_id")
	private int orderId;
	
	@Column(name="order_date")
	private LocalDate orderDate;
	
	@Column(name="required_date")
	private LocalDate requiredDate;
	
	@Column(name="shipped_date")
	private LocalDate shippedDate;
	
	@ManyToOne
	@JoinColumn(name="customer_id")
	private Customer customer;
	
	@ManyToOne
	@JoinColumn(name="employee_id")
	private Employee employee;
	
	
	@OneToMany(mappedBy = "order")
	private List<OrderDetail> orderDetails;
}
