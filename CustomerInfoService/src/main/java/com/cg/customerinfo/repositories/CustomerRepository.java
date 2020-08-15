package com.cg.customerinfo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.customerinfo.models.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
