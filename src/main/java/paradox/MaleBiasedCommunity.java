package paradox;

import java.util.Random;

/**
 * @author walid.sewaify
 * @since 30-JUN-12
 * <p>
 * In a community where parents keep delivering girls until they get a boy then they stop
 * population will still be around 50% male-to-female ratio.
 */
public class MaleBiasedCommunity {
    public static void main(String[] args) {
        int couples = 1000000;
        int boys = 0;
        int girls = 0;
        for (int i = 0; i < couples; i++) {
            while (randomGender()) {
                girls++;
            }
            boys++;
        }
        System.out.println("boys = " + boys);
        System.out.println("girls = " + girls);
    }

    private static boolean randomGender() {
        return new Random().nextBoolean();
    }

}
