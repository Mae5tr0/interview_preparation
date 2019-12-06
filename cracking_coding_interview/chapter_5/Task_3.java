package chapter_5;

/**
 * Flip Bit to Win
 *
 * You have an integer and you can flip exactly one bit from a 0 to a 1.
 * Write code to find the length of the longest sequence of ls you could create.
 *
 * Input: 1775 (or: 11011101111)
 * Output: 8
 *
 */
public class Task_3 {
    public static void main(String[] args) {
        System.out.println(longestSequence(0B11011101111)); // 8
    }

    // Complexity: O(n) where n is number of bits
    public static int longestSequence(int n) {
        int max = 0;
        int prev = 0;
        int current = 0;
        boolean isFlipped = false;
        while (n != 0) {
            boolean isOne = (1 & n) == 1;

            if (isOne) {
                current++;
                prev++;
            } else {
                if (isFlipped) {
                    if (max < current) max = current;
                    current = prev;
                }
                prev = 0;
                current++;
                isFlipped = true;
            }

            n >>>= 1;
        }
        if (max < current) max = current;

        return max;
    }
}
