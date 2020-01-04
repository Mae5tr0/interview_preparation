package algorithms;

import utils.Arrays;

/**
 *  The {@code Selection} class provides static methods for sorting an
 *  array using <em>selection sort</em>.
 *  This implementation makes ~ &frac12; <em>n</em><sup>2</sup> compares to sort
 *  any array of length <em>n</em>, so it is not suitable for sorting large arrays.
 *  It performs exactly <em>n</em> exchanges.
 *  <p>
 *  This sorting algorithm is not stable. It uses &Theta;(1) extra memory
 *  (not including the input array).
 *  <p>
 */
public class Selection {

    // This class should not be instantiated.
    private Selection() { }

    /**
     *  First, find the smallest item in the array, and exchange it with the first entry.
     *  Then, find the next smallest item and exchange it with the second entry.
     *  Continue in this way until the entire array is sorted.
     *  This method is called selection sort because it works by repeatedly selecting the smallest remaining item.
     */
    public static void sort(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (less(a[j], a[min])) min = j;
            }
            exch(a, i, min);
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

        Selection.sort(arr);

        Arrays.print(arr);
    }
}
