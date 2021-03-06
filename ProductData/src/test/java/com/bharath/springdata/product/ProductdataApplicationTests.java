package com.bharath.springdata.product;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.test.context.junit4.SpringRunner;

import com.bharath.springdata.product.entities.Product;
import com.bharath.springdata.product.repos.ProductRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductdataApplicationTests {

	@Autowired
	ProductRepository repository;
	
	@Autowired
	EntityManager entityManager;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testCreate() {
		Product product = new Product();
		product.setId(1);
		product.setName("Iphone");
		product.setDesc("Awesome");
		product.setPrice(1000d);

		repository.save(product);
	}

	@Test
	public void testRead() {
		Product product = repository.findById(1).get();
		assertNotNull(product);
		assertEquals("Iphone", product.getName());
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + product.getDesc());
	}

	@Test
	public void testUpdate() {
		Product product = repository.findById(1).get();
		product.setPrice(1200d);
		repository.save(product);

	}

	@Test
	public void testDelete() {
		if (repository.existsById(1)) {
			System.out.println("Deleting a product");
			repository.deleteById(1);
		}
	}

	@Test
	public void testCount() {
		System.out.println("Total Records===============>>>>>>>>>>>>>>>" + repository.count());

	}

	@Test
	public void testFindByName() {
		//Product findOne = repository.findById(1).get();
		List<Product> products = repository.findByName("IWatch");
		products.forEach(p -> System.out.println(p.getPrice()));
	}

	@Test
	public void testFindByNameAndDesc() {
		List<Product> products = repository.findByNameAndDesc("TV", "From Samsung Inc");
		products.forEach(p -> System.out.println(p.getPrice()));
	}

	@Test
	public void testFindByPriceGreaterThan() {
		List<Product> products = repository.findByPriceGreaterThan(1000d);
		products.forEach(p -> System.out.println(p.getName()));
	}

	@Test
	public void testFindByDescContains() {
		List<Product> products = repository.findByDescContains("Apple");
		products.forEach(p -> System.out.println(p.getName()));
	}

	@Test
	public void testFindByPriceBetween() {
		List<Product> products = repository.findByPriceBetween(500d, 2500d);
		products.forEach(p -> System.out.println(p.getName()));
	}

	@Test
	public void testFindByDescLike() {
		List<Product> products = repository.findByDescLike("%LG%");
		products.forEach(p -> System.out.println(p.getName()));
	}

	@Test
	public void testFindByIdsIn() {
		Pageable pageable = new PageRequest(0, 2);
		List<Product> products = repository.findByIdIn(Arrays.asList(1, 2, 3, 4), pageable);
		products.forEach(p -> System.out.println(p.getName()));
	}
	
	@Test
	public void testFindAllPaging() {
		Pageable pageable = new PageRequest(1, 2);
		
		Page<Product> results = repository.findAll(pageable);
		results.forEach(p->System.out.println(p.getName()));
		
	}
	
	@Test
	public void testFindAllSorting() {
		repository.findAll(new Sort(new Sort.Order(Direction.DESC, "name"), new Sort.Order("price")));
		
		//repository.findAll(new Sort(Direction.DESC, "name", "price")).forEach(p->System.out.println(p.getName()));
	}
	
	@Test
	public void testFindAllPagingAndSorting() {
		Pageable pageable = new PageRequest(0, 2, Direction.DESC, "name");
		repository.findAll(pageable).forEach(p->System.out.println(p.getName()));
	}
	
	@Test
	@Transactional
	public void testCaching() {
		Session session = entityManager.unwrap(Session.class);
		Product product = repository.findById(1).get();
		
		repository.findById(1).get();
		
		session.evict(product);
		
		repository.findById(1).get();
	}

}












