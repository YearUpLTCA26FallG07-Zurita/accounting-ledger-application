package com.pluralsight;

public class MenuTemplate {
    public static void method0() {
        boolean menuSwitch = true;
        while (menuSwitch) {
            System.out.println("Enter a value");
            int num = Console.promptForInt("");

            switch (num) {
                case 1 -> method1();
                case 2 -> method2();
                case 0 -> {
                    menuSwitch = false;
                    System.out.println("Goodbye");
                }
                default -> System.out.println("Enter a valid number");

            }
        }
    }

    private static void method1() {
        boolean menuSwitch = true;
        while (menuSwitch) {
            System.out.println("1. Enter another value");
            int num = Console.promptForInt("");
            switch (num) {
                case 1 -> submethod1();
                case 2 -> submethod2();
                case 0 -> menuSwitch = false;
            }
        }
    }

    private static void method2() {
        boolean menuSwitch = true;
        while (menuSwitch) {
            System.out.println("2. Enter another value");
            int num = Console.promptForInt("");
            switch (num) {
                case 1 -> submethod1();
                case 2 -> submethod2();
                case 0 -> menuSwitch = false;

            }

        }
    }

    private static void submethod1() {
        System.out.println("Submenu 1, close out.");
        int num = Console.promptForInt("");
        switch (num) {
            case 1:
                break;
        }
    }

    private static void submethod2() {
        System.out.println("Submenu 2, close out.");
        int num = Console.promptForInt("");
        switch (num) {
            case 1:
                break;
        }
    }
}
