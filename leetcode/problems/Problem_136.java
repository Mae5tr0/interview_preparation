package problems;

/**
 * Given a non-empty array of integers, every element appears twice except for one. Find that single one.
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 */
public class Problem_136 {

    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{2, 2, 1})); // 1
        System.out.println(singleNumber(new int[]{4, 1, 2, 1, 2})); // 4
    }

    public static int singleNumber(int[] nums) {
        int mask = 0;

        for (int num : nums) {
            mask ^= num;
        }

        return mask;
    }
}
