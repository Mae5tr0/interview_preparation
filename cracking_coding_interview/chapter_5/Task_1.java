package chapter_5;

/**
 * Insertion
 *
 * You are given two 32-bit numbers, N and M, and two bit positions, i and j.
 * Write a method to insert M into N such that M starts at bit j and ends at bit i.
 * You can assume that the bits j through i have enough space to fit all of M.
 * That is, if M = 10011, you can assume that there are at least 5 bits between j and i.
 * You would not, for example, have j = 3 and i = 2, because M could not fully fit between bit 3 and bit 2.
 *
 * Input: N 10000000000, M 10011, i 2, j 6
 * Output:N = 10001001100
 *
 */
public class Task_1 {
    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(insert3(0B10000000000, 0B10011, 2, 6))); //  10001001100
//        System.out.println(Integer.toBinaryString(insert2(0B11111111111, 0B10001, 2, 6))); //  11111100011
    }

    public static int insert2(int n, int m, int i, int j) {
        int clearMask = ~(~0 << (i + j) ^ (~0 << i));
        System.out.println(Integer.toBinaryString(clearMask));
        int n_cleared = n & clearMask;
        System.out.println(Integer.toBinaryString(n_cleared));
        int m_shifted = m << i;
        System.out.println(Integer.toBinaryString(m_shifted));

        return n_cleared | m_shifted;
    }

    public static int insert3(int n, int m, int i, int j) {
        int allOnes = ~0;

        int left = allOnes << (j + 1);
        System.out.println(Integer.toBinaryString(left));
        int right = (1 << i) - 1;
        System.out.println(Integer.toBinaryString(right));
        int mask = left | right;
        System.out.println(Integer.toBinaryString(mask));
        int n_cleared = n & mask;
        int m_shifted = m << i;
        System.out.println(Integer.toBinaryString(m_shifted));

        return n_cleared | m_shifted;
    }

    public static int insert(int n, int m, int i, int j) {
        int result = n;

        int mi = 0;
        for (; i <= j; i++) {
            result = updateBit(result, i, getBit(m, mi));
            mi++;
        }

        return result;
    }

    private static int updateBit(int num, int i, boolean bitIs1) {
        int value = bitIs1 ? 1 : 0;
        int mask = ~(1 << i);
        return (num & mask) | (value << i);
    }

    private static boolean getBit(int num, int i) {
        return ((num & (1 << i)) != 0);
    }
}
