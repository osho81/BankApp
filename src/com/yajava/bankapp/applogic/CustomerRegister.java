package com.yajava.bankapp.applogic;

import com.yajava.bankapp.customer.Customer;

import java.util.ArrayList;
import java.util.List;

// Class holding a customer list; implementing singleton pattern

public class CustomerRegister {

    private List<Customer> customerList;
    private static CustomerRegister instance; // Singleton instance component

    private CustomerRegister() { // Created only via the static method
        this.customerList = new ArrayList<>();
    }

    // Creates instance, when not already created (Singleton component)
    public static CustomerRegister CreateList() {
        if (instance == null) {
            instance = new CustomerRegister();
        }
        return instance;
    }

    public List<Customer> getCustomerList() { return customerList; }
    public void setCustomerList(List<Customer> customerList) { this.customerList = customerList; }

    // Method: Add customer to list
    public void addToCustomerList(Customer customer) {
        this.customerList.add(customer);
    }
}
