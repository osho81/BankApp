package com.yajava.bankapp.service;

import com.yajava.bankapp.account.SavingAccount;
import com.yajava.bankapp.account.TransactionAccount;
import com.yajava.bankapp.applogic.CustomerRegister;
import com.yajava.bankapp.customer.Customer;
import com.yajava.bankapp.utils.InputValidation;
import com.yajava.bankapp.utils.Search;

public class EmployeeActions {

    // Add customer AND generate and add accounts
    public void addCustomer(CustomerRegister customerRegister) {

        System.out.println("First name: ");
        String fName = InputValidation.stringValidation();
        System.out.println("Last name: ");
        String lName = InputValidation.stringValidation();
        System.out.println("Address: ");
        String address = InputValidation.stringValidation();
        System.out.println("SSN: ");
        String ssn = InputValidation.stringedNumbersValidation();

        // Add 1000 to customer no; consider this when searching for specific customer
        Customer customer = new Customer(fName, lName, address, ssn, (customerRegister.getCustomerList().size()+1000));
        customerRegister.addToCustomerList(customer);

        // Generate accounts and assign them to created customer (and assign customer to accounts)
        SavingAccount saveAccount = new SavingAccount("" + (customerRegister.getCustomerList().size()+1000000), customer);
        customer.setSaveAcc(saveAccount);
        TransactionAccount transAccount = new TransactionAccount("" + (customerRegister.getCustomerList().size()+9000000), customer);
        customer.setTransAcc(transAccount);
    }

    public void showCustomer(CustomerRegister customerRegister) {
        System.out.println("1. Display full customer list\n2. Display specific customer");
        int choice = InputValidation.validateUserIntegerChoice(2);
        if (choice == 1) {
            for (var cust : customerRegister.getCustomerList()) {
                System.out.println(cust);
            }
        } else { // Search and get customer to display
            Customer chosenCustomer = Search.searchAndReturnCustomer(customerRegister.getCustomerList());
            String displayString = chosenCustomer == null ? "Try again; See menu " : "" + chosenCustomer;
            System.out.println(displayString);
        }
    }

    public void disableCustomer(CustomerRegister customerRegister) {
        // Search customer to block
        Customer chosenCustomer = Search.searchAndReturnCustomer(customerRegister.getCustomerList());
        String displayString = chosenCustomer == null ? "Try again; See menu " : "Found customer: " + chosenCustomer;
        System.out.println(displayString);

        // Actually disabling eventual accounts for chosen customer
        // Consider null situations
        if (chosenCustomer.getSaveAcc() != null || chosenCustomer.getTransAcc() != null) {
            chosenCustomer.setBlockedSaveAcc(chosenCustomer.getSaveAcc());
            chosenCustomer.setBlockedTransAcc(chosenCustomer.getTransAcc());
            chosenCustomer.setSaveAcc(null);
            chosenCustomer.setTransAcc(null);
            System.out.println("The customer's accounts are disabled");
        } else {
            System.out.println("The customer has no active accounts");
        }
    }

}
