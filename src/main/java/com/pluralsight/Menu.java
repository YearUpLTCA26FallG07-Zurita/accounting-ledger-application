package com.pluralsight;


public class Menu {

    public static boolean closeMenu = false;
    public static boolean shouldConfirmExit = false;

    public static void menuMain() {
        shouldConfirmExit = true;
        while (!closeMenu) {
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
                case "d" -> menuAddDeposit();
                case "p" -> menuMakePayment();
                case "l" -> menuLedger();
                case "x" -> {
                    System.out.println("""
                            Leaving so soon?
                            
                            Y) Quit application
                            N) Return to main menu""");
                    String exit = Console.promptForString("Enter your command: ").toLowerCase().trim();;
                    switch (exit) {
                        case "y" -> closeMenu = true;
                        case "n" -> {}
                    }
                }
                default -> System.out.println("Please enter one of the options listed above.");
            }
        }
    }
    private static void processExitScreen(boolean shouldConfirmExit) {
        if (!shouldConfirmExit) {
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
                    return;
            }
        } else {
            return;
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
