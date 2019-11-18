package chapter_1;

/**
 * Rotate Matrix
 *
 *  Given an image represented by an NxN matrix,
 *  where each pixel in the image is 4 bytes, write a method to rotate the image by 90 degrees.
 *  Can you do this in place?
 */
public class Task_7 {
    public static void main(String[] args) {
        int[][] matrix_1 = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };
        printMatrix(rotate(matrix_1));

        int[][] matrix_2 = {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 },
        };
        printMatrix(rotate(matrix_2));
    }

    private static int[][] rotate(int[][] matrix) {
        int layerCount = matrix.length / 2;
        for (int i = 0; i < layerCount; i++) {
            int first = i;
            int last = matrix.length - i;

            for (int j = first; j < last; j++) {
                int buf;


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