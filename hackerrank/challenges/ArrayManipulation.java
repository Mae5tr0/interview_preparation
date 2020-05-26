package challenges;

public class ArrayManipulation {
    public static void main(String[] args) {
        int[][] queries = new int[][]{
            {1, 2, 100},
            {2, 5, 100},
            {3, 4, 100}
        };
        System.out.println(arrayManipulation(5, queries)); // 200

        int[][] queries2 = new int[][]{
            {2, 6, 8},
            {3, 5, 7},
            {1, 8, 1},
            {5, 9, 15},
        };
        System.out.println(arrayManipulation(10, queries2)); // 31
    }

    // Brutforce
    static long arrayManipulation2(int n, int[][] queries) {
        int[] result = new int[n];

        int max = Integer.MIN_VALUE;
        for (int step = 0; step < queries.length; step++) {
            for (int i = queries[step][0] - 1; i <= queries[step][1] - 1; i++) {
                int newValue = result[i] + queries[step][2];
                if (newValue > max) max = newValue;
                result[i] = newValue;
            }
        }

        return max;
    }

    // Range
    static long arrayManipulation(int n, int[][] queries) {
        int[] arr = new int[n + 1];
        for (int step = 0; step < queries.length; step++) {
            int start = queries[step][0];
            int end = queries[step][1];
            int sum = queries[step][2];

            arr[start] += sum;
            if (end + 1 <= n) arr[end+1] -=sum;
        }

        long max = Long.MIN_VALUE;
        long curr = 0;
        for (int num : arr) {
            curr += num;
            if (curr > max) max = curr;
        }

        return max;
    }
}
