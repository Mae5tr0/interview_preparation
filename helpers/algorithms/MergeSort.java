package algorithms;

import java.util.Arrays;

public class MergeSort {

    // This class should not be instantiated.
    private MergeSort() { }

    public static void sort(Comparable[] a) {
        Comparable[] aux = new Comparable[a.length];
        sort(a, aux, 0, a.length - 1);
    }

    private static void merge(Comparable[] a, Comparable[] b, int lo, int mid, int hi) {

    }

    private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {

    }


    public static void main(String[] args) {
        Integer[] arr = new Integer[30];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 100);
        }

        System.out.println(Arrays.toString(arr));

        sort(arr);

        System.out.println(Arrays.toString(arr));
    }
}
