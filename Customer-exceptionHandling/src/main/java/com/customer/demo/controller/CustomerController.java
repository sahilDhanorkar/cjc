package com.customer.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.customer.demo.model.Customer;
import com.customer.demo.service.Service;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;


@Slf4j //logger info ...
@RequestMapping("/customer")
@RestController
public class CustomerController {
	
	@Autowired
	Service service;
	
	
	@PostMapping("/new")
	@ResponseStatus(code=HttpStatus.CREATED)
	public Customer saveCustomer( @Valid  @RequestBody Customer customer) {
		Customer c =service.saveCustomer(customer);
		log.info("Customer saved");
		System.out.println("hhhhhhh");
		return c;
	}
	
	@GetMapping("/customers")
	@ResponseStatus(code=HttpStatus.FOUND)
	public List<Customer> viewCustomer(){
		List<Customer> ls = service.viewCustomer();
		log.info("Customer viewed");
		return ls;
	}
	
	@GetMapping("/{customerName}")
	@ResponseStatus(code=HttpStatus.FOUND)
	public Customer getCustomerByName(@PathVariable String customerName) {
		Customer cs= service.getCustomerByName(customerName);
		log.info(" Got the Customer by Name");
		return cs;
	}
	
	@DeleteMapping("/{customerId}")
	@ResponseStatus(code=HttpStatus.OK)
	public void deleteCustomer(@PathVariable Integer customerId) {
		 service.deleteCustomer(customerId);
		 log.info("Customer Deleted");
	}
	

}
