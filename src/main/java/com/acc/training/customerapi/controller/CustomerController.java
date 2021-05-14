package com.acc.training.customerapi.controller;

import java.util.List;

import com.acc.training.customerapi.model.Customer;
import com.acc.training.customerapi.repository.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerRepository repository;

    @Operation(summary = "Get a customer by its customer Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the customer", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Customer.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied", content = @Content),
            @ApiResponse(responseCode = "404", description = "Customer not found", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content) })
    @RequestMapping(path = "/getAllCustomers", method = RequestMethod.GET)
    public ResponseEntity<List<Customer>> getCustomers() {

        List<Customer> response = repository.findAll();

        System.out.println("Response: " + response.size());

        return ResponseEntity.status(HttpStatus.OK).body(response);

    }

    @Operation(summary = "Create customer")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "customer created successfully", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Customer.class)) }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content) })
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Customer> createCustomer(
            @Parameter(description = "Create Customer") @RequestBody Customer customer) {

        Customer response = repository.save(customer);

        System.out.println("Response: "+response.getCustomerName());

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
