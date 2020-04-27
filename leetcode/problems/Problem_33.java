package problems;

/**
 * (Search in Rotated Sorted Array)[https://leetcode.com/problems/search-in-rotated-sorted-array/]
 */
public class Problem_33 {
    public static void main(String[] args) {
        System.out.println(search(new int[]{5, 1, 2, 3, 4}, 1)); // 1
        System.out.println(search(new int[]{4,5,6,7,0,1,2}, 0)); // 4
        System.out.println(search(new int[]{4,5,6,7,0,1,2}, 3)); // -1
        System.out.println(search(new int[]{4}, 4));
        System.out.println(search(new int[]{4}, 5));
        System.out.println(search(new int[]{2,1}, 2));
        System.out.println(search(new int[]{2,1}, 3));
        System.out.println(search(new int[]{2,1}, 1));
        System.out.println(search(new int[]{5,1,2}, 5));
    }

    public static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;

        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = (lo + hi)/2;
            if (nums[mid] == target) return mid;

            if (nums[lo] <= nums[mid]) {
                if (nums[lo] <= target && target < nums[mid]) {
                    hi = mid -1;
                } else {
                    lo = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[hi]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
        }

        return -1;
    }
}