package problems;

import utils.Arrays;

/**
 * (Given a matrix A, return the transpose of A.)[https://leetcode.com/problems/transpose-matrix/]
 *
 * The transpose of a matrix is the matrix flipped over it's main diagonal,
 * switching the row and column indices of the matrix.
 */

public class Problem_617 {
    public static void main(String[] args) {
        int[][] input = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        // [[1,4,7],[2,5,8],[3,6,9]]
        Arrays.printMatrix(transpose(input));
    }

    static public int[][] transpose(int[][] A) {
        int[][] result = new int[A[0].length][A.length];

        for (int row = 0; row < A.length; row++ ) {
            for (int col = 0; col < A[row].length; col++) {
                result[col][row] = A[row][col];
            }
        }

        return result;
    }
}
