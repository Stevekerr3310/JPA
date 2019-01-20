package com.demo.springdata.associations;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.demo.springdata.associations.manytomany.entity.Programmer;
import com.demo.springdata.associations.manytomany.entity.Project;
import com.demo.springdata.associations.manytomany.repository.ProgrammerRepository;
import com.demo.springdata.associations.onetomany.entity.Customer;
import com.demo.springdata.associations.onetomany.entity.PhoneNumber;
import com.demo.springdata.associations.onetomany.repository.CustomerRepository;
import com.demo.springdata.associations.onetoone.entity.License;
import com.demo.springdata.associations.onetoone.entity.Person;
import com.demo.springdata.associations.onetoone.repository.LicenseRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AssociationsApplicationTests {
	
	@Autowired
	private CustomerRepository repository;
	
	@Autowired
	private ProgrammerRepository programmerRepository;
	
	@Autowired
	private LicenseRepository licenseRepository;

	@Test
	public void contextLoads() {
	}
	
	@Test
	public void testCreateCustomer() {
		
		Customer customer = new Customer();
		customer.setName("John");
		HashSet<PhoneNumber> numbers = new HashSet<PhoneNumber>();
		
		PhoneNumber ph1 = new PhoneNumber();
		ph1.setNumber("1234567890");
		ph1.setType("cell");
		
		//ph1.setCustomer(customer);
		//numbers.add(ph1);
		
		PhoneNumber ph2 = new PhoneNumber();
		ph2.setNumber("0987654321");
		ph2.setType("home");
		ph2.setCustomer(customer);

		//numbers.add(ph2);
		//customer.setNumbers(numbers);
		
		customer.addPhoneNumber(ph1);
		customer.addPhoneNumber(ph2);
		repository.save(customer);
	}
	
	@Test
	@Transactional
	public void testLoadCustomer() {
		Customer customer = repository.findOne(4L);
		System.out.println("=====> " + customer.getName());
		
		Set<PhoneNumber> numbers = customer.getNumbers();
		numbers.forEach(number -> System.out.println(number.getNumber()));
	}
	
	@Test
	@Transactional
	public void testUpdateCustomer() {
		Customer customer = repository.findOne(4L);
		customer.setName("John Bush");
		
		Set<PhoneNumber> numbers = customer.getNumbers();
		numbers.forEach(number -> number.setType("cell"));
		
		repository.save(customer);
	}
	
	@Test
	public void testDelete() {
		repository.delete(4L);
	}
	
	@Test
	public void testMany2ManyCreateProgrammer() {
		Programmer programmer = new Programmer();
		programmer.setName("John");
		programmer.setSalary(10000);
		
		HashSet<Project> projects = new HashSet<Project>();
		Project project = new Project();
		project.setName("Hibernate Project");
		projects.add(project);
		
		programmer.setProjects(projects);
		
		programmerRepository.save(programmer);
	}
	
	@Test
	@Transactional
	public void testMany2ManyFindProgrammer() {
		Programmer programmer = programmerRepository.findOne(1);
		System.out.println(programmer);
		System.out.println(programmer.getProjects());
	}

	@Test
	public void testOneToOneCreateLicense() {
		License license = new License();
		license.setType("CAR");
		license.setValidFrom(new Date());
		license.setValidTo(new Date());
		
		Person person = new Person();
		person.setFirstName("John");
		person.setLastName("Clinton");
		person.setAge(35);
		//person.setLicense(license);
		
		license.setPerson(person);
		
		licenseRepository.save(license);
	}
}

