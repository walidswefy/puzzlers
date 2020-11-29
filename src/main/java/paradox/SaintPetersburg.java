package paradox;

import java.util.Random;

/**
 * @author walid.sewaify
 * @since 13-Jan-20
 * <p>
 * https://en.wikipedia.org/wiki/St._Petersburg_paradox
 */
public class SaintPetersburg {

    public static final Random RANDOM = new Random();

    public static void main(String[] args) {
        int gameCost = 25;
        int maxGain = 0;
        long total = 0;
        int numberOfGames = 1000;
        for (int i = 0; i < numberOfGames; i++) {
            total -= gameCost;
            int win = win();
            total += win;
            maxGain = Math.max(maxGain, win);
        }
        System.out.println("highest gain: $" + maxGain);
        System.out.println("you gain/lose : $" + total);
    }

    // always win (at least win 2$)
    static int win() {
        int win = 2;
        while (RANDOM.nextBoolean()) {
            win *= 2;
        }
        return win;
    }

}
