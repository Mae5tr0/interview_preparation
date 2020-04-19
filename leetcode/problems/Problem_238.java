package problems;


import java.util.Arrays;

/**
 * (Product of Array Except Self)[https://leetcode.com/problems/product-of-array-except-self/]
 *
 * Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal
 * to the product of all the elements of nums except nums[i].
 *
 * Please solve it without division and in O(n).
 *
 */
public class Problem_238 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelf(new int[]{1, 2, 3, 4}))); // 24, 12, 8, 6
        System.out.println(Arrays.toString(productExceptSelf2(new int[]{1, 2, 3, 4})));
    }

    // extra space
    public static int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] L = new int[length];
        int[] R = new int[length];

        L[0] = 1;
        for (int i = 1; i < length; i++) {
            L[i] = L[i - 1] * nums[i - 1];
        }

        R[length - 1] = 1;
        for (int i = length - 2; i >= 0; i--) {
            R[i] = R[i + 1] * nums[i + 1];
        }

        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            result[i] = L[i] * R[i];
        }

        return result;
    }

    // const
    public static int[] productExceptSelf2(int[] nums) {
        int length = nums.length;
        int[] result = new int[length];
        result[0] = 1;
        for (int i = 1; i < length; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }

        int R = 1;
        for (int i = length - 1; i >= 0; i--) {
            result[i] = result[i] * R;
            R *= nums[i];
        }

        return result;
    }
}