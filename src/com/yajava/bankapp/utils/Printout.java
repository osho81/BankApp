package com.yajava.bankapp.utils;

// Class with static methods for reoccurring and basic printouts

public class Printout {

    public static void welcome() throws InterruptedException {
        String welcome = "Welcome to Bank Of Bravos\n";
        for (char c : welcome.toCharArray()) {
            System.out.print(c);
            Thread.sleep(50);
        }
        Thread.sleep(800);
    }

    public static void exitMessage() throws InterruptedException {
        String welcome = "Thank You!\n";
        for (char c : welcome.toCharArray()) {
            System.out.print(c);
            Thread.sleep(50);
        }
    }

    public static void startMenu() {
        System.out.println("Choose Your role: ");
        System.out.println("1: Bank employee");
        System.out.println("2: Bank customer");
        System.out.println("3: Exit");
    }

    public static void employeeMenu() {
        System.out.println("Choose action: ");
        System.out.println("1: Add customer");
        System.out.println("2: Show customer");
        System.out.println("3: Disable customer");
        System.out.println("4: Go back");
    }
    public static void customerMenu() {
        System.out.println("Choose bank service: ");
        System.out.println("1: Show account info");
        System.out.println("2: Deposit money");
        System.out.println("3: Withdraw money");
        System.out.println("4: Go back");
    }

}
