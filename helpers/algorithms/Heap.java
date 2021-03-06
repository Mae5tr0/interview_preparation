package algorithms;

import utils.Arrays;

/**
 *  The {@code Heap} class provides a static methods for heapsorting
 *  an array.
 *
 */
public class Heap {

    // This class should not be instantiated.
    private Heap() { }

    public static void sort(Comparable[] pq) {
        int n = pq.length;

        // heap construction
        for (int k = n/2; k>= 1; k--)
            sink(pq, k, n);

        // sorting
        while (n > 1) {
            exch(pq, 1, n--);
            sink(pq, 1, n);
        }
    }

    private static void sink(Comparable[] pq, int k, int n) {
        while (2*k <= n) {
            int j = 2*k;
            if (j < n && less(pq, j, j+1)) j++;
            if (!less(pq, k, j)) break;
            exch(pq, k, j);
            k = j;
        }
    }

    /***************************************************************************
     * Helper functions for comparisons and swaps.
     * Indices are "off-by-one" to support 1-based indexing.
     ***************************************************************************/
    private static boolean less(Comparable[] pq, int i, int j) {
        return pq[i-1].compareTo(pq[j-1]) < 0;
    }

    private static void exch(Object[] pq, int i, int j) {
        Object swap = pq[i-1];
        pq[i-1] = pq[j-1];
        pq[j-1] = swap;
    }

    public static void main(String[] args) {
        Integer[] arr = Arrays.generateInt(30);
        Arrays.print(arr);

        Heap.sort(arr);

        Arrays.print(arr);
    }
}
