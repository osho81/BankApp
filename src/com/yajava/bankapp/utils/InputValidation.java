package com.yajava.bankapp.utils;

import java.util.Scanner;

public class InputValidation {

    // Scanner to be accessed only in this class
    private static final Scanner scan = new Scanner(System.in);

    public static int validateUserMenuChoice() {
        while (!scan.hasNextInt()) {
            scan.nextLine();
            System.out.print("Only numbers are allowed!");
        }
        int intChoice = scan.nextInt();
        scan.nextLine();
        return intChoice;
    }

}
