package com.yajava.bankapp.service;

import com.yajava.bankapp.applogic.CustomerRegister;
import com.yajava.bankapp.customer.Customer;
import com.yajava.bankapp.utils.InputValidation;
import java.util.List;

public class EmployeeActions {

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
    }

    public void showCustomer(CustomerRegister customerRegister) {
        System.out.println("1. Display full customer list\n2. Display specific customer");
        int choice = InputValidation.validateUserMenuChoice();
        if (choice == 1) {
            for (var cust : customerRegister.getCustomerList()) {
                System.out.println(cust);
            }
        } else {
            searchAndDisplay(customerRegister.getCustomerList());
        }
    }


    //------------FIX SEARH BY SSN-------------------//

    private void searchAndDisplay(List customerList) {
        System.out.println("1.Search customer by customer number\n2.Search customer by SSN");
        int choice = InputValidation.validateUserMenuChoice();
        if (choice == 1) {
            System.out.println("Enter customer number or name");
            int customerChoice = InputValidation.validateCustomerChoice(customerList);
            System.out.println(customerList.get(customerChoice));
        } else if (choice == 2) {
            System.out.println("Enter customer SSN");
            boolean found = false;
            String customerChoice = InputValidation.stringedNumbersValidation();
            for (Object customer : customerList) {
                Customer currentCustomer = (Customer) customer;
                if (currentCustomer.getSSN().equals(customerChoice)) { // If there is a hit...
                    System.out.println(currentCustomer); // Print found customer
                    found = true; // and mark customer as found
                }
            }
            if (!found) // If not found
                System.out.println("Did not find " + customerChoice);

        }
    }



    public void disableCustomer() {
        // make transactions for chosen customer NULL
        // If remove customer, customer ID might be mixed up?

    }
}
