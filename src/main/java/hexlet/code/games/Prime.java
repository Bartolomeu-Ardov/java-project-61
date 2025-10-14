package hexlet.code.games;

import hexlet.code.Engine;
import java.util.Random;

public class Prime {
    private static final String DESCRIPTION = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    private static final int MAX_NUMBER = 100;
    private static final Random RANDOM = new Random();

    public static void start() {
        Engine.runGame(DESCRIPTION, Prime::generateRound);
    }

    private static String[] generateRound() {
        int number = generateNumber(1, MAX_NUMBER);
        String question = Integer.toString(number);
        String answer = isPrime(number) ? "yes" : "no";

        return new String[] {question, answer};
    }

    private static int generateNumber(int min, int max) {
        return RANDOM.nextInt(max - min + 1) + min;
    }

    private static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
}
