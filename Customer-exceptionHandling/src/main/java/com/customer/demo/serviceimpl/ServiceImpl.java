package com.customer.demo.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.customer.demo.exception.CustomerNotFoundException;
import com.customer.demo.model.Customer;
import com.customer.demo.repository.Repository;
import com.customer.demo.service.Service;

@org.springframework.stereotype.Service
public class ServiceImpl implements Service {
	
	@Autowired
	Repository repo;

	@Override
	public Customer saveCustomer(Customer customer) {
		Customer cs=repo.save(customer);
		return cs;
	}

	@Override
	public List<Customer> viewCustomer() {
		List<Customer> ls=repo.findAll();
		return ls;
	}

	@Override
	public Customer getCustomerByName(String customerName) {
		Customer cs= repo.findByCustomerName(customerName);
		if(cs!=null) {
			return cs;
			
		}else {
			throw new CustomerNotFoundException("Customer not found");
			
		}
		 
	}

	@Override
	public void deleteCustomer(Integer customerId) {
		repo.deleteById(customerId);
		
	}
	
	

}
