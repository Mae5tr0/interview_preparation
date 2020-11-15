package challenges;

public class BubbleSort {
    static void countSwaps(int[] a) {
        int buf;
        int counter = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - 1; j++) {
                // Swap adjacent elements if they are in decreasing order
                if (a[j] > a[j + 1]) {
                    buf = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = buf;
                    counter++;
                }
            }
        }
        System.out.println("Array is sorted in " + counter + " swaps.");
        System.out.println("First Element: " + a[0]);
        System.out.println("Last Element: " + a[a.length - 1]);
    }
}
