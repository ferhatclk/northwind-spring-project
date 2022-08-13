package com.etiya.northwind.dataAccess.abstracts;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.etiya.northwind.entities.concretes.CartDetail;

public interface CartDetailRepository extends JpaRepository<CartDetail, Integer>{
	CartDetail findById(int id);
	
	List<CartDetail> findByCartCustomerId(String customerId);
}
