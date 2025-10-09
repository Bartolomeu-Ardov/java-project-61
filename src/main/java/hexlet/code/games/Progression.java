package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.CreatingSequence;

public class Progression {
    private static final String DESCRIPTION = "What number is missing in the progression?";
    private static final int MIN_LENGTH = 5;
    private static final int MAX_LENGTH = 10;
    private static final int MIN_START = 1;
    private static final int MAX_START = 20;
    private static final int MIN_STEP = 1;
    private static final int MAX_STEP = 10;

    public static void start() {
        java.util.function.Supplier<String[]> questionGenerator = Progression::generateQuestionAndAnswer;
        Engine.runGame(DESCRIPTION, questionGenerator);
    }

    private static String[] generateQuestionAndAnswer() {
        int length = CreatingSequence.generateNumber(MIN_LENGTH, MAX_LENGTH);
        int start = CreatingSequence.generateNumber(MIN_START, MAX_START);
        int step = CreatingSequence.generateNumber(MIN_STEP, MAX_STEP);
        int hiddenIndex = CreatingSequence.generateNumber(0, length - 1);

        String[] progression = generateProgression(start, step, length);
        String answer = progression[hiddenIndex];
        progression[hiddenIndex] = "..";

        String question = String.join(" ", progression);

        return new String[]{question, answer};
    }

    private static String[] generateProgression(int start, int step, int length) {
        String[] progression = new String[length];

        for (int i = 0; i < length; i++) {
            int currentElement = start + i * step;
            progression[i] = String.valueOf(currentElement);
        }

        return progression;
    }
}
