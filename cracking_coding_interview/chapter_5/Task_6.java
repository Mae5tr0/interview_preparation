package chapter_5;

/**
 * Conversion
 *
 * Write a function to determine the number of bits you would need to flip to convert
 * integer A to integer B.
 *
 * Input: 29 (or: 11101), 15 (or: 01111)
 * Output: 2
 *
 */
public class Task_6 {
    public static void main(String[] args) {
        int a = 0B110001;
        int b = 0B100100;

        System.out.println(flipCount2(a, b)); // 3
        System.out.println(flipCount2(0B11101, 0B01111)); // 2
    }

    public static int flipCount(int a, int b) {
        int diffCount = 0;
        while (a != 0 | b != 0) {
            if (a == 0) {
                diffCount++;
                b >>>= 1;
                continue;
            }
            if (b == 0) {
                diffCount++;
                a >>>= 1;
                continue;
            }

            if ((1 & a) != (1 & b)) diffCount++;

            a >>>= 1;
            b >>>= 1;
        }

        return diffCount;
    }

    public static int flipCount2(int a, int b) {
        int count = 0;
        for (int c = a ^ b; c != 0; c = c & (c-1)) {
            count++;
        }
        return count;
    }
}
