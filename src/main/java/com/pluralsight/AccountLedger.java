package com.pluralsight;

public class AccountLedger {
    public static boolean closeMenu = false;
    public static boolean shouldConfirmExit = false;

    public static void main(String[] args) {
        menuMain();
    }

    public static void menuMain() {
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
            String command = Console.promptForString("Enter your command: ").toLowerCase().trim();
            switch (command) {
                case "d" -> menuAddDeposit();
                case "p" -> menuMakePayment();
                case "l" -> menuLedger();
                case "x" -> {
                    System.out.println("""
                            Leaving so soon?
                            
                            Y) Quit application
                            N) Return to main menu""");
                    String exit = Console.promptForString("Enter your command: ").toLowerCase().trim();
                    ;
                    switch (exit) {
                        case "y" -> closeMenu = true;
                        case "n" -> System.out.println(textMainMenu);
                        default -> System.out.println("Enter Y or N only please.");
                    }
                }
                default -> System.out.println("Please enter one of the options listed above.");
            }
        }
    }

    private static boolean confirmExitScreen(boolean shouldConfirmExit) {
        if (!shouldConfirmExit) {
            return true;
        }
        System.out.println("""
                WARNING:
                You are about to lose unsaved data.
                Do you wish to continue?
                
                Y) Continue
                N) Return to screen""");
        do {
            String confirm = Console.promptForString("Enter your command: ").toLowerCase().trim();
            switch (confirm) {
                case "y" -> {
                    shouldConfirmExit = false;
                }
                case "n" -> {
                }
                default -> System.out.println("Enter Y or N please.");
            }
        } while (true);

    }


    private static void menuAddDeposit() {
        shouldConfirmExit = true;
        while (!closeMenu) {
            System.out.println("""
                    Test Menu: Deposit
                    
                    A) null
                    X) Return to main menu""");

            String command = Console.promptForString("Enter X: ").toLowerCase().trim();

            switch (command) {
                case "x" -> confirmExitScreen((shouldConfirmExit));
                case "a" -> System.out.println("null");
            }

        }
    }

    private static void menuMakePayment() {
    }

    private static void menuLedger() {
        System.out.println("test");
        int test = Console.promptForInt("Test: ");
    }
}
