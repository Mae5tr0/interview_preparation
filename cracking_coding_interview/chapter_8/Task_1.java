package chapter_8;

import java.util.Arrays;

/**
 * Triple Step
 *
 * A child is running up a staircase with n steps and can hop either 1 step, 2 steps, or 3 steps at a time.
 * Implement a method to count how many possible ways the child can run up the stairs.
 *
 */
public class Task_1 {

    public static void main(String[] args) {
        System.out.println(countWays(1));
        System.out.println(countWays(2));
        System.out.println(countWays(3));
        System.out.println(countWays(10));
    }

    private static int countWays(int n) {
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);

        return countWays(memo, n);
    }


    private static int countWays(int[] memo, int n) {
        if (n < 0) return 0;
        if (memo[n] > -1) return memo[n];
        if (n == 0) return 1;

        memo[n] = countWays(memo, n - 1 ) +
                countWays(memo, n - 2) +
                countWays(memo, n - 3);

        return memo[n];
    }
}