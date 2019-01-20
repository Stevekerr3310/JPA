package com.demo.springdata.associations.onetoone.repository;

import org.springframework.data.repository.CrudRepository;

import com.demo.springdata.associations.onetoone.entity.License;

public interface LicenseRepository extends CrudRepository<License, Long> {

}
