package hexlet.code;

import java.util.Scanner;

public class Engine {
    private static final int ROUNDS_COUNT = 3;

    /**
     * Runs the game with a question generator.
     * @param gameDescription Description of the game rules
     * @param questionGenerator Function that generates [question, answer] for each round
     */
    public static void run(String gameDescription,
                           java.util.function.Supplier<String[]> questionGenerator) {
        Scanner scanner = new Scanner(System.in);

        Cli.greetUser();

        System.out.println(gameDescription);

        for (int i = 0; i < ROUNDS_COUNT; i++) {
            String[] questionAndAnswer = questionGenerator.get();
            String question = questionAndAnswer[0];
            String correctAnswer = questionAndAnswer[1];

            System.out.println("Question: " + question);
            System.out.print("Your answer: ");
            String userAnswer = scanner.nextLine().trim();

            if (userAnswer.equals(correctAnswer)) {
                System.out.println("Correct!");
            } else {
                System.out.println("'" + userAnswer + "' is wrong answer ;(. Correct answer was '" + correctAnswer + "'.");
                System.out.println("Let's try again!");
                return;
            }
        }

        System.out.println("Congratulations!");
    }
}
