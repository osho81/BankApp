package com.yajava.bankapp.applogic;

import com.yajava.bankapp.account.SavingAccount;
import com.yajava.bankapp.account.TransactionAccount;
import com.yajava.bankapp.customer.Customer;

public class Main {

	public static void main(String[] args) {
		
		
		AppLogic bankLogic = new AppLogic();
		bankLogic.runApp();
		
		Customer c1 = new Customer("Mickey", "Mouse", "City address 123", "1950121212", 1001);
		
		TransactionAccount tAcc = new TransactionAccount("123456789");
		SavingAccount sAcc = new SavingAccount("987654321");
		
		// Assign created transAcc & saveAcc to c1-customer
		c1.setTransAcc(tAcc);
		c1.setSaveAcc(sAcc);
		
		System.out.println(c1);
		System.out.println("--------------------");
		System.out.println(sAcc);

	}

}
