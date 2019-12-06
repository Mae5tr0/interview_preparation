package chapter_5;

/**
 * Pairwise Swap
 *
 * Write a program to swap odd and even bits in an integer with as few instructions as
 * possible (e.g., bit 0 and bit 1 are swapped, bit 2 and bit 3 are swapped, and so on).
 *
 */
public class Task_7 {
    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(swap(0B110110001))); // 1001110010
//        System.out.println(Integer.toBinaryString(swap(0B10101))); // 10101
    }

    public static int swap(int x) {
        int evenBits = x & 0xaaaaaaaa >>> 1;
        int oddBits = x & 0x55555555 << 1;

        return evenBits | oddBits;
    }
}
