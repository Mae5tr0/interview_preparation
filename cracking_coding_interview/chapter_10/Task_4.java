package chapter_10;

/**
 * Sorted Search, No Size
 *
 * You are given an array-like data structure Listy which lacks a size method.
 * It does, however, have an elementAt(i) method that returns the element at index i in 0( 1) time.
 * If i is beyond the bounds of the data structure, it returns -1. (For this reason,
 * the data structure only supports positive integers.)
 * Given a Listy which contains sorted, positive integers, find the index at which an element x occurs.
 * If x occurs multiple times, you may return any index.
 *
 */
public class Task_4 {
    public static void main(String[] args) {
        int[] arr = new int[100];
        for (int i = 0; i < 67; i++) {
            arr[i] = i * i;
        }

        Listy listy = new Listy(arr);

        System.out.println(search(listy, 25));

    }

    static public int search(Listy listy, int value) {
        int index = 1;
        while (listy.elementAt(index) != -1 && listy.elementAt(index) < value) {
            index <<= 1;
        }

        return binarySearch(listy, value, index / 2, index);
    }

    static class Listy {
        private int[] arr;

        public Listy(int[] input) {
            arr = new int[input.length];

            int i = 0;
            for (int el : input) {
                arr[i++] = el;
            }
        }

        public int elementAt(int i) {
            if (i < 0 || i >= arr.length) return -1;

            return arr[i];
        }
    }

    public static int binarySearch(Listy listy, int value, int low, int high) {
        int mid;

        while (low <= high) {
            mid = (low + high) / 2;

            int middle = listy.elementAt(mid);

            if (middle == -1 || middle > value) {
                high = mid - 1;
            } else if (middle < value) {
                low = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;
    }

}