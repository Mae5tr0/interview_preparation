package chapter_10;


import utils.Arrays;

/**
 * Missing Int
 *
 * Given an input file with four billion non-negative integers, provide an algorithm to generate an integer
 * that is not contained in the file. Assume you have 1 GB of memory available for this task.
 *
 */
public class Task_7 {

    public static void main(String[] args) {
        Integer[] arr = Arrays.generateInt(15);

        Arrays.print(arr);

        findOpenNumber(arr, 15);
    }

    private static void findOpenNumber(Integer[] arr, int numberOfInt) {
        byte[] bitfield = new byte[numberOfInt/8 + 1];

        for (Integer n : arr) {
            bitfield[n / 8] |= 1 << (n % 8);
        }

        for (int i = 0; i < numberOfInt; i++) {
            if ((bitfield[i / 8] & (1 << i % 8)) == 0) System.out.println(i);
        }
    }
}