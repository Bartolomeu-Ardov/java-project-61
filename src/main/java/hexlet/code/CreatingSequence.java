package hexlet.code;

import java.util.Random;

public class CreatingSequence {
    private static final Random RANDOM = new Random();

    public static int generateNumber(int min, int max) {
        return RANDOM.nextInt(max - min + 1) + min;
    }
}
