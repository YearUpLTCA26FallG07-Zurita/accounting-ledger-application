package com.pluralsight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class FileLogger {

    static DateTimeFormatter format = DateTimeFormatter.ofPattern("EEEE, MMMM dd, yyyy - hh:mm a z");
    static String dateTime = "(Report generated as of " + ZonedDateTime.now().format(format) + ")";
    static String header = """
            Medirealm Banking
            -~-~-~-~-~-~-~-~--~-~-~-~--~-~-~-~--~-~-~-~--~-~-~
            Where you and your finances meet in the middle.
            -~-~-~-~-~-~-~-~--~-~-~-~--~-~-~-~--~-~-~-~--~-~-~""";

    public static void accountDeposits() {

        try (BufferedWriter accountDeposits = new BufferedWriter(new FileWriter("account_deposits.txt"))) {
            accountDeposits.write(header);
            accountDeposits.newLine();
            accountDeposits.write(dateTime);
            accountDeposits.newLine();
            accountDeposits.newLine();
            accountDeposits.write("Deposits Report");
            accountDeposits.flush();
        } catch (IOException e) {
            System.out.println("Could not generate file.");

        }
    }
}
