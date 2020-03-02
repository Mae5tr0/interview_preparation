package problems;


import java.util.Arrays;



public class MatrixSpiralCopy {

    public enum Direction {
        RIGHT,
        DOWN,
        LEFT,
        UP
    }

    static int[] spiralCopy(int[][] inputMatrix) {
        int top = 0;
        int right = inputMatrix[0].length - 1;
        int bottom = inputMatrix.length - 1;
        int left = 0;

        int[] result = new int[inputMatrix.length * inputMatrix[0].length];
        int i = 0;
        int row = 0;
        int col = 0;
        Direction direction = Direction.RIGHT;
        while (i < result.length) {
            result[i] = inputMatrix[row][col];
            switch (direction) {
                case RIGHT:
                    if (col + 1 > right) {
                        direction = Direction.DOWN;
                        top++;
                        row++;
                    } else {
                        col++;
                    }
                    break;
                case DOWN:
                    if (row + 1 > bottom) {
                        direction = Direction.LEFT;
                        right--;
                        col--;
                    } else {
                        row++;
                    }
                    break;
                case LEFT:
                    if (col - 1 < left) {
                        direction = Direction.UP;
                        bottom--;
                        row--;
                    } else {
                        col--;
                    }
                    break;
                case UP:
                    if (row - 1 < top) {
                        direction = Direction.RIGHT;
                        left++;
                        col++;
                    } else {
                        row--;
                    }
                    break;
            }
            i++;
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1,    2,   3,  4,    5},
            {6,    7,   8,  9,   10},
            {11,  12,  13,  14,  15},
            {16,  17,  18,  19,  20}
        };

        // [1, 2, 3, 4, 5, 10, 15, 20, 19, 18, 17, 16, 11, 6, 7, 8, 9, 14, 13, 12]
        System.out.println(Arrays.toString(spiralCopy(matrix)));
    }
}
