package com.customer.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.customer.demo.model.Customer;

@org.springframework.stereotype.Repository
public interface Repository extends JpaRepository<Customer,Integer> {
	
	public Customer findByCustomerName(String customerName);
	

}
