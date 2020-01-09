package chapter_10;


import utils.Arrays;

/**
 * Find Duplicates
 *
 * You have an array with all the numbers from 1 to N, where N is at most 32,000.
 * The array may have duplicate entries and you do not know what N is.
 * With only 4 kilobytes of memory available, how would you print all duplicate elements in the array?
 *
 */
public class Task_8 {

    public static void main(String[] args) {
        Integer[] arr = Arrays.generateInt(100);

        Arrays.print(arr);

        printAllDuplicates(arr, 32000);
    }

    private static void printAllDuplicates(Integer[] arr, int numberOfInt) {
        BitSet bitSet = new BitSet(numberOfInt);

        for (Integer n : arr) {
            if (bitSet.get(n)) System.out.println(n);
            bitSet.set(n);
        }
    }

    static class BitSet {
        int[] bitset;

        public BitSet(int size) {
            bitset = new int[size / 32 + 1];
        }

        boolean get(int pos) {
            return (bitset[pos / 32] & (1 << pos % 32)) != 0;
        }

        void set(int pos) {
            bitset[pos / 32] |= 1 << pos % 32;
        }
    }
}