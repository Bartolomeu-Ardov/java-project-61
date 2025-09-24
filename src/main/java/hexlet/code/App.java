package hexlet.code;

import hexlet.code.games.EvenGame;
import hexlet.code.games.Calc;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            showMenu();
            int choice = getChoice(scanner);

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
                case 3:
                    Calc.start();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }

            if (!exit) {
                System.out.println();
            }
        }

        scanner.close();
    }

    private static void showMenu() {
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet");
        System.out.println("2 - Even");
        System.out.println("3 - Calc");
        System.out.println("0 - Exit");
        System.out.print("Your choice: ");
    }

    private static int getChoice(Scanner scanner) {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Please enter a valid number: ");
            }
        }
    }
}
