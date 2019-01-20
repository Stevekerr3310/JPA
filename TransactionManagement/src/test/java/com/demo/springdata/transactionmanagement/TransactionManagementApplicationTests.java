package com.demo.springdata.transactionmanagement;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.demo.springdata.transactionmanagement.service.BankAccountService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TransactionManagementApplicationTests {

	@Autowired
	BankAccountService service;
	
	@Test
	public void contextLoads() {
	}

	@Test
	public void testTransfer() {
		service.transfer(500);
	}
	
}

