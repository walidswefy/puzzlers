package paradox;

import java.util.Random;

/**
 * @author walid.sewaify
 * @since 25-Nov-08
 * <p>
 * probabilistic approach for estimating PI values
 * https://en.wikipedia.org/wiki/Monte_Carlo_method
 */
public class PiMonteCarlo {
    private static final Random random = new Random();

    public static void main(String[] args) {
        int insideCircle = 0;
        int insideSquare = 0;
        int radius = 10000;
        for (int i = 0; i < 10000000; i++) {
            int x = random.nextInt(radius + 1);
            int y = random.nextInt(radius + 1);
            // circle x^2 + y^2 = r^2
            if (x * x + y * y <= radius * radius) {
                insideCircle++;
            }
            insideSquare++;
        }
        System.out.println(insideCircle * 4.0 / insideSquare);
    }
}
