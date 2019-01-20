package com.demo.springdata.files.repository;

import org.springframework.data.repository.CrudRepository;

import com.demo.springdata.files.entity.Image;

public interface ImageRepository extends CrudRepository<Image, Long> {

}
