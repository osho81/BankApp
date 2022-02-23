package com.yajava.bankapp.account;

import com.yajava.bankapp.customer.Customer;

// SavingAccount inheriting from BankAccount parent class

public class SavingAccount extends BankAccount {

	private Customer owner;

	// Constructor, creating account without assigning it to an owner
	public SavingAccount(String accountNo) {
		super(accountNo);
	}

	public SavingAccount(String accountNo, Customer owner) {
		super(accountNo);
		this.setOwner(owner);
	}

	public Customer getOwner() {
		return owner;
	}

	// E.g. customer had double identity; move account to second identity
	public void setOwner(Customer owner) {
		this.owner = owner;
	}

	@Override
	public String toString() {
		String ownerString = owner != null ? String.valueOf(owner.getCustomerNo()) : "Not assigned";
		return "SAVING ACCOUNT\nOwner:\t\t\t" + ownerString + "\n" + super.toString();
	}

	

}
