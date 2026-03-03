package org.dsa.dynamicProgramming.curatedList.TwoDimensional;

import java.util.Arrays;

public class UniquePath {
    public static void main(String[] args) {
        int m = 3, n = 2;
        System.out.println("Unique path with Top down memoization: "+ uniquePaths(m, n));
        System.out.println("Unique path with Bottom Up tabulation: "+ uniquePathBottomUp(m, n));
    }

    private static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        dp[0][0] = 1;
        return dfs(m - 1, n - 1, dp);
    }

    private static int dfs(int i, int j, int[][] dp) {
        if (i == 0 && j == 0) {
            return 1;
        }
        if (i < 0 || j < 0) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int fromTop = dfs(i - 1, j, dp);
        int fromLeft = dfs(i, j - 1, dp);
        return dp[i][j] = fromTop + fromLeft;
    }

    private static int uniquePathBottomUp(int m, int n) {
        int[][] dp = new int[m][n];
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
