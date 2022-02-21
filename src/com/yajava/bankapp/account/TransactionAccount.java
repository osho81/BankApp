package com.yajava.bankapp.account;

import com.yajava.bankapp.customer.Customer;

/**
 * TransactionAccount (checking account) inheriting from BankAccount parent class.
 */

public class TransactionAccount extends BankAccount {
	
	private Customer owner;
	
	// Constructor, creating account without assigning it to an owner
	public TransactionAccount(String accountNo) {
		super(accountNo);
	}

	public TransactionAccount(String accountNo, Customer owner) {
		super(accountNo);
		this.setOwner(owner);
	}

	public Customer getOwner() {
		return owner;
	}

	// E.g. to assign an already created account to a customer
	public void setOwner(Customer owner) {
		this.owner = owner;
	} 
	
	@Override
	public String toString() {
		String ownerString = owner != null ? String.valueOf(owner.getCustomerNo()) : "Not assigned";
		return "Transaction Account\nOwner:\t\t" + ownerString + "\n" + super.toString();
	}

}
