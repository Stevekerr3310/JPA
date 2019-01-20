package com.demo.springdata.associations.manytomany.repository;

import org.springframework.data.repository.CrudRepository;

import com.demo.springdata.associations.manytomany.entity.Programmer;

public interface ProgrammerRepository extends CrudRepository<Programmer, Integer> {

}
