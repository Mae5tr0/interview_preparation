package problems;

/**
 * (House Robber)[https://leetcode.com/problems/house-robber/]
 *
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed,
 * the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and
 * it will automatically contact the police if two adjacent houses were broken into on the same night.
 *
 * Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount
 * of money you can rob tonight without alerting the police.
 *
 */
public class Problem_198 {
    public static void main(String[] args) {
        System.out.println(rob(new int[] {1, 2, 3, 1 })); // 4
        System.out.println(rob(new int[] {3, 2, 2, 5, 1})); // 8
    }

    // My first solution
//    static public int rob(int[] nums) {
//        int[] memo = new int[nums.length];
//        Arrays.fill(memo, -1);
//
//        return Math.max(robMax(0, nums, memo), robMax(1, nums, memo));
//    }
//
//    static public int robMax(int pos, int[] nums, int[] memo) {
//        if (pos >= nums.length) return 0;
//
//        if (memo[pos] > -1) return memo[pos];
//
//        memo[pos] = nums[pos] + Math.max(robMax(pos + 2, nums, memo), robMax(pos + 3, nums, memo));
//
//        return memo[pos];
//    }

    // Optimized DP
//     static public int rob(int[] nums) {
//        if (nums == null || nums.length == 0) return 0;
//
//        int[] memo = new int[nums.length];
//        Arrays.fill(memo, -1);
//
//        return rob(0, nums, memo);
//     }
//
//     static public int rob(int i, int[] nums, int[] memo) {
//        if (i >= nums.length) return 0;
//        if (memo[i] > -1) return memo[i];
//
//        memo[i] = Math.max(nums[i] + rob(i + 2, nums, memo), rob(i + 1, nums, memo));
//
//        return memo[i];
//     }

     static public int rob(int[] nums) {
         if (nums == null || nums.length == 0) return 0;
         if (nums.length == 1) return nums[0];
         if (nums.length == 2) return Math.max(nums[0], nums[1]);

         int prev2 = nums[0];
         int prev1 = Math.max(nums[1], nums[0]);
         int curr = 0;

         for (int i = 2; i < nums.length; i++) {
            curr = Math.max(prev2 + nums[i], prev1);
            prev2 = prev1;
            prev1 = curr;
         }

        return curr;
     }

}
