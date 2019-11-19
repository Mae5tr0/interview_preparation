package chapter_1;

/**
 * Zero Matrix
 *
 * Write an algorithm such that if an element in an MxN matrix is 0, its entire row and column are set to 0.
 *
 */
public class Task_8 {
    public static void main(String[] args) {
        int[][] matrix = {
                { 0, 2, 3, 4 },
                { 5, 0, 7, 8 },
                { 9, 10, 0, 12 },
                { 13, 14, 15, 16 },
        };

        printMatrix(nullify(matrix));
    }

    // Complexity: n^2 + n^2 -> O(n^2), Memory: n + n + const -> O(n)
    private static int[][] nullify(int[][] matrix) {
        int n = matrix.length;
        boolean rows[] = new boolean[n];
        boolean columns[] = new boolean[n];

        for (int row = 0; row < n; row++) {
            for (int column = 0; column < n; column++) {
                if (matrix[row][column] == 0) {
                    rows[row] = true;
                    columns[row] = true;
                }
            }
        }

        for (int row = 0; row < n; row++) {
            if (rows[row]) {
                matrix[row] = new int[n];
            } else {
                for (int column = 0; column < n; column++) {
                    if (columns[column]) {
                        matrix[row][column] = 0;
                    }
                }
            }
        }

        return matrix;
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] i : matrix) {
            for (int j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}



