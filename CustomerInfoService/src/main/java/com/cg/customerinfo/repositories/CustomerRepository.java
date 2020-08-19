package com.cg.customerinfo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.customerinfo.models.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

	//public Customer findCustomerByName(String Name);
	
}
