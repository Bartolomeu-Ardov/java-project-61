package hexlet.code.games;

import hexlet.code.Engine;
import java.util.Random;

public class EvenGame {
    private static final String DESCRIPTION = "Answer 'yes' if the number is even, otherwise answer 'no'.";
    private static final Random RANDOM = new Random();

    public static void start() {
        Engine.runGame(DESCRIPTION, EvenGame::generateQuestionAndAnswer);
    }

    private static String[] generateQuestionAndAnswer() {
        int number = RANDOM.nextInt(100) + 1;
        String question = Integer.toString(number);
        String correctAnswer = (number % 2 == 0) ? "yes" : "no";
        return new String[]{question, correctAnswer};
    }
}
