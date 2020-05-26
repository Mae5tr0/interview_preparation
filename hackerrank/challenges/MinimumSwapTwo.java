package challenges;

public class MinimumSwapTwo {
    public static void main(String[] args) {
        int[] arr = new int[]{7, 1, 3, 2, 4, 5, 6};

        System.out.println(minimumSwaps(arr)); //5
    }

    static int minimumSwaps(int[] arr) {
        int swaps = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            while (arr[i] != i + 1) {
                int temp = arr[i];
                arr[i] = arr[temp - 1];
                arr[temp - 1] = temp;
                swaps++;
            }
        }
        return swaps;
    }
}
