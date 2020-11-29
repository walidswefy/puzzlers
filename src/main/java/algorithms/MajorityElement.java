package algorithms;

/**
 * @author Walid.Elswaify
 * @since Dec 5, 2010
 * <p>
 * Find element that appears most in the array
 * O(n) time complexity, O(1) space complexity
 */
public class MajorityElement {
    public static void main(String[] args) {
        System.out.println(majority(new int[]{1, 0, 1, 1, 0}));
    }

    public static int majority(int[] list) {
        int count = 1;
        int majorityElement = list[0];
        for (int index = 1; index < list.length; index++) {
            if (majorityElement != list[index]) {
                if (count == 0) {
                    majorityElement = list[index];
                    count++;
                } else {
                    count--;
                }
            } else {
                count++;
            }
        }

        return majorityElement;
    }
}
