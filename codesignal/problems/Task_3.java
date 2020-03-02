package problems;

/**
 * Gravity
 * <p>
 * Emulate gravity in matrix
 * <p>
 * Input:
 * <p>
 * [['F','F','F'],
 * ['.','F','.'],
 * ['.','F','F'],
 * ['#','F','.'],
 * ['F','F','.'],
 * ['.','.','.'],
 * ['.','.','#'],
 * ['.','.','.']]
 * <p>
 * Output:
 * <p>
 * [['.','.','.'],
 * ['.','.','.'],
 * ['F','F','F'],
 * ['#','F','.'],
 * ['.','F','F'],
 * ['.','F','.'],
 * ['F','F','#'],
 * ['.','.','.']]
 */

public class Task_3 {
    public static void main(String[] args) {
        char[][] input =
                {
                        {'F', 'F', 'F'},
                        {'.', 'F', '.'},
                        {'.', 'F', 'F'},
                        {'#', 'F', '.'},
                        {'F', 'F', '.'},
                        {'.', '.', '.'},
                        {'.', '.', '#'},
                        {'.', '.', '.'}
                };

        char[][] result = figureUnderGravity(input);
        for (char[] row : result) {
            System.out.println(java.util.Arrays.toString(row));
        }
    }

    static char[][] figureUnderGravity(char[][] matrix) {
        boolean downPossible = true;
        outerloop:
        for (int row = 0; row < matrix.length - 1; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 'F' && matrix[row + 1][col] == '#') {
                    downPossible = false;
                    break outerloop;
                }
            }
        }

        if (downPossible) {
            down(matrix);
            return figureUnderGravity(matrix);
        }

        return matrix;
    }

    static void down(char[][] matrix) {
        for (int row = matrix.length - 1; row >= 0; row--) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == '#') continue;
                if (row == 0) {
                    matrix[row][col] = '.';
                    continue;
                }
                if (matrix[row - 1][col] == '#') {
                    matrix[row][col] = '.';
                    continue;
                }
                matrix[row][col] = matrix[row - 1][col];
            }
        }
    }
}