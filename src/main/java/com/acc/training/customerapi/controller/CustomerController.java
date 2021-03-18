package com.acc.training.customerapi.controller;

import javax.validation.Valid;

import com.acc.training.customerapi.api.CustomerApi;
import com.acc.training.customerapi.model.Customer;
import com.acc.training.customerapi.model.InlineResponse200;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController implements CustomerApi {

    @Override
    public ResponseEntity<Customer> createCustomer(@Valid Customer body) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ResponseEntity<InlineResponse200> deleteCustomer(String id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ResponseEntity<Customer> getCustomer(String id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ResponseEntity<Customer> updateCustomer(@Valid Customer body) {
        // TODO Auto-generated method stub
        return null;
    }

    
    
}
