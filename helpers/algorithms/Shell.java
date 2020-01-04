package algorithms;

import utils.Arrays;

/**
 *  The {@code Shell} class provides static methods for sorting an
 *  array using <em>Shellsort</em> with
 *  <a href = "https://oeis.org/A003462"> Knuth's increment sequence</a>
 *  (1, 4, 13, 40, ...). In the worst case, this implementation makes
 *  &Theta;(<em>n</em><sup>3/2</sup>) compares and exchanges to sort
 *  an array of length <em>n</em>.
 *  <p>
 *  This sorting algorithm is not stable.
 *  It uses &Theta;(1) extra memory (not including the input array).
 *
 */
public class Shell {

    // This class should not be instantiated.
    private Shell() { }


    public static void sort(Comparable[] a) {
        int n = a.length;

        int h = 1;

        // 3x+1 increment sequence:  1, 4, 13, 40, 121, 364, 1093, ...
        while (h < n/3) h = 3*h + 1;

        while (h >= 1) {
            // h-sort the array
            for (int i = h; i < n; i++) {
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                    exch(a, j, j-h);
                }
            }
            h /= 3;
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

        Shell.sort(arr);

        Arrays.print(arr);
    }
}
