package com.demo.springdata.transactionmanagement.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BankAccount {
	
	@Id
	private Integer accno;
	private String firstName;
	private String lastName;
	private Integer bal;

	public Integer getAccno() {
		return accno;
	}

	public void setAccno(Integer accno) {
		this.accno = accno;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getBal() {
		return bal;
	}

	public void setBal(Integer bal) {
		this.bal = bal;
	}

	@Override
	public String toString() {
		return "BankAccount [accno=" + accno + ", firstName=" + firstName + ", lastName=" + lastName + ", bal=" + bal
				+ "]";
	}

}
