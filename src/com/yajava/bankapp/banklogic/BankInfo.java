package com.yajava.bankapp.banklogic;

import com.yajava.bankapp.customer.Customer;

import java.util.ArrayList;
import java.util.List;

// Class holding a customer list; implementing singleton pattern

public class BankInfo {
    private String bankName;
    private int postalCode; // Bank chapter

    private List<Customer> customerList;
    private static BankInfo instance; // Singleton instance component

    private BankInfo() { // Created only via the static method
        this.customerList = new ArrayList<>();
    }

    // Creates instance, when not already created (Singleton component)
    public static BankInfo CreateList() {
        if (instance == null) {
            instance = new BankInfo();
        }
        return instance;
    }

    public String getBankName() { return bankName; }
    public void setBankName(String bankName) { this.bankName = bankName; }
    public int getPostalCode() { return postalCode; }
    public void setPostalCode(int postalCode) { this.postalCode = postalCode; }

    public List<Customer> getCustomerList() { return customerList; }
    public void setCustomerList(List<Customer> customerList) { this.customerList = customerList; }

    // Method: Add customer to list
    public void addToCustomerList(Customer customer) {
        this.customerList.add(customer);
    }
}
