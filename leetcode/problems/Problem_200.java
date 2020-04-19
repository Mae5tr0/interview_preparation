package problems;

/**
 * (Number of Islands)[https://leetcode.com/problems/number-of-islands/]
 */
public class Problem_200 {
    public static void main(String[] args) {
        char[][] input1 = new char[][]{
            {'1', '1', '1', '1', '0'},
            {'1', '1', '0', '1', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '0', '0', '0'}
        };
        char[][] input2 = new char[][]{
            {'1', '1', '0', '0', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '1', '0', '0'},
            {'0', '0', '0', '1', '1'}
        };

        System.out.println(numIslands(new char[][]{}));  // 0
        System.out.println(numIslands(new char[][]{{},{}}));  // 0
        System.out.println(numIslands(input1));  // 1
        System.out.println(numIslands(input2));  // 3
    }

    public static int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        if (grid[0].length == 0) return 0;

        int count = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++ ) {
                if (grid[row][col] == '1') {
                    count++;
                    dfs(row, col, grid);
                }
            }
        }

        return count;
    }

    public static void dfs(int row, int col, char[][] grid) {
        if (row < 0 || row >= grid.length) return;
        if (col < 0 || col >= grid[0].length) return;
        if (grid[row][col] == '0') return;

        grid[row][col] = '0';
        dfs(row, col + 1, grid);
        dfs(row, col - 1, grid);
        dfs(row + 1, col, grid);
        dfs(row - 1, col, grid);
    }
}