package chapter_10;

import java.util.Arrays;

/**
 * Sorted Merge
 *
 * You are given two sorted arrays, A and B, where A has a large enough buffer at the end to hold B.
 * Write a method to merge B into A in sorted order.
 *
 */
public class Task_1 {

    public static void main(String[] args) {
        int[] a = new int[20];
        int[] b = new int[10];

        int counter = 2;
        for (int i = 0; i < a.length / 2; i++) {
            a[i] = counter;
            counter += 2;
        }

        counter = 3;
        for (int i = 0; i < b.length; i++) {
            b[i] = counter;
            counter += 3;
        }

        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));

//        merge(a, b);
        merge2(a, b, 10, 10);

        System.out.println(Arrays.toString(a));
    }

    // Complexity: n + n -> O(n)
    static public void merge(int[] a, int[] b) {
        int shift = a.length - b.length;
        // shift all elements in a to length b
        for (int i = 0; i < shift; i++) {
            a[i + shift] = a[i];
        }

        // merge
        int i = shift;
        int k = 0;
        int curr = 0;
        while (curr < a.length) {
            if (i >= a.length) a[curr] = b[k++];
            else if (k >= b.length) a[curr] = a[i++];
            else if (a[i] <= b[k]) a[curr] = a[i++];
            else a[curr] = b[k++];

            curr++;
        }
    }

    static public void merge2(int[] a, int[] b, int lastA, int lastB) {
        int indexA = lastA - 1;
        int indexB = lastB - 1;
        int indexMerged = lastB + lastA - 1;

        while (indexB >= 0) {
            if (indexA >= 0 && a[indexA] > b[indexB]) {
                a[indexMerged] = a[indexA];
                indexA--;
            } else {
                a[indexMerged] = b[indexB];
                indexB--;
            }

            indexMerged--;
        }

    }
}