package utils;

import java.util.Arrays;

public class Print {
    public static void array(int[][] arr) {
        for (int[] row : arr) {
            System.out.println(Arrays.toString(row));
        }
    }
}
