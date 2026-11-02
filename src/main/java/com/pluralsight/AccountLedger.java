package com.pluralsight;

public class AccountLedger {
    public static void main(String[] args) {

        Menu.menuMain("""
                What would you like to do today?

                D) Add Deposit
                P) Make A Payment
                L) Access Ledger

                X) Exit the Application\n""", true);
    }

    private static void menuAddDeposit() {

    }

    private static void menuMakePayment() {
    }

    /**
     * Ledger Screen - menu that opens up the Ledger. Lets the user view all transaction entries. Also lets the user view only incoming or outgoing transactions. Has a submenu that opens a Reports feature, with a more profound search system.
     */
    private static void menuLedger() {
            System.out.println("""
                Ledger Screen

                Welcome to the Ledger.
                What would you like to access?

                A) Display All Entries
                D) Display Deposits Only
                P) Display Payments Only
                R) View Reports

                X) Return to Main Menu
                """);

        String command = Console.promptForString("Enter your command ").toLowerCase();

        switch (command) {
            case "a" -> submenuLedgerViewAll();
            //case "d" -> submenuLedgerViewDeposits();
            //case "p" -> submenuLedgerViewPayments();
            //case "r" -> submenuLedgerReports();
            //case "x" -> processExitScreen();
        }

    }

    private static void submenuLedgerViewAll() {
        System.out.println("test");
    }

//    private static void processExitScreen() {
//        System.out.println("""
//                Are you sure you want to leave this screen?
//
//                UNSAVED DATA WILL BE LOST!""");
//
//        String confirmation = Console.promptForString("Yes / No : ").toLowerCase().trim();
//        }
    }