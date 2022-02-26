package com.yajava.bankapp.applogic;

// Application logic, including outer (main) menu and two inner menus

import com.yajava.bankapp.banklogic.BankInfo;
import com.yajava.bankapp.customer.Customer;
import com.yajava.bankapp.utils.Printout;
import com.yajava.bankapp.utils.InputValidation;
import com.yajava.bankapp.banklogic.Search;

public class AppLogic {

    BankInfo bankInfo = BankInfo.CreateList(); // Singleton
    EmployeeActions employeeActions = new EmployeeActions();
    CustomerActions customerActions = new CustomerActions();

    public void mainMenu() throws InterruptedException {

        int userChoice = 0;
        while (userChoice != 3) {
            Printout.startMenu();
            userChoice = InputValidation.validateUserIntegerChoice(3);
            switch (userChoice) {
                case 1 -> employeeMenu();
                case 2 -> customerMenu();
                case 3 -> Printout.exitMessage();
            }
        }
    }

    private void employeeMenu() throws InterruptedException {

        int userChoice = 0;
        while (userChoice != 4) {
            Printout.employeeMenu();
            userChoice = InputValidation.validateUserIntegerChoice(4);
            switch (userChoice) {
                case 1 -> employeeActions.addCustomer(bankInfo);
                case 2 -> employeeActions.showCustomer(bankInfo);
                case 3 -> employeeActions.disableCustomer(bankInfo);
                case 4 -> mainMenu();
            }
        }
    }

    private void customerMenu() throws InterruptedException {

        // Settle which customer is using the app
        Customer chosenCustomer = null;
        boolean notNull = false;
        while (!notNull) {
            chosenCustomer = Search.searchWithSSN(bankInfo.getCustomerList());
            String displayString = chosenCustomer == null ? "Try again: " : "Welcome " + chosenCustomer.getfName() + " " + chosenCustomer.getlName();
            System.out.println(displayString);
            notNull = chosenCustomer == null ? false : true;
        }

        int userChoice = 0;
        while (userChoice != 4) {

            Printout.customerMenu();
            userChoice = InputValidation.validateUserIntegerChoice(4);
            switch (userChoice) {
                case 1 -> customerActions.accountInfo(chosenCustomer);
                case 2 -> customerActions.depositMoney(chosenCustomer);
                case 3 -> customerActions.withdrawMoney(chosenCustomer);
                case 4 -> mainMenu();
            }
        }
    }
}
