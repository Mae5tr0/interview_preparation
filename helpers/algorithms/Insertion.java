package algorithms;

import utils.Arrays;

/**
 *  The {@code Insertion} class provides static methods for sorting an
 *  array using insertion sort.
 *  <p>
 *  In the worst case, this implementation makes ~ &frac12; <em>n</em><sup>2</sup>
 *  compares and ~ &frac12; <em>n</em><sup>2</sup> exchanges to sort an array
 *  of length <em>n</em>. So, it is not suitable for sorting large arbitrary
 *  arrays. More precisely, the number of exchanges is exactly equal to the
 *  number of inversions. So, for example, it sorts a partially-sorted array
 *  in linear time.
 *  <p>
 *  This sorting algorithm is stable.
 *  It uses &Theta;(1) extra memory (not including the input array).
 *
 */
public class Insertion {

    // This class should not be instantiated.
    private Insertion() { }

    // maintain left part as fully sorted
    // for each element from left part find a proper position
    public static void sort(Comparable[] a) {
        sort(a, 0, a.length - 1);
    }

    public static void sort(Comparable[] a, int lo, int hi) {
        for (int i = lo; i <= hi; i++) {
            // another implementation
            // for (int j = i; j > 0; j--) {
            //    if (less(a[j], a[j - 1])) { exch(a, j, j - 1); } else break;
            // }
            int j = i;
            while (j > 0 && less(a[j], a[j - 1])) {
                exch(a, j, j - 1);
                j--;
            }
        }
    }

    private static boolean less(Comparable v, Comparable w) { return v.compareTo(w) < 0; }

    private static void exch(Object[] a, int i, int j) {
        Object buf = a[i];
        a[i] = a[j];
        a[j] = buf;
    }

    public static void main(String[] args) {
        Integer[] arr = Arrays.generateInt(30);
        Arrays.print(arr);

        Insertion.sort(arr);

        Arrays.print(arr);
    }
}
