package fancyfoods.persistence;

import javax.persistence.Entity;
import javax.persistence.Id;

import fancyfoods.food.Customer;

@Entity(name = "CUSTOMER")
public class CustomerImpl implements Customer {

	@Id
	private String name;
	private double creditLimit;
	private double balance;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getCreditLimit() {
		return creditLimit;
	}

	public void setCreditLimit(double creditLimit) {
		this.creditLimit = creditLimit;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return new StringBuilder(getName()).append(" had a balance of $")
				.append(getBalance()).append(" and a credit limit of $")
				.append(getCreditLimit()).toString();
	}

}
