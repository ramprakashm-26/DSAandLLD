package dsa.dynamicProgramming.curatedList.TwoDimensional;

import java.util.Arrays;

/**
 * int[][] grid = {
 *                 {0, 0, 0},
 *                 {0, 1, 0},      O/P -> 2
 *                 {0, 0, 0}
 *         };
 * int[][] grid = {
 *                 {0, 0},          O/P -> - 0
 *                 {1, 1}
 *         };
 */
public class UniquePathII {
    public static void main(String[] args) {
        int[][] grid = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };
        System.out.println("Recursion: "+ uniquePathIIRecursion(grid));
        System.out.println("Bottom Up: "+uniquePathIIBottomUp(grid));
    }

    private static int uniquePathIIRecursion(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return dfs(0, 0, m, n, dp, grid);
    }

    private static int dfs(int i, int j, int m, int n, int[][] dp, int[][] grid) {
        if (i == m - 1 && j == n - 1 && grid[i][j] == 0) {
            return 1;
        }
        if ((i < 0 || i >= m) || (j < 0 || j >= n) || grid[i][j] == 1) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int bottom = dfs(i + 1, j, m, n, dp, grid);
        int right = dfs(i, j + 1, m, n, dp, grid);
        return dp[i][j] = bottom + right;
    }

    private static int uniquePathIIBottomUp(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int row = 0; row < m; row++) {
            if (grid[row][0] == 1) {
                break;
            }
            dp[row][0] = 1;
        }
        for (int col = 0; col < n; col++) {
            if (grid[0][col] == 1) {
                break;
            }
            dp[0][col] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (grid[i][j] == 1) {
                    continue;
                }
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
