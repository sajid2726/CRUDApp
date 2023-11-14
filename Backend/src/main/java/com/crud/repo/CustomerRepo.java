package com.crud.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.entity.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Long>{

}
