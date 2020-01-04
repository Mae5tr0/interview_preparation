package amazon;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution_1 {

    public static void main(String[] args) {
        Solution_1 solution1 = new Solution_1();

        List<List<Integer>> grid = new LinkedList<>();
        grid.add(new LinkedList<>(Arrays.asList(0, 1, 1, 0, 0)));
        grid.add(new LinkedList<>(Arrays.asList(0, 1, 0, 1, 0)));
        grid.add(new LinkedList<>(Arrays.asList(0, 0, 0, 0, 1)));
        grid.add(new LinkedList<>(Arrays.asList(0, 1, 0, 0, 0)));

        System.out.println(grid);

        System.out.println(solution1.mimimumDays(4, 5, grid));
    }


    int mimimumDays(int rows, int columns, List<List<Integer>> listGrid) {
        int days = 0;
        int notUpdatedServers = 0;
        int[][] grid = new int[rows][columns];

        // convert to array
        int rowCounter = 0;
        for (List<Integer> row : listGrid) {
            int columnCounter = 0;

            for (Integer item : row) {
                grid[rowCounter][columnCounter] = item;
                columnCounter++;
                if (item == 0) notUpdatedServers++;
            }
            rowCounter++;
        }

        System.out.println("Initial");
        printGrid(grid);

        while (notUpdatedServers > 0) {
            days++;

            for (int row = 0; row < rows; row++) {
                for (int column = 0; column < columns; column++) {
                    if (grid[row][column] == days) {
                        if (row + 1 < rows && grid[row + 1][column] == 0) { grid[row + 1][column] = days + 1; notUpdatedServers--; } // top
                        if (row - 1 >= 0 && grid[row - 1][column] == 0) { grid[row - 1][column] = days + 1; notUpdatedServers--; } // bottom
                        if (column + 1 < columns && grid[row][column + 1] == 0) { grid[row][column + 1] = days + 1; notUpdatedServers--; } // right
                        if (column - 1 >= 0 && grid[row][column - 1] == 0) { grid[row][column - 1] = days + 1; notUpdatedServers--; } // left
                    }
                }
            }
            System.out.println("     ");
            printGrid(grid);
        }

        return days;
    }

    void printGrid(int[][] grid) {
        for (int[] row : grid) {
            System.out.println(Arrays.toString(row));
        }
    }

}
