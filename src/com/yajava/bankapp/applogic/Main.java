package com.yajava.bankapp.applogic;

import com.yajava.bankapp.utils.Printout;

/**
 * Main class; welcomes user and starts the app (menu/application logic)
 * Author: https://github.com/osho81
 */

public class Main {

	public static void main(String[] args) throws InterruptedException {

		// Welcome user - utilizing DesignPrint's static method
		Printout.welcome();

		// Run application logic and menus
		AppLogic appLogic = new AppLogic();
		appLogic.mainMenu();

	}

}
