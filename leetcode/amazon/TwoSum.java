package amazon;

import java.util.HashSet;
import java.util.Set;

public class TwoSum {

    public static void main(String[] args) {
       int[] numbers = {1, 1, 2, 45, 46, 46};
       System.out.println(uniqPairs(numbers, 47));  // 2
    }


    static public int uniqPairs(int[] nums, int target) {
        Set<Integer> numbers = new HashSet<Integer>();
        Set<Integer> seen = new HashSet<Integer>();

        for (int num : nums) {
            numbers.add(num);
        }

        int pairs = 0;
        for (int number : numbers) {
            int candidate = target - number;
            if (numbers.contains(candidate) && !seen.contains(candidate)) {
                seen.add(number);
                pairs++;
            }
        }

        return pairs;
    }
}
