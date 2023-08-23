package paradox;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * https://en.wikipedia.org/wiki/100_prisoners_problem
 */
public class HundredPrisonersProblem {
    static List<Integer> boxes = IntStream.range(0, 100).boxed().collect(Collectors.toList());

    public static void main(String[] args) {
        int success = 0;
        for (int i = 0; i < 10000; i++) {
            Collections.shuffle(boxes);
            if (boxes.stream().allMatch(n -> runPrisoner(n))) {
                success++;
            }
        }
        System.out.println(success * 100.0 / 10000);
    }

    private static boolean runPrisoner(final int prisonerNumber) {
        int openBoxes = 0;
        int currentBox = prisonerNumber;
        while (openBoxes < 50) {
            openBoxes++;
            Integer boxKey = boxes.get(currentBox);
            if (boxKey == prisonerNumber) {
                return true;
            }
            currentBox = boxKey;
        }
        return false;
    }
}
