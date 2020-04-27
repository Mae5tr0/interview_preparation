package problems;

class NumberOfPaths {
    static int numOfPathsToDest(int n) {
        int[][] memo = new int[n][n];

        dfs(0, 0, memo);

        return memo[n - 1][n - 1];
    }

    public static void dfs(int row, int col, int[][] memo) {
        if (row > col) return;
        int size = memo.length - 1;
        if (row > size || col > size) return;
        if (row == size && col == size) { // dest
            memo[size][size]++;
            return;
        }
        if (memo[row][col] > 0) {
            memo[size][size] += memo[row][col];
            return;
        }

        memo[row][col]++;

        dfs(row + 1, col, memo);
        dfs(row, col + 1, memo);
    }

    public static void main(String[] args) {
        System.out.println(numOfPathsToDest(4)); // 5
    }


}
