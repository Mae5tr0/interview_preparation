package chapter_5;

/**
 * Next Number
 *
 * Given a positive integer, print the next smallest and the next largest number
 * that have the same number of 1 bits in their binary representation.
 *
 */
public class Task_4 {
    public static void main(String[] args) {
        int a = 45; // 0B101101
        System.out.println(Integer.toBinaryString(smallest(a))); // 15 -> 001111
        System.out.println(Integer.toBinaryString(largest(a)));  // 60 -> 111100
    }

    public static int smallest(int n) {
        int count = 0;
        while (n != 0) {
            if ((1 & n) == 1) count++;
            n >>>= 1;
        }

        return ~(~0 << count);
    }

    public static int largest(int n) {
        int count = 0;
        int max = 0;
        while (n != 0) {
            if ((1 & n) == 1) count++;
            max++;
            n >>>= 1;
        }

        return ~(~0 << count) << (max - count);
    }
}
