package algorithms;

import java.util.Arrays;

public class QuickSort {

    // This class should not be instantiated.
    private QuickSort() { }

    public static void sort(Comparable[] a) {

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
