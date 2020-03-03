package problems;

/**
 * Given an integer array nums, find the contiguous subarray (containing at least one number)
 * which has the largest sum and return its sum.
 *
 *  [-2,1,-3,4,-1,2,1,-5,4] => 6
 *
 */
public class Problem_53 {
    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

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
}
