package com.pluralsight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class AccountLedger {
    public static boolean closeMenu = false;
    public static boolean shouldConfirmExit = false;

    public static void main(String[] args) {
        menuMain();
    }

    public static void menuMain() {
        closeMenu = false;
        String menuTitle = "Main Menu";
        String textMainMenu = """
                What would you like to do today?
                
                D) Add Deposit
                P) Make A Payment
                L) Access Ledger
                
                X) Exit the Application
                """;
        System.out.println(textMainMenu);

        while (!closeMenu) {
            String option = Console.promptForString("Enter your command: ").toUpperCase().trim();
            switch (option) {
                case "D" -> menuAddDeposit();
                case "P" -> menuMakePayment();
                case "L" -> menuLedger();
                case "X" -> {
                    System.out.println("""
                            Leaving so soon?
                            
                            Y) Quit application
                            N) Return to main menu
                            """);
                    String confirm = Console.promptForString("Enter your command: ").toUpperCase().trim();

                    switch (confirm) {
                        case "Y" -> {
                            System.out.println("""
                                    --------------------------------------
                                    Thank you for using Medirealm Banking.
                                    
                                    Have a great and productive day!
                                    --------------------------------------
                                    """);
                            closeMenu = true;
                        }
                        case "N" -> System.out.println(textMainMenu);
                        default -> System.out.println("Enter Y or N only please.");
                    }
                }
                default -> System.out.println("Please enter one of the options listed above.");
            }
        }
    }

    private static boolean confirmExitScreen(boolean closeMenu) {
        if (!closeMenu) {
            return true;
        }
        System.out.println("""
                WARNING:
                You are about to lose unsaved data.
                Do you wish to continue?
                
                Y) Continue
                N) Return to screen""");
        do {
            String confirm = Console.promptForString("Enter your command: ").toUpperCase().trim();
            switch (confirm) {
                case "Y" -> {
                    shouldConfirmExit = false;
                }
                case "N" -> {
                }
                default -> System.out.println("Enter Y or N please.");
            }
        } while (true);
    }

    private static void menuAddDeposit() {
        double currentBalance = 560.00;
        double dailyDepositAmount = 1200;
        boolean reachedDailyLimit = false;

        if (dailyDepositAmount > 1000) {
            reachedDailyLimit = true;

        if (reachedDailyLimit == true) {
            System.out.println("""
                    ------------------------------------------------
                    Sorry, you've reached the daily deposit limit.
                    Come back tomorrow to start depositing again!
                    
                    Want an increase?
                    Contact us for more information: (555)925-8377
                    ------------------------------------------------""");
            closeMenu = true;
        }
        System.out.printf("""
                Your current balance is $%.2f.
                
                Enter an amount you would like to deposit, up to $500.00 per deposit.
                (Limit: $1,000.00 per day)
                """, currentBalance);

        while (!closeMenu) {
            double deposit = Console.promptForDouble("Enter your amount: ");
            while (deposit > 500) {
                System.out.println("""
                        Entered deposit exceeds max deposit limit.
                        Please enter an amount within the limit.
                        """);
            }
            dailyDepositAmount += deposit;
            currentBalance += deposit;


            }

        }
    }

    private static void menuMakePayment() {
    }

    private static void menuLedger() {
        System.out.println("""
                Account Ledger
                
                Select an option from below to get started.
                
                A) Display All Entries
                D) View Deposits
                P) View Payments
                R) View Financial Reports
                
                X) Return to main menu
                """);
        while (!closeMenu) {

            String option = Console.promptForString("Enter an option: ").toUpperCase().trim();
            switch (option) {
                case "A" -> submenuDisplayAllEntries();
                case "D" -> submenuViewDeposits();
                case "P" -> submenuViewPayments();
                case "R" -> submenuReports();
                case "X" -> closeMenu = true;
                default -> System.out.println("Enter one of the options above.");
            }
        }
    }

    private static void submenuDisplayAllEntries() {
    }

    private static void submenuViewDeposits() {
    }

    private static void submenuViewPayments() {
    }

    private static void submenuReports() {
    }
}