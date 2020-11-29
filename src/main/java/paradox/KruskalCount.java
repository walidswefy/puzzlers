package paradox;

import algorithms.MajorityElement;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author walid.sewaify
 * @since 01-Mar-20
 * <p>
 * https://faculty.uml.edu/rmontenegro/research/kruskal_count/kruskal.html
 */
public class KruskalCount {
    public static void main(String[] args) {
        IntStream numberCards = IntStream.rangeClosed(1, 10);
        IntStream specialCards = Stream.of("A", "K", "J", "Q").mapToInt(c -> "A".equals(c) ? 1 : 5);
        // add each card four times
        IntStream deckOfCards = IntStream.concat(numberCards, specialCards).flatMap(n -> IntStream.range(0, 4).map(x -> n));
        List<Integer> cards = deckOfCards.boxed().collect(Collectors.toList());
        Collections.shuffle(cards);

        int[] gameResults = new int[100];
        for (int i = 0; i < gameResults.length; i++) {
            gameResults[i] = play(cards); // gonna hit majority elem 85+%
        }

        int majority = MajorityElement.majority(gameResults);
        long countOfMajority = Arrays.stream(gameResults).filter((n -> n == majority)).count();
        System.out.println("Percentage of majority element: " + countOfMajority * 100.0 / gameResults.length);

    }

    private static Integer play(List<Integer> cards) {
        // random card from first row
        int curr = new Random().nextInt(10);
        while (true) {
            int card = cards.get(curr);
            if (curr + card >= cards.size()) break;
            curr += card;
        }
        return cards.get(curr);
    }

}
