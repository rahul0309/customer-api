package com.acc.training.customerapi.repository;

import com.acc.training.customerapi.model.Customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>  {
    
}
