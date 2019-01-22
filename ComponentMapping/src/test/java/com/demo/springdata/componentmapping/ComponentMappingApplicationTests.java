package com.demo.springdata.componentmapping;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.demo.springdata.componentmapping.entity.Address;
import com.demo.springdata.componentmapping.entity.Employee;
import com.demo.springdata.componentmapping.repository.EmployeeRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ComponentMappingApplicationTests {

	@Autowired
	private EmployeeRepository repository;
	
	@Test
	public void contextLoads() {
	}
	
	@Test
	public void testCreate() {
		Employee employee = new Employee();
		employee.setId(123);
		employee.setName("Bharath");
		Address address = new Address();
		address.setCity("Austin");
		address.setStreetaddress("Spicemood Springs");
		address.setCountry("USA");
		address.setState("TEXAS");
		address.setZipcode("78750");
		employee.setAddress(address);
		repository.save(employee);
	}

}

