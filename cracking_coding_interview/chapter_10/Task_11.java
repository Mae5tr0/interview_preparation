package chapter_10;


import utils.Arrays;

/**
 * Peaks and Valleys
 *
 * In an array of integers, a "peak" is an element which is greater than or equal to the adjacent integers and a "valley"
 * is an element which is less than or equal to the adjacent integers.
 * For example, in the array {5, 8, 6, 2, 3, 4, 6}, {8, 6} are peaks and {5, 2} are valleys.
 * Given an array of integers, sort the array into an alternating sequence of peaks and valleys.
 *
 */
public class Task_11 {

    public static void main(String[] args) {
        int[] arr = Arrays.toIntArray(Arrays.generateInt(10));

        Arrays.print(arr);

        sortValleyPeak(arr);

        Arrays.print(arr);
    }

    static void sortValleyPeak(int[] array) {
        for (int i = 1; i < array.length; i += 2) {
            int biggestIndex = maxIndex(array, i - 1, i, i + 1);
            if (i != biggestIndex) {
                swap(array, i, biggestIndex);
            }
        }
    }

    static int maxIndex(int[] array, int a, int b, int c) {
        int len = array.length;
        int aValue = a >= 0 && a < len ? array[a] : Integer.MIN_VALUE;
        int bValue = b >= 0 && b < len ? array[b] : Integer.MIN_VALUE;
        int cValue = c >= 0 && c < len ? array[c] : Integer.MIN_VALUE;

        int max = Math.max(aValue, Math.max(bValue, cValue));
        if (aValue == max) return a;
        else if (bValue == max) return b;
        else return c;
    }

    static void swap(int[] arr, int i, int j) {
        int buf = arr[i];
        arr[i] = arr[j];
        arr[j] = buf;
    }
}