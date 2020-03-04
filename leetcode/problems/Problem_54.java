package problems;

import java.util.LinkedList;
import java.util.List;

/**
 * (Spiral Matrix)[https://leetcode.com/problems/spiral-matrix/]
 *
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 */
public class Problem_54 {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
        };

        System.out.println(spiralOrder(matrix)); // [1,2,3,4,8,12,11,10,9,5,6,7]
    }

    static public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return new LinkedList<Integer>();

        int totalElements = matrix[0].length * matrix.length;
        int top = 0;
        int right = matrix[0].length - 1;
        int bottom = matrix.length - 1;
        int left = 0;

        List<Integer> result = new LinkedList<Integer>();
        while (result.size() < totalElements) {
            // left -> right
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top++;

            // top -> bottom
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--;

            // right -> left
            for (int i = right; i >= left && top < bottom; i--) {
                result.add(matrix[bottom][i]);
            }
            bottom--;

            // bottom -> top
            for (int i = bottom; i >= top && right > left; i--) {
                result.add(matrix[i][left]);
            }
            left++;
        }

        return result;
    }
}
