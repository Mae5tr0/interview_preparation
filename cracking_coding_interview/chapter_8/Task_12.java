package chapter_8;

import java.util.ArrayList;

/**
 * Eight Queens
 *
 * Write an algorithm to print all ways of arranging eight queens on an 8x8 chess board so that none of them
 * share the same row, column, or diagonal. In this case, "diagonal" means all diagonals,
 * not just the two that bisect the board.
 *
 */
public class Task_12 {
    static int GRID_SIZE = 8;

    public static void main(String[] args) {
        ArrayList<Integer[]> result = new ArrayList<>();
        Integer[] columns = new Integer[GRID_SIZE];

        placeQueens(0, columns, result);

        System.out.println(result.size());
    }

    static void placeQueens(int row, Integer[] columns, ArrayList<Integer[]> results) {
        if (row == GRID_SIZE) {
            results.add(columns.clone());
        } else {
            for (int col = 0; col < GRID_SIZE; col++) {
                if (checkValid(columns, row, col)) {
                    columns[row] = col;
                    placeQueens(row + 1, columns, results);
                }
            }
        }
    }

    static boolean checkValid(Integer[] columns, int row1, int column1) {
        for (int row2 = 0; row2 < row1; row2++) {
            int column2 = columns[row2];

            if (column1 == column2) return false;

            int columnDistance = Math.abs(column2 - column1);

            int rowDistance = row1 - row2;
            if (columnDistance == rowDistance) return false;
        }
        return true;
    }
//    public static void main(String[] args) {
//        int[][] board = new int[8][8];
//
//        Print.array(board);
//
//        System.out.println(arrangeQueens(board, 8));
//    }
//
//    private static boolean arrangeQueens(int[][] board, int queens) {
//        if (queens == 0) {
//            return true;
//        }
//
//        for (int row = 0; row < board.length; row++) {
//            int[] line = board[row];
//            for (int column = 0; column < line.length; column++) {
//                if (board[row][column] > 0 || board[row][column] == -1) continue;
//
//                board[row][column] = -1;
//                fill(board, row, column, queens);
//                if (arrangeQueens(board, queens - 1)) {
//                    Print.array(board);
//                }
//                board[row][column] = 0;
//                unfill(board, queens);
//            }
//        }
//
//        return false;
//    }
//
//    private static void fill(int[][] board, int queenRow, int queenColumn, int queen) {
//        for (int row = 0; row < board.length; row++) {
//            for (int column = 0; column < board[row].length; column++) {
//                if (board[row][column] != 0) continue;
//
//                if (row == queenRow) board[row][column] = queen; // row
//                if (column == queenColumn) board[row][column] = queen; // column
//
//                // need complete filling diagonals
//                int leftDiagonalColumn = queenColumn - queenRow + row;
////                board[row][]
//            }
//        }
//    }
//
//    // this can be optimized
//    private static void unfill(int[][] board, int queen) {
//        for (int row = 0; row < board.length; row++) {
//            for (int column = 0; column < board[row].length; column++) {
//                if (board[row][column] == queen) board[row][column] = 0;
//            }
//        }
//    }
}
