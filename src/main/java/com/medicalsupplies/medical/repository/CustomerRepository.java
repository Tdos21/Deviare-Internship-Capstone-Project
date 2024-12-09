package com.medicalsupplies.medical.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.medicalsupplies.medical.models.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

	
}
