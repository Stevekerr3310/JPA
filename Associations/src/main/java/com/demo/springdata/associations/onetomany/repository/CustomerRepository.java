package com.demo.springdata.associations.onetomany.repository;

import org.springframework.data.repository.CrudRepository;

import com.demo.springdata.associations.onetomany.entity.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
	
}
