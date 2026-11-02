package com.pluralsight;

public class AccountLedger {
    public static void main(String[] args) {
        menuMain();
    }
    public static void menuMain() {
        String textMainMenu = """
                What would you like to do today?
                 
                D) Add Deposit
                P) Make A Payment
                L) Access Ledger
                
                X) Exit the Application\n""";

        System.out.println(textMainMenu);
        String command = Console.promptForString("Enter your command ").toUpperCase();

        switch (command) {
            case "D" -> menuAddDeposit();
            case "P" -> menuMakePayment();
            case "L" -> menuLedger();
            case "X" -> processExitScreen();
            default -> System.out.println("Please enter one of the options listed above.");

        }

    }

    private static void menuAddDeposit() {

    }

    private static void menuMakePayment() {
    }

    private static void menuLedger() {
        System.out.println("""
                Ledger Screen""");
    }

    private static void processExitScreen() {
    }
}
