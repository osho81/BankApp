package com.yajava.bankapp.utils;

import java.util.Scanner;

public class InputValidation {

    // Scanner to be accessed only in this class
    private static final Scanner scan = new Scanner(System.in);

    public static int validateUserMenuChoice() {
        while (!scan.hasNextInt()) {
            scan.nextLine();
            System.out.println("Only numbers are allowed");
        }
        int intChoice = scan.nextInt();
        scan.nextLine(); // Consumes leftovers
        return intChoice;
    }

    public static int verifyCustomerId() {
        int customerNo = scan.nextInt();
        while (customerNo < 1000) {
            System.out.println("Customer number must bigger than 1000");
            customerNo = scan.nextInt();
        }
        return customerNo;
    }

    public static String stringValidation() {
        String str = scan.nextLine();
        while (str.length() > 25) {
            System.out.println("Too many characters (max 25), try again: ");
            str = scan.nextLine();
        }
        return str;
    }

    // ----------------MAYBE CHANGE THIS TO DO-WHILE-LOOP--------------------
    public static String ssnValidation() {
        String str = scan.nextLine();

        // Check if only numbers in social security number
        boolean stopLoop = false;
        boolean containsLetter = false;
        while (!stopLoop) {
            char[] chars = str.toCharArray();
            for (char c : chars) {
                if (!Character.isDigit(c)) {
                    containsLetter = true;
                }
            }
            if (containsLetter || str.length() < 10) {
                System.out.println("SSN should be 10 digits, try again: ");
                containsLetter = false; // Reset condition, to check again
                str = scan.nextLine();
            } else {
                stopLoop = true; // Otherwise end loop
            }
        }
        return str;
    }
}
