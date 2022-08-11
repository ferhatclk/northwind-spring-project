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
@Table(name="employees")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
	@Id
	@Column(name="employee_id")
	private int employeeId;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="title")
	private String title;
	
	@Column(name="birth_date")
	private LocalDate birthDate;
	
	@Column(name="address")
	private String address;
	
	@Column(name = "reportsTo")
	private int reportsTo;
	
	@ManyToOne()
	@JoinColumn(name="employee_id",insertable = false, updatable = false)
	private Employee parentEmployee;

	@OneToMany(mappedBy = "parentEmployee")
	private List<Employee> subEmployees;
	
	
	@ManyToOne
	@JoinColumn(name="country_id")
	private Country country;
	
	@ManyToOne
	@JoinColumn(name="city_id")
	private City city;
	
	@OneToMany(mappedBy = "employee")
	private List<Order> orders;
}
