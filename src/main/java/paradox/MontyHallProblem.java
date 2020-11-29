package paradox;

import java.util.Random;
import java.util.stream.IntStream;

/**
 * @author walid.sewaify
 * @since 07-Jan-20
 * <p>
 * If you were to choose at random between 3 boxes the one has that a treasure. You choose one, and the host excludes
 * one of the empty boxes, and asks you to either stick to your box or switch to the other one. Should you change your mind?
 * Answer: changing to other box gives you 2/3 chances of winning, while holding on your box gives you only 1/3 chances.
 * <p>
 * Similar problem -> https://en.wikipedia.org/wiki/Three_Prisoners_problem
 */
public class MontyHallProblem {
    public static final int SIZE = 3;
    public static final int totalGamesCount = 1000000;

    public static void main(String[] args) {
        final boolean switchChoice = true;
        int winCount = 0;
        for (int i = 0; i < totalGamesCount; i++) {
            if (isWinner(switchChoice)) {
                winCount++;
            }
        }
        System.out.println(winCount * 1.0 / totalGamesCount);
    }

    private static boolean isWinner(boolean switchChoice) {
        int[] options = new int[SIZE];
        options[randomBox()] = 1;
        int selection = randomBox();
        if (!switchChoice) return options[selection] == 1;
        return IntStream.range(0, SIZE).boxed().filter(box -> box != selection && options[box] != 1).count() == 1;
    }

    private static int randomBox() {
        return new Random().nextInt(SIZE);
    }

}
