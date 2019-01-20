package com.demo.springdata.transactionmanagement.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.springdata.transactionmanagement.entity.BankAccount;
import com.demo.springdata.transactionmanagement.repository.BankAccountRepository;

@Service
public class BankAccountServiceImpl implements BankAccountService {

	@Autowired
	BankAccountRepository repository;

	@Override
	@Transactional
	public void transfer(int amount) {

		BankAccount obamasAccount = repository.findOne(1);
		obamasAccount.setBal(obamasAccount.getBal() - amount);
		repository.save(obamasAccount);
		
		if(true) {
			throw new RuntimeException();
		}

		BankAccount trumpsAccount = repository.findOne(2);
		trumpsAccount.setBal(trumpsAccount.getBal() + amount);
		repository.save(trumpsAccount);

	}

}
