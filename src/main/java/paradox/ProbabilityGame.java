package paradox;

import java.util.Random;

/**
 * @author walid.sewaify
 * @since 27-Nov-20
 * <p>
 * Question: If there's a 15% probability to win 100K V.S 1.5% probability to win 100M, which one you choose?
 * Conclusion: if you get this chance for one time, go for 15% chances
 * if you play this games 45 times or more, change your strategy to 1.5%
 */
public class ProbabilityGame {
    private static final Random RANDOM = new Random();
    private static final int ITERATIONS = 10000000;

    public static void main(String[] args) {
        for (int trials = 1; trials <= 100; trials++) {
            simulate(trials);
        }
    }

    private static void simulate(int trials) {
        int riskTakerWins = 0;
        int conservativeWins = 0;
        for (int i = 0; i < ITERATIONS; i++) {
            int winningStrategy = compareStrategy(trials);
            if (winningStrategy > 0) {
                riskTakerWins++;
            } else if (winningStrategy < 0) {
                conservativeWins++;
            }
        }
        System.out.printf("%d\t%d\t%d\n", trials, riskTakerWins, conservativeWins);
    }

    private static int compareStrategy(int trials) {
        long riskTaker = 0L;
        long conservative = 0L;
        for (int i = 0; i < trials; i++) {
            int random = RANDOM.nextInt(1000);
            if (random < 15) {
                riskTaker += 100000000;
            }
            if (random < 150) {
                conservative += 100000;
            }
        }
        return Long.compare(riskTaker, conservative);
    }
}
