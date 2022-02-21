package com.yajava.bankapp.utils;

import com.yajava.bankapp.customer.Customer;

import java.util.List;

public class Search {

    public static Customer searchAndReturnCustomer(List customerList) {
        System.out.println("1.Search customer by customer number\n2.Search customer by SSN");
        int choice = InputValidation.validateUserIntegerChoice(2);
        Customer foundCustomer = null;

        // Search for specific customer by customer number
        if (choice == 1) {
            System.out.println("Enter customer number");
            int customerChoice = InputValidation.validateCustomerChoice(customerList);
            foundCustomer = (Customer) customerList.get(customerChoice);

            // Search for specific customer by SSN
        } else if (choice == 2) {
            return searchWithSSN(customerList);
        }
        return foundCustomer;
    }

    public static Customer searchWithSSN(List customerList) {

        System.out.println("Enter customer SSN");
        boolean found = false;
        String customerChoice = InputValidation.stringedNumbersValidation();
        Customer foundCustomer = null;
        for (Object customer : customerList) {
            Customer currentCustomer = (Customer) customer;
            if (currentCustomer.getSSN().equals(customerChoice)) { // If there is a hit...
                foundCustomer = currentCustomer; // Return found customer
                found = true; // and mark customer as found
            }
        }
        if (!found)  // If not found
            System.out.println("Did not find " + customerChoice);
        return foundCustomer;
    }

}
