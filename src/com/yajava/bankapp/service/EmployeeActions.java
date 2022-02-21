package com.yajava.bankapp.service;

import com.yajava.bankapp.account.SavingAccount;
import com.yajava.bankapp.account.TransactionAccount;
import com.yajava.bankapp.applogic.CustomerRegister;
import com.yajava.bankapp.customer.Customer;
import com.yajava.bankapp.utils.InputValidation;
import java.util.List;
import java.util.Objects;

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
        int choice = InputValidation.validateUserMenuChoice();
        if (choice == 1) {
            for (var cust : customerRegister.getCustomerList()) {
                System.out.println(cust);
            }
        } else { // Search and get customer to display
            Customer chosenCustomer = searchAndReturnCustomer(customerRegister.getCustomerList());
            String displayString = chosenCustomer == null ? "Try again; See menu " : "" + chosenCustomer;
            System.out.println(displayString);
        }
    }

    public void disableCustomer(CustomerRegister customerRegister) {
        // Search customer to block
        Customer chosenCustomer = searchAndReturnCustomer(customerRegister.getCustomerList());
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

    private Customer searchAndReturnCustomer(List customerList) {
        System.out.println("1.Search customer by customer number\n2.Search customer by SSN");
        int choice = InputValidation.validateUserMenuChoice();
        Customer foundCustomer = null;

        // Search for specific customer by customer number
        if (choice == 1) {
            System.out.println("Enter customer number");
            int customerChoice = InputValidation.validateCustomerChoice(customerList);
            foundCustomer = (Customer) customerList.get(customerChoice);

            // Search for specific customer by SSN
        } else if (choice == 2) {
            System.out.println("Enter customer SSN");
            boolean found = false;
            String customerChoice = InputValidation.stringedNumbersValidation();
            for (Object customer : customerList) {
                Customer currentCustomer = (Customer) customer;
                if (currentCustomer.getSSN().equals(customerChoice)) { // If there is a hit...
                    foundCustomer = currentCustomer; // Return found customer
                    found = true; // and mark customer as found
                }
            }
            if (!found)  // If not found
                System.out.println("Did not find " + customerChoice);

        }
        return foundCustomer;
    }


}
