package com.yajava.bankapp.utils;

import java.util.List;
import java.util.Scanner;

public class InputValidation {

    // Scanner to be accessed only in this class
    private static final Scanner scan = new Scanner(System.in);

    public static int validateUserIntegerChoice(int maxNum) {

        boolean loop = true;
        int currentValue = 0;
        while (loop) { // Loop, ask for input until less than maxNum
            if (scan.hasNextInt()) {
                currentValue = scan.nextInt();
                if (currentValue > 0 || currentValue < maxNum)
                    loop = false; // Only via here the loop stops
                else
                    System.out.println("Must be less than " + maxNum);
            } else { // If input is not digits
                System.out.println("Only numbers are allowed");
                scan.next();
            }
        }
        return currentValue;

    }

    // Not needed because follows numbers of customersList-length
    public static int validateCustomerChoice(List customerList) {
        int customerChoice = scan.nextInt();

        // Consider customer numbers is +1000
        while ((customerChoice) < 1000 || (customerChoice) >= customerList.size() + 1000) {
            System.out.println("Customer number does not exist, try again");
            customerChoice = scan.nextInt();
        }
        return customerChoice - 1000; // So return numbers uitable for list-index
    }

    public static String stringValidation() {
        String str = scan.nextLine();
        while (str.length() > 25) {
            System.out.println("Too many characters (max 25), try again: ");
            str = scan.nextLine();
        }
        return str;
    }

    // Check if only numbers in social security number, account numbers etc
    public static String stringedNumbersValidation() {
        String str = scan.nextLine();

        // Check if only numbers in input
        boolean stopLoop = false;
        boolean containsLetter = false;
        while (!stopLoop) {
            char[] chars = str.toCharArray();
            for (char c : chars) {
                if (!Character.isDigit(c)) {
                    containsLetter = true;
                }
            }
            // Redo if contains letter or is less than 10 digits
            if (containsLetter || str.length() < 10) {
                System.out.println("Should be at least 10 digits, try again: ");
                containsLetter = false; // Reset condition, to check again
                str = scan.nextLine();
            } else {
                stopLoop = true; // Otherwise end loop
            }
        }
        return str;
    }
}
