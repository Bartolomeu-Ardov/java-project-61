package hexlet.code.games;

import hexlet.code.Engine;
import java.util.Random;

public class NOD {
    private static final String DESCRIPTION = "Find the greatest common divisor of given numbers.";
    private static final int MAX_NUMBER = 100;
    private static final Random RANDOM = new Random();

    public static void start() {
        Engine.runGame(DESCRIPTION, NOD::generateQuestionAndAnswer);
    }

    private static String[] generateQuestionAndAnswer() {
        int number1 = RANDOM.nextInt(MAX_NUMBER) + 1;
        int number2 = RANDOM.nextInt(MAX_NUMBER) + 1;

        String question = number1 + " " + number2;
        String answer = Integer.toString(calculateNOD(number1, number2));

        return new String[]{question, answer};
    }

    private static int calculateNOD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
