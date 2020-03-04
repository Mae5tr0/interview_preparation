package problems;

/**
 * (Climbing Stairs)[https://leetcode.com/problems/climbing-stairs/]
 *
 * You are climbing a stair case. It takes n steps to reach to the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 */
public class Problem_70 {
    public static void main(String[] args) {
        System.out.println(climbStairs(3)); // 3
    }

    // recursive My solution
//    static public int climbStairs(int n) {
//        int[] memo = new int[n + 1];
//
//        return climbStairs(n, memo);
//    }
//
//    static int climbStairs(int n, int[] memo) {
//        if (n == 0) return 1;
//        if (n < 0) return 0;
//
//        if (memo[n] > 0) return memo[n];
//        memo[n] = climbStairs(n - 1, memo) + climbStairs(n - 2, memo);
//        return memo[n];
//    }

    // iterative DP
    static int climbStairs(int n) {
        if (n == 1) return 1;

        int first = 1;
        int second = 2;
        for (int i = 3; i <= n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }

        return second;
    }
}
