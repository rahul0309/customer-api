package com.acc.training.customerapi.repository;

import com.acc.training.customerapi.model.Customer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer>  {
    
}
