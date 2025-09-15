package hexlet.code;

import java.util.Scanner;
/**
 * Command Line Interface utility class.
 */
public final class Cli {
    private Cli() {

    }

    /**
     * Method for interacting with user via command line.
     */
    public static void greetUser() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String userName = scanner.nextLine();

        System.out.println("Hello, " + userName + "!");

    }
}
