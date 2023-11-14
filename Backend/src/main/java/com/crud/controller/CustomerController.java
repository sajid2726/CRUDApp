package com.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.entity.Customer;
import com.crud.service.CustomerService;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class CustomerController {

	
	@Autowired
	private CustomerService customerService;
	
	
	@PostMapping("/post/customer")
	public Customer postCustomer(@RequestBody Customer customer) {
		return this.customerService.postCustomer(customer);
	}
	
	@GetMapping("/getall")
	public List<Customer> getAllCustomer() {
		return this.customerService.getCustomers();
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteCustomer(@PathVariable Long id) {
		this.customerService.deleteCustomer(id);
	}
	
	@GetMapping("/getbyid/{id}")
	public ResponseEntity<Customer>	 getCustomerById(@PathVariable Long id) {
	Customer customer = customerService.getCustomerById(id);
	if(customer == null) return ResponseEntity.notFound().build();
	return ResponseEntity.ok(customer);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Customer>    updateCustomer(@PathVariable Long id, @RequestBody Customer customer) {
		Customer updatedCustomer = customerService.updateCustomer(id, customer);
		if(updatedCustomer == null) return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		return ResponseEntity.ok(updatedCustomer);
		
	}
}
