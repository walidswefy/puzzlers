package paradox;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author walid.sewaify
 * @since 06-Jan-20
 * https://www.youtube.com/watch?v=L8GsxU6Zt0E
 */
public class DownUnderDeal {
    public static void main(String[] args) {
        easyVersion();
        vSauceVersion();
    }

    private static void easyVersion() {
        int setSize = 12;
        List<Integer> cards = IntStream.rangeClosed(1, setSize).boxed().collect(Collectors.toList());
        Collections.shuffle(cards);
        System.out.println("top is : " + cards.get(0));

        for (int i = 0; i < "AustralianShuffle".length(); i++) {
            moveTopToBack(cards);
        }
        while (cards.size() > 1) {
            cards.remove(0);
            moveTopToBack(cards);
        }

        System.out.println("The remaining card is : " + cards.get(0));
    }

    private static void vSauceVersion() {
        int setSize = 1050;
        List<Integer> cards = IntStream.rangeClosed(1, setSize).boxed().collect(Collectors.toList());
        Collections.shuffle(cards);
        int it = 1;
        while (it < setSize) {
            it <<= 1;
        }
        int cardPosition = 2 * (setSize - (it >> 1));
        System.out.println("The remaining card should be : " + cards.get(cardPosition - 1));
        while (cards.size() > 1) {
            cards.remove(0);
            moveTopToBack(cards);
        }
        System.out.println("The remaining card is : " + cards.get(0));
    }

    private static void moveTopToBack(List<Integer> set) {
        int top = set.remove(0);
        set.add(top);
    }
}

