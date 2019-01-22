package com.demo.springdata.componentmapping.repository;

import org.springframework.data.repository.CrudRepository;

import com.demo.springdata.componentmapping.entity.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

}
