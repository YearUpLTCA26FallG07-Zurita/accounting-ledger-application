package com.pluralsight;

public class Menu {

    static String menuText;
    static String menuTitle;
    static boolean confirmExit;
    /**
     * Constructor for the Menu class.
     * @param menuText
     * Contains the menu text that is visible in the main program without the rest of the code.
     * @param confirmExit
     * Determines whether a screen has information that can be lost from selecting another menu. TRUE displays a warning with a needed confirmation.
     */
    Menu(String menuText, String menuTitle, boolean confirmExit) {
        this.menuText = menuText;
        this.confirmExit = confirmExit;
    }

    public static void menuMain(String menuText, boolean confirmExit) {

        System.out.println(menuText);

        String command = Console.promptForString("Enter your command ").toLowerCase().trim();
        System.out.println(command);

        switch (command) {
            //case "D" -> menuAddDeposit();
            //case "P" -> menuMakePayment();
            //case "L" -> menuLedger();
            case "x" -> processExitScreen(!confirmExit);
            default -> System.out.println("Please enter one of the options listed above.");
        }
    }
    public static void processExitScreen(boolean confirmExit) {
        String menuTitle = "";
        if (confirmExit) {
            System.out.println("""
                    Data entered that hasn't been saved will be lost.

                    Do you wish to continue?
                    
                    Y) Continue to previous menu
                    N) Cancel and return to""");

            String confirmation = Console.promptForString("Enter your command: ").toLowerCase().trim();

            switch (confirmation) {
                case "no":
                    Menu.menuMain("""
                What would you like to do today?

                D) Add Deposit
                P) Make A Payment
                L) Access Ledger

                X) Exit the Application\n""", false);
                    return;
                case "":


            }
        } else {
            System.out.println("false test");
        }
    }
}

