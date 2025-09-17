package hexlet.code;

import java.util.Random;
import java.util.Scanner;

public final class EvenGame {
    private static final int REQUIRED_CORRECT_ANSWERS = 3;
    private static final Random RANDOM = new Random();

    /**
     * Private constructor to prevent instantiation.
     */


    /**
     * Starts the Even game.
     */
    public static void start() {
        Scanner scanner = new Scanner(System.in);

        // Используем существующий метод greetUser из Cli
        Cli.greetUser();

        // Получаем имя пользователя для персонализированных сообщений
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

        int correctAnswers = 0;

        while (correctAnswers < REQUIRED_CORRECT_ANSWERS) {
            int number = generateNumber();
            System.out.println("Question: " + number);
            System.out.print("Your answer: ");

            String userAnswer = scanner.nextLine().trim().toLowerCase();
            String correctAnswer = isEven(number) ? "yes" : "no";

            if (!isValidAnswer(userAnswer)) {
                System.out.println("'" + userAnswer + "' is wrong answer ;(. Correct answer was '" + correctAnswer + "'.");
                System.out.println("Let's try again!");
                scanner.close();
                return;
            }

            if (!userAnswer.equals(correctAnswer)) {
                System.out.println("'" + userAnswer + "' is wrong answer ;(. Correct answer was '" + correctAnswer + "'.");
                System.out.println("Let's try again!");
                scanner.close();
                return;
            }

            System.out.println("Correct!");
            correctAnswers++;
        }

        System.out.println("Congratulations!");
        scanner.close();
    }

    private static int generateNumber() {
        return RANDOM.nextInt(100) + 1;
    }

    private static boolean isEven(int number) {
        return number % 2 == 0;
    }

    private static boolean isValidAnswer(String answer) {
        return answer.equals("yes") || answer.equals("no");
    }
}
