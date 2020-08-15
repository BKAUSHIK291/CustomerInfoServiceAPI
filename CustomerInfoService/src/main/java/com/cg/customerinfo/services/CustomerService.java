package com.cg.customerinfo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.customerinfo.models.Customer;
import com.cg.customerinfo.repositories.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository custRepository;

	public List<Customer> getAllCustomers() {

		List<Customer> customers = new ArrayList<>();
		
		custRepository.findAll()
				.forEach(customers::add);
		
		return customers;
	}

	public Customer getCustomerById(Long custId) {

		return custRepository.getOne(custId);

	}
	
	public Boolean addCustomer(Customer cust) {
		custRepository.saveAndFlush(cust);
		return true;
	}

	public List<Customer> getCustomersByName(String custName) {
		return null;
	}

	public Boolean deleteCustomerById(Long custId) {
		return true;
	}

}
