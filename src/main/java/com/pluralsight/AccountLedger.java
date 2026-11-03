package com.pluralsight;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;

public class AccountLedger {
    static String[] convertedReport;
    public static HashMap<LocalDate, Transaction> reportTransactions = new HashMap<LocalDate, Transaction>();
    public static boolean closeMenu = false;
    public static boolean shouldConfirmExit = false;
    public static String textMainMenu = """
            What would you like to do today?
            
            D) Add Deposit
            P) Make A Payment
            L) Access Ledger
            
            X) Exit the Application
            """;

    public static void main(String[] args) throws InterruptedException, IOException {

        try {
            DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("hh:mm a", Locale.US);
            BufferedReader reader = new BufferedReader(new FileReader("transactions.csv"));

            reader.readLine();

            String input;

            while ((input = reader.readLine()) != null) {
                convertedReport = input.split("\\|");
                LocalDate date = LocalDate.parse(convertedReport[0]);
                LocalTime time = LocalTime.parse(convertedReport[1], timeFormat);
                String description = convertedReport[2];
                String vendor = convertedReport[3];
                double amount = Double.parseDouble(convertedReport[4]);
                Transaction newTransaction = new Transaction(date, time, description, vendor, amount);
                reportTransactions.put(date, newTransaction);

            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        menuMain();
    }

    public static void menuMain() throws InterruptedException, IOException {
        closeMenu = false;
        String menuTitle = "Main Menu";

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

    private static void menuAddDeposit() throws InterruptedException, IOException {
        double currentBalance = 540.00;
        double dailyDepositAmount = 0;
        closeMenu = false;

        try (BufferedWriter accountDeposits = new BufferedWriter(new FileWriter("account_deposits.txt", true))) {
            accountDeposits.write("Current Balance:");
            accountDeposits.newLine();
            String depositBalance = String.format("Deposit Amount: $%.2f", currentBalance);
            accountDeposits.write(depositBalance);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if (dailyDepositAmount > 1000) {
            System.out.println("""
                    ------------------------------------------------
                    Sorry, you've reached the daily deposit limit.
                    Come back tomorrow to start depositing again!
                    
                    Want an increase?
                    Contact us for more information: (555) 925-8377
                    ------------------------------------------------""");
            Thread.sleep(3000);
            System.out.println(textMainMenu);
        }

            System.out.printf("""
                    Your current balance is $%.2f.
                    
                    Enter an amount you would like to deposit, up to $500.00 per deposit.
                    (Limit: $1,000.00 per day)
                    """, currentBalance);
        while (!closeMenu) {

            double deposit = Console.promptForDouble("Enter your amount: ");

            if (deposit > 500) {
                System.out.println("""
                        Entered deposit exceeds max deposit limit.
                        Please enter an amount within the limit.
                        """);
            } else {
                currentBalance += deposit;
                dailyDepositAmount += deposit;

                try (BufferedWriter accountBalance = new BufferedWriter(new FileWriter("account_balance.txt", true))) {
                    accountBalance.write(String.valueOf(currentBalance));

                }

                System.out.printf("""
                        Deposited $%.2f into your account.
                        
                        Make another deposit?
                        
                        Y) Yes
                        N) No, return to main menu
                        """, deposit);

                String option = Console.promptForString("Enter your option: ").toUpperCase().trim();

                switch (option) {
                    case "Y" -> {
                        return;
                    }
                    case "N" -> closeMenu = true;
                }

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
        System.out.println("");
        for (Transaction listing : reportTransactions.values()) {
            System.out.printf("%s | %s | %-30s | %-25s | $%.2f%n",
                    listing.getDate(),
                    listing.getTime(),
                    listing.getDescription(),
                    listing.getVendor(),
                    listing.getAmount());
        }
    }

    private static void submenuViewDeposits() {
    }

    private static void submenuViewPayments() {
    }

    private static void submenuReports() {
    }
}

