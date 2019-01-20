package com.demo.springdata.transactionmanagement.repository;

import org.springframework.data.repository.CrudRepository;

import com.demo.springdata.transactionmanagement.entity.BankAccount;

public interface BankAccountRepository extends CrudRepository<BankAccount, Integer> {

}
