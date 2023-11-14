package com.crud.service.impl;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.entity.Customer;
import com.crud.repo.CustomerRepo;
import com.crud.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerRepo customerRepo;
	
	
	@Override
	public Customer postCustomer(Customer customer) {
		return this.customerRepo.save(customer);
	}


	@Override
	public List<Customer> getCustomers() {
		
		return this.customerRepo.findAll();
	}


	@Override
	public void deleteCustomer(Long id) {
		this.customerRepo.deleteById(id);
	}


	@Override
	public Customer getCustomerById(Long id) {
		return customerRepo.findById(id).orElse(null);
	}


	@Override
	public Customer updateCustomer(Long id, Customer customer) {
		Optional<Customer> customerOptional = this.customerRepo.findById(id);
		if(customerOptional.isPresent()) {
			Customer existingCustomer = customerOptional.get();
			existingCustomer.setName(customer.getName());
			existingCustomer.setEmail(customer.getEmail());
			existingCustomer.setPhone(customer.getPhone());
		return this.customerRepo.save(existingCustomer);
		}
		else {
			return null;
		}
		
		
	}

}
