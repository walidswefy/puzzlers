package paradox;

import java.util.Random;

/**
 * @author walid.sewaify
 * @since 22-Nov-20
 * <p>
 * French roulette (red-black) changes of winning
 */
public class FrenchRoulette {
    public static void main(String[] args) {
        int wins = 0;
        int numberOfGames = 10000;
        for (int i = 0; i < numberOfGames; i++) {
            if (play(new Random().nextBoolean())) {
                wins++;
            }
        }
        System.out.println("win rate is: " + wins * 100.0 / numberOfGames);

    }

    static boolean play(boolean black) {
        int slot = new Random().nextInt(37) + 1;
        if (slot == 19) return false;
        return slot % 2 == 0;
    }
}
