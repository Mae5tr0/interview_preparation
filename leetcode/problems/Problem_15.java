package problems;

import java.util.LinkedList;
import java.util.List;

/**
 * (3Sum)[https://leetcode.com/problems/3sum/]
 *
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero.
 */
public class Problem_15 {
    public static void main(String[] args) {
        int[] arr = {-1, 0, 1, 2, -1, -4};

        System.out.println(threeSum(arr)); // [-1, 0, 1], [-1, -1, 2]
    }

    static public List<List<Integer>> threeSum(int[] nums) {
        return null;
    }
}
