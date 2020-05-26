package challenges;

import java.util.Arrays;

public class MarkAndToys {
    public static void main(String[] args) {
        System.out.println(maximumToys(new int[]{1, 12, 5, 111, 200, 1000, 10}, 50)); // 4
    }

    static int maximumToys(int[] prices, int k) {
        Arrays.sort(prices);

        int numToys = 0;
        for (int toyPrice : prices) {
            if (toyPrice > k) break;
            numToys++;
            k -= toyPrice;
        }

        return numToys;
    }
}
