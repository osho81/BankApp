package com.yajava.bankapp.applogic;

/*
 * Application logic, including outer menu and two inner menus
 */

import com.yajava.bankapp.service.CustomerActions;
import com.yajava.bankapp.service.EmployeeActions;
import com.yajava.bankapp.utils.Printout;
import com.yajava.bankapp.utils.InputValidation;

public class AppLogic {

    CustomerRegister customerRegister = CustomerRegister.CreateList(); // Singleton
    EmployeeActions employeeActions = new EmployeeActions();
    CustomerActions customerActions = new CustomerActions();

    public void start() throws InterruptedException {

        int userChoice = 0;
        while (userChoice != 3) {
            Printout.startMenu();
            userChoice = InputValidation.validateUserMenuChoice();
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
            userChoice = InputValidation.validateUserMenuChoice();
            switch (userChoice) {
                case 1 -> employeeActions.addCustomer(customerRegister);
                case 2 -> employeeActions.blockCustomer();
                case 3 -> employeeActions.removeCustomer();
                case 4 -> start();
            }
        }
    }

    private void customerMenu() throws InterruptedException {

        int userChoice = 0;
        while (userChoice != 4) {
            Printout.customerMenu();
            userChoice = InputValidation.validateUserMenuChoice();
            switch (userChoice) {
                case 1 -> customerActions.accountInfo();
                case 2 -> customerActions.depositMoney();
                case 3 -> customerActions.withdrawMoney();
                case 4 -> start();
            }
        }
    }

}
