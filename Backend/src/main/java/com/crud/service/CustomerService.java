package com.crud.service;

import java.util.List;

import com.crud.entity.Customer;

public interface CustomerService {

	public Customer postCustomer(Customer customer);
	
	public List<Customer> getCustomers();
	
	public void deleteCustomer(Long id);
	
	public Customer getCustomerById(Long id);
	
	public Customer updateCustomer(Long id, Customer customer);
	
	
}
