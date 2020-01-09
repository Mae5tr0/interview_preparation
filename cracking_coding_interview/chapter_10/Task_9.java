package chapter_10;


import utils.Arrays;

/**
 * Sorted Matrix Search
 *
 * Given an M x N matrix in which each row and each column is sorted in ascending order,
 * write a method to find an element.
 *
 */
public class Task_9 {

    public static void main(String[] args) {
        int[][] matrix = {
                { 15, 20, 30, 85 },
                { 20, 35, 80, 95 },
                { 30, 55, 95, 105 },
                { 40, 80, 100, 120 },
        };

        Arrays.printMatrix(matrix);

        findElement(matrix, 95);
    }

    private static boolean findElement(int[][] matrix, int value) {
        int row = 0;
        int col = matrix[row].length - 1;

        while (col >= 0 && row < matrix.length) {
            if (matrix[row][col] == value) {
                System.out.println("(" + row + "," + col + ")");
                return true;
            } else if (matrix[row][col] > value) {
                col--;
            } else {
                row++;
            }
        }

        return false;
    }
}