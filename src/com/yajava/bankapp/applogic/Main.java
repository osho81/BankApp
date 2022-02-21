package com.yajava.bankapp.applogic;

/**
 * Main class; welcomes user and starts the app (menu/application logic)
 */

public class Main {

	public static void main(String[] args) throws InterruptedException {

		// Welcome user - utilizing DesignPrint's static method
		// Printout.welcome();

		// Run application logic and menus
		AppLogic appLogic = new AppLogic();
		appLogic.mainMenu();



		// TEMPORARY TESTING
//		System.out.println("---Temporary testing outside menu/app logic---");
//		Customer c1 = new Customer("Mickey", "Mouse", "City address 123", "1950121212", 1001);
//
//		TransactionAccount tAcc = new TransactionAccount("123456789");
//		SavingAccount sAcc = new SavingAccount("987654321");
//
//		// Assign created transAcc & saveAcc to c1-customer
//		c1.setTransAcc(tAcc);
//		c1.setSaveAcc(sAcc);
//
//		System.out.println(c1);
//		System.out.println("--------------------");
//		System.out.println(sAcc);

	}

}
