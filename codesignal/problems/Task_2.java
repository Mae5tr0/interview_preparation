package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Most frequent digits
 *
 * Return most frequent digits in ascending order
 *
 * [25, 1, 85, 24, 17] -> [2, 5]
 *
 */
public class Task_2 {
    public static void main(String[] args) {
        int[] numbers = {25, 1, 85, 24, 17, 96}; // [1, 2, 5]

        System.out.println(Arrays.toString(mostFrequentDigits(numbers)));
    }

    static int[] mostFrequentDigits(int[] a) {
        int[] numbers = new int[10];
        List<Integer> result = new ArrayList<Integer>();

        for (int i = 0; i < a.length; i++) {
            for (Integer num : digits(a[i])) {
                numbers[num]++;
            }
        }

        int max = Integer.MIN_VALUE;
        for (int el : numbers) {
            if (el > max) max = el;
        }
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == max) {
                result.add(i);
            }
        }
        Collections.sort(result);

        return convertIntegers(result);
    }

    static List<Integer> digits(int a) {
        List<Integer> result = new ArrayList<Integer>();
        for (int i = a; i > 0; i /= 10) {
            result.add(i % 10);
        }

        return result;
    }

    static int[] convertIntegers(List<Integer> integers)
    {
        int[] ret = new int[integers.size()];
        for (int i=0; i < ret.length; i++)
        {
            ret[i] = integers.get(i);
        }
        return ret;
    }
}
