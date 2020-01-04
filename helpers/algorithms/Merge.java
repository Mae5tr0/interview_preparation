package algorithms;

import utils.Arrays;

/**
 *  The {@code Merge} class provides static methods for sorting an
 *  array using a top-down, recursive version of <em>mergesort</em>.
 *  <p>
 *  This implementation takes &Theta;(<em>n</em> log <em>n</em>) time
 *  to sort any array of length <em>n</em> (assuming comparisons
 *  take constant time). It makes between
 *  ~ &frac12; <em>n</em> log<sub>2</sub> <em>n</em> and
 *  ~ 1 <em>n</em> log<sub>2</sub> <em>n</em> compares.
 *  <p>
 *  This sorting algorithm is stable.
 *  It uses &Theta;(<em>n</em>) extra memory (not including the input array).
 *
 */
public class Merge {
    private static final int CUTOFF = 7; // cutoff to insertion sort

    // This class should not be instantiated.
    private Merge() { }

    public static void sort(Comparable[] a) {
        Comparable[] aux = new Comparable[a.length];
        sort(a, aux, 0, a.length - 1);
    }

    // stably merge a[lo .. mid] with a[mid+1 ..hi] using aux[lo .. hi]
    private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
        // copy to aux[]
        // we can eliminate this operation by change role for aux array in recursive invocation
        // https://algs4.cs.princeton.edu/22mergesort/MergeX.java.html
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }

        // merge back to a[]
        int i = lo;
        int j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if      (i > mid)               a[k] = aux[j++];
            else if (j > hi)                a[k] = aux[i++];
            else if (less(aux[i], aux[j]))  a[k] = aux[i++];
            else                            a[k] = aux[j++];
        }
    }

    // is v < w ?
    private static boolean less(Comparable v, Comparable w) { return v.compareTo(w) < 0; }

    private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
        // switch to insertion sort for small subarrays
        if (hi <= lo + CUTOFF - 1) {
            Insertion.sort(a, lo, hi);
            return;
        }

        int mid = (hi - lo) / 2 + lo;
        sort(a, aux, lo, mid);
        sort(a, aux, mid + 1, hi);

        // don't merge already sorted arrays
        if (less(a[mid], a[mid + 1])) return;
        merge(a, aux, lo, mid, hi);
    }

    public static void main(String[] args) {
        Integer[] arr = Arrays.generateInt(30);

        Arrays.print(arr);

        Merge.sort(arr);

        Arrays.print(arr);
    }
}
