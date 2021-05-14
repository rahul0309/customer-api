package com.acc.training.customerapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import io.swagger.v3.oas.annotations.media.Schema;

@Entity
@Table(name = "customer", schema = "acn")
public class Customer {
    
    @Id
    @Schema(description = "Id of the customer", 
            example = "12345", required = true)
	@NotBlank
	@Size(min = 5, max = 8)
    private Integer customerId;

    @Schema(description = "Name of the customer.", 
            example = "Jessica Abigail", required = true)
	@NotBlank
    @Column(name = "customerName", nullable = false)
	private String customerName;
	
	@Schema(description = "Address line 1 of the customer.", 
            example = "888 Constantine Ave, #54", required = false)
    @Column(name = "customerAddress", nullable = false)    
	private String customerAddress;

    public Customer() {
    }

    public Customer(Integer customerId, String customerName, String customerAddress) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
    }

    public long getCustomerId() {
        return this.customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return this.customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return this.customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public Customer customerId(Integer customerId) {
        setCustomerId(customerId);
        return this;
    }

    public Customer customerName(String customerName) {
        setCustomerName(customerName);
        return this;
    }

    public Customer customerAddress(String customerAddress) {
        setCustomerAddress(customerAddress);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " customerId='" + getCustomerId() + "'" +
            ", customerName='" + getCustomerName() + "'" +
            ", customerAddress='" + getCustomerAddress() + "'" +
            "}";
    }
    
}
