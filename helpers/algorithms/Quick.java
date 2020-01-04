package algorithms;

import utils.Arrays;

/**
 *  The {@code Quick} class provides static methods for sorting an
 *  array and selecting the ith smallest element in an array using quicksort.
 *
 */
public class Quick {
    private static final int CUTOFF = 10; // cutoff to insertion sort

    // This class should not be instantiated.
    private Quick() { }

    public static void sort(Comparable[] a) {
        Arrays.shuffle(a);
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        // switch to insertion sort for small subarrays
        if (hi <= lo + CUTOFF - 1) {
            Insertion.sort(a, lo, hi);
            return;
        }

        // partitioning
        int j = partition(a, lo, hi);

        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    private static int partition(Comparable[] a, int lo, int hi) {
        int i = lo;
        int j = hi + 1;

        while (true) {
            while (less(a[++i], a[lo])) {
                if (i == hi) break;
            }
            while (less(a[lo], a[--j])) {
                if (j == lo) break;
            }

            if (i >= j) break;
            exch(a, i, j);
        }

        exch(a, lo, j);

        return j;
    }

    // is v < w ?
    private static boolean less(Comparable v, Comparable w) { return v.compareTo(w) < 0; }

    private static void exch(Object[] a, int i, int j) {
        Object buf = a[i];
        a[i] = a[j];
        a[j] = buf;
    }

    public static void main(String[] args) {
        Integer[] arr = utils.Arrays.generateInt(30);
        utils.Arrays.print(arr);

        Quick.sort(arr);

        Arrays.print(arr);
    }
}
