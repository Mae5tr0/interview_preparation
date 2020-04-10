package problems;

import java.util.Arrays;

/**
 *  (Move Zeroes)[https://leetcode.com/problems/move-zeroes/]
 *
 *  Given an array nums, write a function to move all 0's to the end of it while maintaining
 *  the relative order of the non-zero elements.
 *
 */
public class Problem_283 {
    public static void main(String[] args) {
        int[] arr = new int[] {0, 1, 0, 3, 12};

        System.out.println(Arrays.toString(arr));
        moveZeroes(arr);
        System.out.println(Arrays.toString(arr));

        moveZeroes3(new int[]{0});
        moveZeroes3(new int[]{1});
        int[] arr2 = new int[]{1, 0};
        moveZeroes3(arr2);
        System.out.println(Arrays.toString(arr2));

        int[] arr3 = new int[]{1, 0, 1};
        moveZeroes3(arr3);
        System.out.println(Arrays.toString(arr3));
    }

    // Two pointer optimized
    public static void moveZeroes(int[] nums) {
        for (int lastNonZeroFoundAt = 0, cur = 0; cur < nums.length; cur++) {
            if (nums[cur] != 0) {
                if (lastNonZeroFoundAt == cur) {
                    lastNonZeroFoundAt++;
                    continue;
                }

                int buf = nums[lastNonZeroFoundAt];
                nums[lastNonZeroFoundAt++] = nums[cur];
                nums[cur] = buf;
            }
        }
    }

    // Two pointer base
    public static void moveZeroes2(int[] nums) {
        int zero = 0;
        int number = 0;

        while (number < nums.length && zero < nums.length) {
            if (nums[number] == 0) {
                number++;
                continue;
            }
            if (nums[zero] != 0) {
                zero++;
                continue;
            }

            if (number <= zero) {
                number = zero + 1;
                continue;
            };

            nums[zero] = nums[number];
            nums[number] = 0;
            zero++;
            number++;
        }
    }

    // Simplified, not optimal
    public static void moveZeroes3(int[] nums) {
        if (nums == null || nums.length == 0) return;

        int i = 0;
        for (int num: nums) {
            if (num != 0) {
                nums[i++] = num;
            }
        }

        while (i < nums.length) {
            nums[i++] = 0;
        }
    }
}
