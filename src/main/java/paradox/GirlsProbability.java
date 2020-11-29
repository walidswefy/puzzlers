package paradox;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @author walid.sewaify
 * @since 20-Mar-20
 * <p>
 * If you meet someone has has a daughter, the changes that he has two daughters are 33.33%
 */
public class GirlsProbability {
    public static void main(String[] args) {
        twoGirls();
    }

    private static void twoGirls() {
        int totalCount = 0;
        int twoGirls = 0;
        // city has n families
        for (int i = 0; i < 1000000; i++) {
            List<Boolean> randomFamily = Arrays.asList(randomGender(), randomGender());
            if (randomFamily.contains(Boolean.TRUE)) {
                totalCount++;
                if (randomFamily.stream().allMatch(Boolean.TRUE::equals)) {
                    twoGirls++;
                }
            }
        }

        System.out.println(twoGirls * 100.0 / totalCount);
    }

    private static boolean randomGender() {
        return new Random().nextBoolean();
    }
}
