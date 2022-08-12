package com.etiya.northwind.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.etiya.northwind.entities.concretes.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer>{
	Cart findById(int id);
}
