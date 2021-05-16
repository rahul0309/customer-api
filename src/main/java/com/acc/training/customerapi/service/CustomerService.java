package com.acc.training.customerapi.service;

import java.util.List;

import com.acc.training.customerapi.model.Customer;
import com.acc.training.customerapi.repository.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository repository;

    public List<Customer> customers() {
        return repository.findAll();
    }

    public Customer saveCustomer(Customer customer) {
        return repository.save(customer);
    }
    
}
