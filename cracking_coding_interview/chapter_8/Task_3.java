package chapter_8;

import java.util.Arrays;

/**
 * Magic Index
 *
 * A magic index in an array A[ 0••• n -1] is defined to be an index such that A[ i] = i.
 * Given a sorted array of distinct integers, write a method to find a magic index, if one exists, in array A.
 *
 */
public class Task_3 {

    public static void main(String[] args) {
        int[] arr = new int[15];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + i;
        }
        arr[1] = 1;
        arr[2] = 2;

        System.out.println(Arrays.toString(arr));
        System.out.println(findMagicIndex(arr));
    }

    private static int findMagicIndex(int[] arr) {
        return findMagicIndex(arr, 0, arr.length - 1);
    }

    private static int findMagicIndex(int[] arr, int start, int end) {
        if (end < start) return -1;
        int mid = (start + end) / 2;
        if (arr[mid] == mid) return mid;

        if (arr[mid] > mid) {
            return findMagicIndex(arr, start, mid - 1);
        } else {
            return findMagicIndex(arr, mid + 1, end);
        }
    }

}