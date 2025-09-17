package hexlet.code;

import java.util.Scanner;

/**
 * Main application class.
 * This class serves as the entry point for the application.
 */
public final class App {
    private static final Scanner SCANNER = new Scanner(System.in);

    /**
     * Private constructor to prevent instantiation.
     * This is a utility class with only static methods.
     */
    private App() {
        // Utility class constructor
    }

    /**
     * Main method - the entry point of the application.
     * Starts the program execution by greeting the user.
     *
     * @param args command line arguments passed to the application
     */
    public static void main(final String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            showGameMenu(scanner);
        } finally {
            scanner.close();
        }
    }

    /**
     * Displays the game menu and handles user selection.
     */
    private static void showGameMenu(Scanner scanner) {
        boolean exit = false;

        while (!exit) {
            System.out.println("Please enter the game number and press Enter.");
            System.out.println("1 - Greet");
            System.out.println("2 - EvenGame");
            System.out.println("0 - Exit");
            System.out.print("Your choice: ");

            int choice = getUserChoice(scanner);

            switch (choice) {
                case 0:
                    exit = true;
                    System.out.println("Goodbye!");
                    break;
                case 1:
                    Cli.greetUser();
                    break;
                case 2:
                    EvenGame.start();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }

            if (!exit) {
                System.out.println();
            }
        }
    }

    /**
     * Gets and validates user choice from input.
     *
     * @return the validated user choice
     */
    private static int getUserChoice(Scanner scanner) {
        while (true) {
            try {
                String input = scanner.nextLine().trim();
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.print("Please enter a valid number: ");
            }
        }
    }
}
