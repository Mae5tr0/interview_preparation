package problems;

/**
 *  (Counting Elements)[https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/528/week-1/3289/]
 *
 *  Given an integer array arr, count element x such that x + 1 is also in arr.
 *  If there're duplicates in arr, count them seperately.
 *
 */
public class Problem_9999_1 {
    public static void main(String[] args) {
        System.out.println(countElements(new int[]{1, 2, 3})); // 2
        System.out.println(countElements(new int[]{1,1,3,3,5,5,7,7})); // 0
        System.out.println(countElements(new int[]{1,3,2,3,5,0})); // 3
        System.out.println(countElements(new int[]{1,1,2,2})); // 2
    }

    public static int countElements(int[] arr) {
        int[] numbers = new int[1001];

        for (int n : arr) {
            numbers[n]++;
        }

        int result = 0;
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] != 0) result += numbers[i - 1];
        }

        return result;
    }
}
