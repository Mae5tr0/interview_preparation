package problems;


import java.util.HashMap;

/**
 * (Contiguous Array)[https://leetcode.com/problems/contiguous-array/]
 *
 * Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.
 *
 */
public class Problem_525 {
    public static void main(String[] args) {
        System.out.println(findMaxLength(new int[]{0})); // 0
        System.out.println(findMaxLength(new int[]{0, 1})); // 2
        System.out.println(findMaxLength(new int[]{0, 1, 0})); // 2
        System.out.println(findMaxLength(new int[]{0, 1, 0, 1})); // 4
        System.out.println(findMaxLength(new int[]{0, 0, 0, 1, 1, 1, 0})); // 6
    }

    public static int findMaxLength(int[] nums) {
        int sum = 0;
        int max = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i] == 0 ? -1 : 1;

            if (map.containsKey(sum)) {
                max = Math.max(max, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }
        return max;
    }

}