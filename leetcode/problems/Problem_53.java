package problems;

/**
 * (Maximum Subarray)[https://leetcode.com/problems/maximum-subarray/]
 *
 * Given an integer array nums, find the contiguous subarray (containing at least one number)
 * which has the largest sum and return its sum.
 *
 *  [-2,1,-3,4,-1,2,1,-5,4] => 6
 *
 */
public class Problem_53 {
    public static void main(String[] args) {
        int[] arr = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};

        System.out.println(maxSubArray(arr));
        System.out.println(maxSubArray2(arr));
        System.out.println(maxSubArray3(arr));
        System.out.println(maxSubArray4(arr));
    }

    // Divide and Conquer
    static public int maxSubArray(int[] nums) {
        return maxSubArray(nums, 0, nums.length - 1);
    }

    static public int maxSubArray(int[] nums, int min, int max) {
        if (max == min) return nums[min];

        int mid = (min + max)/2;

        return Math.max(Math.max(
                maxSubArray(nums, min, mid),
                maxSubArray(nums, mid + 1, max)),
                maxCrossingSubArray(nums, min, mid, max)
        );
    }

    static public int maxCrossingSubArray(int[] nums, int min, int mid, int max) {
        int sum = 0;
        int leftMaxSum = Integer.MIN_VALUE;
        for (int i = mid; i >= min; i--) {
            sum = sum + nums[i];
            if (sum > leftMaxSum) leftMaxSum = sum;
        }


        int rightMaxSum = Integer.MIN_VALUE;
        sum = 0;
        for (int i = mid + 1; i <= max; i++) {
            sum = sum + nums[i];
            if (sum > rightMaxSum) rightMaxSum = sum;
        }

        return leftMaxSum + rightMaxSum;
    }

    // Iterative
    public static int maxSubArray2(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;
        for (int num : nums) {
            if (currSum < 0) {
                currSum = num;
            } else {
                currSum += num;
            }

            if (currSum > maxSum) maxSum = currSum;
            if (currSum <= 0) currSum = num;
        }

        return maxSum;
    }

    // Dynamic programming
    public static int maxSubArray3(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            maxSum = Math.max(maxSum, dp[i]);
        }

        return maxSum;
    }

    // Dynamic programming (optimized)
    public static int maxSubArray4(int[] nums) {
        int prevMax = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            prevMax = Math.max(prevMax + nums[i], nums[i]);
            maxSum = Math.max(maxSum, prevMax);
        }

        return maxSum;
    }
}
