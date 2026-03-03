package org.dsa.backTracking.revision;

public class UniquePathIII_5 {
    public static int result = 0;

    public static void main(String[] args) {
        int[][] grid = {
                {1, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 2}
        };

        System.out.println(findUniquePath(grid));
    }

    private static int findUniquePath(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int startRow = 0, startCol = 0, zeros = 0;
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 1) {
                    startRow = row;
                    startCol = col;
                }
                if (grid[row][col] == 0) {
                    zeros++;
                }
            }
        }
        backtrack(grid, visited, startRow, startCol, m, n, zeros + 1);
        return result;
    }

    private static void backtrack(int[][] grid, boolean[][] visited, int row, int col,
                                  int m, int n, int zeros) {
        if ((row < 0 || row >= m) || (col < 0 || col >= n) || visited[row][col] || grid[row][col] == -1) {
            return;
        }
        if (grid[row][col] == 2 && zeros == 0) {
            result++;
            return;
        }
        zeros = zeros - 1;
        visited[row][col] = true;
        backtrack(grid, visited, row - 1, col, m, n, zeros);
        backtrack(grid, visited, row + 1, col, m, n, zeros);
        backtrack(grid, visited, row, col - 1, m, n, zeros);
        backtrack(grid, visited, row, col + 1, m, n, zeros);
        zeros = zeros + 1;
        visited[row][col] = false;
    }
}
