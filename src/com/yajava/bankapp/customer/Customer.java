package com.yajava.bankapp.customer;

import com.yajava.bankapp.account.SavingAccount;
import com.yajava.bankapp.account.TransactionAccount;

// Class for Customer

public class Customer extends Person {

	private TransactionAccount transAcc;
	private SavingAccount saveAcc;

	// Containers for blocked customer accounts´(to save them, but disable them)
	private TransactionAccount blockedTransAcc;
	private SavingAccount blockedSaveAcc;

	private int customerNo;

	// Constructor, also implementing super class constructor
	public Customer(String fName, String lName, String address, String ssn, int customerNo) {
		super(fName, lName, address, ssn);
		this.customerNo = customerNo;
	}

	public TransactionAccount getTransAcc() {
		return transAcc;
	}

	public void setTransAcc(TransactionAccount transAcc) {
		this.transAcc = transAcc;
		// Enforce assignment in account also; this refers to this current customer
		transAcc.setOwner(this);
	}

	public SavingAccount getSaveAcc() {
		return saveAcc;
	}

	public void setSaveAcc(SavingAccount saveAcc) {
		this.saveAcc = saveAcc;
		saveAcc.setOwner(this);
	}

	public TransactionAccount getBlockedTransAcc() {
		return blockedTransAcc;
	}

	public void setBlockedTransAcc(TransactionAccount transAcc) {
		this.blockedTransAcc = blockedTransAcc;
	}
	public SavingAccount getBlockedSaveAcc() {
		return blockedSaveAcc;
	}
	public void setBlockedSaveAcc(SavingAccount saveAcc) {
		this.blockedSaveAcc = blockedSaveAcc;
	}
	public int getCustomerNo() {
		return customerNo;
	}
	public void setCustomerNo(int customerNo) {
		this.customerNo = customerNo;
	}

	// Getters/Setters to handle required fields from parent (Person) class
	@Override
	public String getSSN() {
		return super.getSSN(); // From parent (Person)
	}
	public void setSSN(String ssn) {
		super.setSSN(ssn); // From parent (Person)
	}

	@Override
	public String toString() {
		return "Customer No: " + customerNo + "\t\t" + super.toString() + (transAcc == null ? "" : "\n" + transAcc)
				+ (saveAcc == null ? "" : "\n" + saveAcc) + "\n";
	}

}
