package org.dsa.backTracking.practice;

public class UniquePathIII {
    public int result = 0;

    public static void main(String[] args) {
        UniquePathIII pathIII = new UniquePathIII();
//        int[][] grid = {
//                {1, 0},
//                {0, 2}
//        };
        int[][] grid = {
                {1, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 2}
        };

        pathIII.findUniquePath(grid);
        System.out.println(pathIII.result);
    }

    private int findUniquePath(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int zeroCount = 0, startCellRow = 0, startCellCol = 0;
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 0) {
                    zeroCount++;
                }
                if (grid[row][col] == 1) {
                    startCellRow = row;
                    startCellCol = col;
                }
            }
        }
        dfs(grid, visited, zeroCount + 1, startCellRow, startCellCol, m, n);
        return result;
    }

    private void dfs(int[][] grid, boolean[][] visited, int zeroCount,
                     int row, int col, int m, int n) {
        if ((row < 0 || row >= m) || (col < 0 || col >= n) || visited[row][col] || grid[row][col] == -1) {
            return;
        }
        if (grid[row][col] == 2 && zeroCount == 0) {
            result++;
            return;
        }
        visited[row][col] = true;
        zeroCount = zeroCount - 1;
        dfs(grid, visited, zeroCount, row - 1, col, m, n);
        dfs(grid, visited, zeroCount, row + 1, col, m, n);
        dfs(grid, visited, zeroCount, row, col - 1, m, n);
        dfs(grid, visited, zeroCount, row, col + 1, m, n);
        visited[row][col] = false;
    }
}
