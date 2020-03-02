package problems;

/**
 *  (Toeplitz Matrix)[https://leetcode.com/problems/toeplitz-matrix/]
 *
 *  A matrix is Toeplitz if every diagonal from top-left to bottom-right has the same element.
 *
 *  Now given an M x N matrix, return True if and only if the matrix is Toeplitz.
 *
 */
public class Problem_766 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        int[][] input = {
            {1, 2, 3, 4},
            {5, 1, 2, 3},
            {9, 5, 1, 2},
        };

        System.out.println(isToeplitzMatrix(input)); // true

        int[][] input2 = {
                {11, 74, 0, 93},
                {40, 11, 74, 7},
        };

        System.out.println(isToeplitzMatrix(input2)); // false
    }

    // naive approach
//    static public boolean isToeplitzMatrix(int[][] matrix) {
//        int R = matrix.length;
//        int C = matrix[0].length;
//
//        for (int baseRow = 0; baseRow < R; baseRow++) {
//            int col = 0;
//            int el = matrix[baseRow][col];
//
//            int row = baseRow + 1;
//            col++;
//            while (col < C && row < R) {
//                if (matrix[row][col] != el) return false;
//                col++;
//                row++;
//            }
//        }
//        for (int baseCol = 1; baseCol < C; baseCol++) {
//            int row = 0;
//            int el = matrix[row][baseCol];
//
//            int col = baseCol + 1;
//            row++;
//            while (col < C && row < R) {
//                if (matrix[row][col] != el) return false;
//                col++;
//                row++;
//            }
//        }
//
//        return true;
//    }

    // optimized, we validate only neigboard elements
    static public boolean isToeplitzMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (row > 0 && col > 0 && matrix[row][col] != matrix[row - 1][col -1 ]) {
                    return false;
                }
            }
        }

        return true;
    }
}
