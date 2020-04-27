package problems;

/**
 * (Minimum Path Sum)[https://leetcode.com/problems/minimum-path-sum/]
 */
public class Problem_64 {
    static class Solution {
        int min[][];

        public int minPathSum(int[][] grid) {
            if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;

            int R = grid.length;
            int C = grid[0].length;
            min = new int[R][C];

            explore(0, 0, 0, grid);

            return min[R - 1][C - 1];
        }

        public void explore(int row, int col, int prev, int[][] grid) {
            if (row >= grid.length || col >= grid[row].length) return;

            int sum = grid[row][col] + prev;
            if (min[row][col] != 0 && min[row][col] <= sum) return;

            min[row][col] = sum;

            explore(row + 1, col, sum, grid);
            explore(row, col + 1, sum, grid);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] input1 = new int[][] {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        int[][] input2 = new int[][] {
                {1, 2, 5},
                {3, 2, 1},
        };


//        System.out.println(solution.minPathSum(input1)); // 7
//        System.out.println(solution.minPathSum(input2)); // 6

        System.out.println(minPathSum(input1)); // 7
        System.out.println(minPathSum(input2)); // 6
    }

    public static int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;

        int height = grid.length;
        int width = grid[0].length;

        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                if (row == 0 && col == 0) {
                    // first element, do nothing
                } else if (row == 0 && col != 0) { // first row
                    grid[row][col] = grid[row][col] + grid[row][col - 1];
                } else if (row != 0 && col == 0) { // first column
                    grid[row][col] = grid[row][col] + grid[row - 1][col];
                } else {
                    grid[row][col] = grid[row][col] + Math.min(grid[row][col - 1], grid[row - 1][col]);
                }
            }
        }

        return grid[height - 1][width - 1];
    }

    public static int minPathSum2(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;

        int height = grid.length;
        int width = grid[0].length;

        // first row
        for (int col = 1; col < width; col++) {
            grid[0][col] += grid[0][col - 1];
        }
        // first column
        for (int row = 1; row < height; row++) {
            grid[row][0] += grid[row - 1][0];
        }

        for (int row = 1; row < height; row++) {
            for (int col = 1; col < width; col++) {
                grid[row][col] += Math.min(grid[row][col - 1], grid[row - 1][col]);
            }
        }

        return grid[height - 1][width - 1];
    }
}