package com.yajava.bankapp.service;

import com.yajava.bankapp.applogic.CustomerRegister;
import com.yajava.bankapp.customer.Customer;
import com.yajava.bankapp.utils.InputValidation;

public class EmployeeActions {

    public void addCustomer(CustomerRegister customerRegister) {

        System.out.println("First name: ");
        String fName = InputValidation.stringValidation();
        System.out.println("Last name: ");
        String lName = InputValidation.stringValidation();
        System.out.println("Address: ");
        String address = InputValidation.stringValidation();
        System.out.println("SSN: ");
        String ssn = InputValidation.ssnValidation();
        System.out.println("Assign a customer number: ");
        int customerNo = InputValidation.verifyCustomerId();

        Customer customer = new Customer(fName, lName, address, ssn, customerNo);
        customerRegister.addToCustomerList(customer);

        System.out.println(customerRegister.getCustomerList());
    }

    public void removeCustomer() {

    }

    public void blockCustomer() {

    }
}
