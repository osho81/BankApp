package com.yajava.bankapp.applogic;

import com.yajava.bankapp.account.BankAccount;
import com.yajava.bankapp.customer.Customer;
import com.yajava.bankapp.utils.InputValidation;

public class CustomerActions {

    public void accountInfo(Customer chosenCustomer) {
        System.out.println(chosenCustomer);
    }

    public void depositMoney(Customer chosenCustomer) {
        // To what account will the deposit be done
        System.out.println("To which account do you want to deposit money\n1. Transaction account\n2. Saving account");
        BankAccount toAccount = InputValidation.validateUserIntegerChoice(2) == 1 ?
                chosenCustomer.getTransAcc() : chosenCustomer.getSaveAcc();

        // From what account: from an account in this bank or external?
        System.out.println("From which account do you want to deposit money\n"
                + "1. Transaction account\n2. Saving account\n3. External account");
        int userChoice = InputValidation.validateUserIntegerChoice(3);
        if (userChoice == 1) {
            BankAccount fromAccount = chosenCustomer.getTransAcc();
            if (fromAccount.getBalance() < 10) {
                System.out.println("Sorry, you only have " + fromAccount.getBalance()
                        + " USD in your transaction account (must have at least 10 USD)");
            } else {
                System.out.println("How much to deposit (maximum " + fromAccount.getBalance() + " USD): ");
                double amount = InputValidation.validateUserIntegerChoice((int) fromAccount.getBalance());
                fromAccount.setBalance(amount, false); // Take from fromAccount
                toAccount.setBalance(amount, true); // Deposit to toAccount
            }

        } else if (userChoice == 2) {
            BankAccount fromAccount = chosenCustomer.getSaveAcc();
            if (fromAccount.getBalance() < 10) {
                System.out.println("Sorry, you only have " + fromAccount.getBalance()
                        + " USD in your saving account (must have at least 10 USD)");
            } else {
                System.out.println("How much to deposit (maximum " + fromAccount.getBalance() + " USD): ");
                double amount = InputValidation.validateUserIntegerChoice((int) fromAccount.getBalance());
                fromAccount.setBalance(amount, false); // Take from fromAccount
                toAccount.setBalance(amount, true); // Deposit to toAccount
            }

        } else if (userChoice == 3) {
            System.out.println("How much to deposit (maximum 1 million: ");
            double amount = InputValidation.validateUserIntegerChoice(1000000);
            toAccount.setBalance(amount, true);
        }
    }

    public void withdrawMoney(Customer chosenCustomer) {
        // From which bank account to withdraw money?
        System.out.println("From which account do you want to withdraw money\n" +
                "1. Transaction account\n2. Saving account");
        int userChoice = InputValidation.validateUserIntegerChoice(2);
        if (userChoice == 1) {
            BankAccount fromAccount = chosenCustomer.getTransAcc();
            if (fromAccount.getBalance() < 10) {
                System.out.println("Sorry, you only have " + fromAccount.getBalance()
                        + " USD in your transaction account (must have at least 10 USD)");
            } else {
                System.out.println("How much to deposit (maximum " + fromAccount.getBalance() + " USD): ");
                double amount = InputValidation.validateUserIntegerChoice((int) fromAccount.getBalance());
                fromAccount.setBalance(amount, false); // Take from fromAccount
            }

        } else if (userChoice == 2) {
            BankAccount fromAccount = chosenCustomer.getSaveAcc();
            if (fromAccount.getBalance() < 10) {
                System.out.println("Sorry, you only have " + fromAccount.getBalance()
                        + " USD in your saving account (must have at least 10 USD)");
            } else {
                System.out.println("How much to deposit (maximum " + fromAccount.getBalance() + " USD): ");
                double amount = InputValidation.validateUserIntegerChoice((int) fromAccount.getBalance());
                fromAccount.setBalance(amount, false); // Take from fromAccount
            }
        }
    }
}
