package chapter_8;

import structures.LinkedList;
import structures.Pair;

import java.util.Arrays;

/**
 * Robot in a Grid
 *
 * Imagine a robot sitting on the upper left corner of grid with r rows and c columns.
 * The robot can only move in two directions, right and down, but certain cells are "off limits"
 * such that the robot cannot step on them. Design an algorithm to find a path for the robot from
 * the top left to the bottom right.
 *
 */
public class Task_2 {

    public static void main(String[] args) {
        int[][] grid = new int[6][6];
        grid[3][2] = 1;
        grid[5][3] = 1;
        grid[4][1] = 1;
        grid[0][1] = 1;
        grid[1][1] = 1;
        grid[2][4] = 1;

        for (int[] row : grid) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println();


        int[][] path = findPath(grid);

        if (path != null) {
            for (int[] row : path) {
                System.out.println(Arrays.toString(row));
            }
        } else {
            System.out.println("Path is not found");
        }

        System.out.println(getPath(grid));
    }

    private static int[][] findPath(int[][] grid) {
        int[][] path = new int[grid.length][grid[grid.length - 1].length];

        boolean pathExist = findPath(path, grid, 0, 0);

        if (pathExist) return path;

        return null;
    }

    private static boolean findPath(int[][]path, int[][] grid, int row, int column) {
        int rows = grid.length;
        int columns = grid[rows - 1].length;

        if (row > rows - 1 || column > columns - 1) return false;
        if (grid[row][column] > 0) return false; // point unavailable
        if (path[row][column] > 0) return false; // already visited

        path[row][column] = 2;
        if (row == rows - 1 && column == columns - 1) return true; // we found the path

        boolean completed;
        completed = findPath(path, grid, row, column + 1);
        if (!completed) completed = findPath(path, grid, row + 1, column);
        if (!completed) path[row][column] = 1;

        return completed;
    }

    private static LinkedList<Pair<Integer, Integer>> getPath(int[][] maze) {
        if (maze == null || maze.length == 0) return null;

        LinkedList<Pair<Integer,Integer>> path = new LinkedList<>();
        if (getPath(maze, maze.length - 1, maze[0].length - 1, path)) {
            return path;
        }

        return null;
    }

    private static boolean getPath(int[][] maze, int row, int col, LinkedList<Pair<Integer, Integer>> path) {
        if (col < 0 || row < 0 || maze[row][col] > 0) {
            return false;
        }

        boolean isAtOrigin = (row == 0) && (col == 0);

        if (isAtOrigin || getPath(maze, row, col - 1, path) || getPath(maze, row - 1, col, path)) {
            path.addLast(new Pair<>(row, col));
            return true;
        }
        maze[row][col] = 1; // skip processing in other directions

        return false;
    }

}