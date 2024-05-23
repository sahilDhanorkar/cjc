package com.customer.demo.service;

import java.util.List;

import com.customer.demo.model.Customer;




public interface Service {

	Customer saveCustomer(Customer customer);

	List<Customer> viewCustomer();

	Customer getCustomerByName(String customerName);

	void deleteCustomer(Integer customerId);

}
