package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

import java.util.Random;

public class GameProgression {
    public static String description = "What number is missing in the progression?";
    public static String[][] questionsAndAnswers = new String[3][2];
    public static int delta;
    public static int hiddenIndex;
    public static int firstNumber;

    public static void startGame() {
        Random random = new Random();
        for (int i = 0; i < Engine.COUNT_ROUNDS; i++) {
            int[] progression = generateProgression();
            hiddenIndex = random.nextInt(progression.length);
            int hidden = progression[hiddenIndex];
            questionsAndAnswers[i][0] = buildQuestion(progression);
            questionsAndAnswers[i][1] = String.valueOf(hidden);
        }
        Engine.runGame(description, questionsAndAnswers);
    }

    private static int[] generateProgression() {
        int length = Utils.generateNumber(5) + 6;
        int[] progression = new int[length];
        firstNumber = Utils.generateNumber(11);
        delta = Utils.generateNumber(3) + 1;
        for (int i = 0; i < length; i++) {
            progression[i] = firstNumber + i * delta;
        }
        return progression;
    }

    private static String buildQuestion(int[] progression) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < progression.length; i++) {
            builder.append(i == hiddenIndex ? ".." : firstNumber + i * delta);
            if (i != progression.length - 1) {
                builder.append(" ");
            }
        }
        return builder.toString();
    }
}
