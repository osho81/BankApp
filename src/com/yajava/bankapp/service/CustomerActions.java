package com.yajava.bankapp.service;

import com.yajava.bankapp.account.BankAccount;
import com.yajava.bankapp.customer.Customer;
import com.yajava.bankapp.utils.InputValidation;

public class CustomerActions {

    public void accountInfo(Customer chosenCustomer) {
        System.out.println(chosenCustomer);
    }

    public void depositMoney(Customer chosenCustomer) {
        // To what account will the deposit be done
        System.out.println("To which acocunt do you want to deposit money\n1. Saving account\n2. Transaction account");
        BankAccount toAccount = InputValidation.validateUserIntegerChoice(2) == 1 ?
                toAccount = chosenCustomer.getSaveAcc() : chosenCustomer.getTransAcc();

        // From what account: from an account in this bank or external?
        System.out.println("From which acocunt do you want to deposit money\n" +
                "1. Saving account\n2. Transaction account\n3. External account");
        int userChoice = InputValidation.validateUserIntegerChoice(3);
        if (userChoice == 1) {
            BankAccount fromAccount = chosenCustomer.getSaveAcc();
            System.out.println("How much to deposit (maximum " + fromAccount.getBalance() + " USD): ");
            double amount = InputValidation.validateUserIntegerChoice((int) fromAccount.getBalance());
            fromAccount.setBalance(amount, false); // Take from fromAccount
            toAccount.setBalance(amount, true); // Deposit to toAccount

        } else if (userChoice == 2) {
            BankAccount fromAccount = chosenCustomer.getTransAcc();
            System.out.println("How much to deposit (maximum " + fromAccount.getBalance() + " USD): ");
            double amount = InputValidation.validateUserIntegerChoice((int) fromAccount.getBalance());
            fromAccount.setBalance(amount, false); // Take from fromAccount
            toAccount.setBalance(amount, true); // Deposit to toAccount

        } else if (userChoice == 3) {
            System.out.println("How much to deposit (maximum 1 million: ");
            double amount = InputValidation.validateUserIntegerChoice(1000000);
            toAccount.setBalance(amount, true);
        }
    }

    public void withdrawMoney(Customer chosenCustomer) {

    }
}
