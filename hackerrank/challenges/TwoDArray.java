package challenges;

public class TwoDArray {
    public static void main(String[] args) {
        int[][] arr = new int[][]{
            {1, 1, 1, 0, 0, 0},
            {0, 1, 0, 0, 0, 0},
            {1, 1, 1, 0, 0, 0},
            {0, 0, 2, 4, 4, 0},
            {0, 0, 0, 2, 0, 0},
            {0, 0, 1, 2, 4, 0},
        };

        System.out.println(hourglassSum(arr)); //19
    }

    static int hourglassSum(int[][] arr) {
        int maxSum = Integer.MIN_VALUE;

        for (int row = 0; row < arr.length - 2; row++) {
            for (int col = 0; col < arr[row].length - 2; col++) {
                int localSum = arr[row][col] + arr[row][col + 1] + arr[row][col + 2] +
                        arr[row + 1][col + 1] + arr[row + 2][col] + arr[row + 2][col + 1] + arr[row + 2][col + 2];

                if (localSum > maxSum) maxSum = localSum;
            }
        }

        return maxSum;
    }
}
