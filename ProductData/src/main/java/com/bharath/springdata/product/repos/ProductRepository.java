package com.bharath.springdata.product.repos;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.bharath.springdata.product.entities.Product;

public interface ProductRepository extends PagingAndSortingRepository<Product, Integer> {
	
	List<Product> findByName(String name);

	List<Product> findByNameAndDesc(String name, String desc);

	List<Product> findByPriceGreaterThan(Double price);

	List<Product> findByDescContains(String desc);

	List<Product> findByPriceBetween(Double price1, Double price2);

	List<Product> findByDescLike(String desc);
	
	List<Product> findByIdIn(List<Integer> ids, Pageable pageable);

}
