package paradox;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * @author walid.sewaify
 * @since 01/07/12
 *
 * <p> Chances of two players in a soccer match has the same birthday is about 50%
 * https://en.wikipedia.org/wiki/Birthday_problem
 */
public class BirthdayProblem {

    public static final Random RANDOM = new Random();

    public static void main(String[] args) {

        int collision = 0;
        int attempts = 1000;
        int numberOfPeople = 23;

        for (int i = 0; i < attempts; i++) {
            int[] numbers = new int[numberOfPeople];
            Set<Integer> days = new HashSet<Integer>();
            for (int j = 0; j < numbers.length; j++) {
                int day = RANDOM.nextInt(365) + 1;
                if (days.contains(day)) {
                    collision++;
                    break;
                }
                days.add(day);
            }
        }
        System.out.println(collision * 100.0 / attempts);
    }
}
