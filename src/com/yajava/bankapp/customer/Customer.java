package com.yajava.bankapp.customer;

import com.yajava.bankapp.account.SavingAccount;
import com.yajava.bankapp.account.TransactionAccount;

public class Customer extends Person {

	private TransactionAccount transAcc;
	private SavingAccount saveAcc;
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
		transAcc.setOwner(this); // Enforce assignment in account also
	}

	public SavingAccount getSaveAcc() {
		return saveAcc;
	}

	public void setSaveAcc(SavingAccount saveAcc) {
		this.saveAcc = saveAcc;
		saveAcc.setOwner(this); // Enforce assignment in account also
	}

	public int getCustomerNo() {
		return customerNo;
	}

	public void setCustomerNo(int customerNo) {
		this.customerNo = customerNo;
	}

	@Override
	public String toString() {
		return "Customer No: " + customerNo + "\t" + super.toString() + "\n\n" + (transAcc == null ? "" : transAcc)
				+ "\n\n" + (saveAcc == null ? "" : saveAcc);
	}

}
