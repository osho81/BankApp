package com.yajava.bankapp.account;


public abstract class BankAccount {

	private String accountNo;
	private double balance;
	private boolean goldAccount;


	public BankAccount(String accountNo) {
		setAccountNo(accountNo);
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		// Check if only 0-1 is entered
		boolean onlyNums = false;
		for (char ch : accountNo.toCharArray()) {
			switch (ch) {
		case '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' -> onlyNums = true;
        default -> throw new IllegalArgumentException("Only numbers allowed");
			}
		}
		
		// If account number is 9 charcters and only numbers, accept it
		if (accountNo.length() == 9 && onlyNums) {
			this.accountNo = accountNo;
		} else {
			throw new IllegalArgumentException("Accountnumber must be 9 numbers");
		}
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public boolean isGoldAccount() {
		return goldAccount;
	}

	// Set true if golden customer (so can make bigger transactions etc)
	public void setGoldAccount(boolean goldAccount) {
		this.goldAccount = goldAccount;
	}

	@Override
	public String toString() {
		String goldOrNot = goldAccount == true ? "Yes" : "No";
		return "Account number:\t" + accountNo + "\nBalance:\t" + balance + "\nGold account:\t" + goldOrNot;
	}
	
	

}
