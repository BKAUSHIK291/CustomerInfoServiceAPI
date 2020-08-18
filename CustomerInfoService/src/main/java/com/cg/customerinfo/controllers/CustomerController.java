package com.cg.customerinfo.controllers;

import java.util.List;

import javax.validation.Valid;

//import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.customerinfo.models.Customer;

import com.cg.customerinfo.services.CustomerService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

	@Autowired
	private CustomerService custService;

	@ApiOperation(value = "Fetch all customer details")
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public List<Customer> getAllCustomers() {
		return custService.getAllCustomers();
	}

	@ApiOperation(value = "Fetch customer details by ID")
	@RequestMapping(value = "/{custId}", method = RequestMethod.GET)
	public Customer getCustomerById(@PathVariable(value = "custId") Long custId) {

		System.out.println("Inside getCustomerById method in Controller");

		return custService.getCustomerById(custId);
	}

	@ApiOperation(value = "Add a new customer")
	@RequestMapping(method = RequestMethod.POST, value = "/add")
	public Boolean addCustomer(@Valid @RequestBody Customer cust) {
		return custService.addCustomer(cust);
	}

	@ApiOperation(value = "Delete a customer by ID")
	@RequestMapping(method = RequestMethod.DELETE, value = "/{custId}")
	public ResponseEntity<Customer> deleteCustomerById(@PathVariable(value = "custId") Long custId) {
		return custService.deleteCustomerById(custId);
	}

}
