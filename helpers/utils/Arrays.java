package utils;

import java.util.Random;

public class Arrays {
    public static Integer[] generateInt(int count) {
        Integer[] result = new Integer[count];

        Random random = new Random();
        for (int i = 0; i < count; i++) {
            result[i] = random.nextInt(count);
        }

        return result;
    }

    public static void printMatrix(int[][] arr) {
        for (int[] row : arr) {
            System.out.println(java.util.Arrays.toString(row));
        }
    }

    public static int[] toIntArray(Integer[] arr)  {
        int[] ret = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            ret[i] = arr[i];
        }

        return ret;
    }

    public static void shuffle(Object[] a) {
        int n = a.length;

        Random random = new Random();
        for (int i = 1; i < n; i++) {
            int r = random.nextInt(i);
            Object buf = a[i];
            a[i] = a[r];
            a[r] = buf;
        }
    }

    public static void print(Object[] arr) {
        System.out.println(java.util.Arrays.toString(arr));
    }

    public static void print(int[] arr) {
        System.out.println(java.util.Arrays.toString(arr));
    }
}
