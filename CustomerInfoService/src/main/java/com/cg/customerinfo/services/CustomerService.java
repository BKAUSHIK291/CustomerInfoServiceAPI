package com.cg.customerinfo.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.cg.customerinfo.exceptions.RecordNotFoundException;
import com.cg.customerinfo.models.Customer;
import com.cg.customerinfo.repositories.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository custRepository;

	public List<Customer> getAllCustomers() {

		List<Customer> customers = new ArrayList<>();

		custRepository.findAll().forEach(customers::add);

		return customers;
	}

	public Customer getCustomerById(Long custId) {

		return custRepository.findById(custId)
				.orElseThrow(() -> new RecordNotFoundException("User not found with id: " + custId));

	}

	public Boolean addCustomer(Customer cust) {
		custRepository.saveAndFlush(cust);
		return true;
	}

	public List<Customer> getCustomersByName(String custName) {
		return null;
	}

	public ResponseEntity<Customer> deleteCustomerById(Long custId) {
		Customer existingCust = custRepository.findById(custId)
				.orElseThrow(() -> new RecordNotFoundException("User not found with id: " + custId));
		
		this.custRepository.delete(existingCust);
		
		return ResponseEntity.ok().build();
	}

}
