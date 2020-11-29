package paradox;

import java.util.Arrays;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * @author walid.sewaify
 * @since 29-Jan-20
 * <p>
 * Given positions of ladders, print average number of moves to compete the game
 */
public class LaddersSnakes {

    public static final Random RANDOM = new Random();
    // pair[0]= starting position & pair[1] = ending position
    private static final int[][] ladders = {{4, 16}, {12, 33}, {18, 22}, {26, 37}, {42, 61}, {49, 51}, {55, 74}, {82, 98}, {85, 95}, {88, 92}};
    private static final int[][] snakes = {{21, 3}, {24, 7}, {35, 9}, {50, 11}, {53, 15}, {60, 23}, {75, 44}, {89, 48}, {93, 25}, {97, 65}, {99, 58}};
    private static final Map<Integer, Integer> laddersMap = arrayToMap(ladders);
    private static final Map<Integer, Integer> snakesMap = arrayToMap(snakes);

    public static void main(String[] args) {
        long totalMoves = 0;
        int shortestGames = Integer.MAX_VALUE;
        int totalGames = 1000000;
        for (int i = 0; i < totalGames; i++) {
            int currentMoves = playGame();
            shortestGames = Math.min(shortestGames, currentMoves);
            totalMoves += currentMoves;
        }
        System.out.println("average moves : " + totalMoves / totalGames);
        System.out.printf("fastest win in %d moves", shortestGames);
    }

    private static int playGame() {
        int p1 = 0;
        int p2 = 0;
        int countMoves = 0;
        while (p1 != 100 && p2 != 100) {
            p1 = play(p1);
            p2 = play(p2);
            countMoves++;
        }
        return countMoves;
    }

    private static int play(int pos) {
        // roll dice
        int next = pos + RANDOM.nextInt(6) + 1;
        if (next > 100) return pos;
        next = laddersMap.getOrDefault(next, next);
        next = snakesMap.getOrDefault(next, next);
        return next;
    }

    private static Map<Integer, Integer> arrayToMap(int[][] arrayOfPairs) {
        return Arrays.stream(arrayOfPairs).collect(Collectors.toMap(pair -> pair[0], pair -> pair[1]));
    }
}
