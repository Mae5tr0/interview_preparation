package challenges;

import java.util.Arrays;

public class LeftRotation {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(rotLeft(new int[]{1, 2, 3, 4, 5}, 4))); // 5 1 2 3 4
        System.out.println(Arrays.toString(rotLeft(new int[]{1, 2, 3, 4, 5}, 5))); // 1 2 3 4 5
    }

    static int[] rotLeft(int[] a, int d) {
        int[] result = new int[a.length];

        int position = 0;
        int positionInSource = d;
        while (position < a.length) {
            if (positionInSource >= a.length) positionInSource = 0;
            result[position] = a[positionInSource];
            position++;
            positionInSource++;
        }

        return result;
    }
}
