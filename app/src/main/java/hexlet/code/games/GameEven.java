package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class GameEven {
    public static final String DESCRIPTION = "Answer 'yes' if the number is even, otherwise answer 'no'.";
    public static final String[][] QUESTIONS_ANSWERS = new String[3][2];

    public static void startGame() {
        for (int i = 0; i < Engine.COUNT_ROUNDS; i++) {
            int number = Utils.generateNumber(100) + 1;
            QUESTIONS_ANSWERS[i][0] = String.valueOf(number);
            QUESTIONS_ANSWERS[i][1] = isEven(number) ? "yes" : "no";
        }
        Engine.runGame(DESCRIPTION, QUESTIONS_ANSWERS);
    }

    private static boolean isEven(int number) {
        return number % 2 == 0;
    }
}