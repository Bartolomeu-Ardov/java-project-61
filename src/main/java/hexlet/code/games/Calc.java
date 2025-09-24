package hexlet.code.games;

import hexlet.code.Engine;
import java.util.Random;

public class Calc {
    private static final String DESCRIPTION = "What is the result of the expression?";
    private static final Random RANDOM = new Random();

    public static void start() {
        Engine.run(DESCRIPTION, Calc::generateQuestionAndAnswer);
    }

    private static String[] generateQuestionAndAnswer() {
        int a = RANDOM.nextInt(20) + 1;
        int b = RANDOM.nextInt(20) + 1;
        char operator = generateOperator();

        String question = a + " " + operator + " " + b;
        String correctAnswer = Integer.toString(calculate(a, b, operator));

        return new String[]{question, correctAnswer};
    }

    private static char generateOperator() {
        char[] operators = {'+', '-', '*'};
        return operators[RANDOM.nextInt(operators.length)];
    }

    private static int calculate(int a, int b, char operator) {
        switch (operator) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            default: return 0;
        }
    }
}
