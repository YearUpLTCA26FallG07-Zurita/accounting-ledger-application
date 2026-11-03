package com.pluralsight;


public class Menu {

    public static void menuMain() {
        String menuTitle = "Main Menu";

        System.out.println("""
                What would you like to do today?
                
                D) Add Deposit
                P) Make A Payment
                L) Access Ledger
                
                X) Exit the Application\n""");

        String command = Console.promptForString("Enter your command ").toLowerCase().trim();
        System.out.println(command);

        switch (command) {
            case "d":
                menuAddDeposit();
                return;
            case "p":
                menuMakePayment();
                return;
            case "l":
                menuLedger();
                return;
            case "x":
                processExitScreen(true);
                return;
            default:
                System.out.println("Please enter one of the options listed above.");
        }
    }
    private static void processExitScreen(boolean confirmExit) {
        if (confirmExit) {
            System.out.println("""
                    WARNING:
                    You are about to lose unsaved data.
                    Do you wish to continue?
                    
                    Y) Continue
                    N) Return to screen""");

            String command = Console.promptForString("Enter your command: ").toLowerCase().trim();

            switch (command) {
                case "y":
                    menuMain();
                    return;
                case "n":
                    processExitScreen(confirmExit);
                    return;
            }
        }
    }

    private static void menuAddDeposit() {
    }

    private static void menuMakePayment() {
    }

    private static void menuLedger() {
        System.out.println("test");
        int test = Console.promptForInt("Test: ");

        if (test == 1) {
            processExitScreen(true);
        }
    }
}
