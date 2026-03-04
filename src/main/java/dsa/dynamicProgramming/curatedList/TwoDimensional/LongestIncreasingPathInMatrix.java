package dsa.dynamicProgramming.curatedList.TwoDimensional;

import java.util.Arrays;

public class LongestIncreasingPathInMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {9, 9, 4},
                {6, 6, 8},
                {2, 1, 1}
        };
        System.out.println("Longest Increasing Path: " + longestIncreasingPath(matrix));
    }

    public static int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];
        int maxLength = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                maxLength = Math.max(maxLength, dfs(matrix, dp, m, n, i, j));
            }
        }
        for (int[] row : dp) {
            System.out.println(Arrays.toString(row));
        }
        return maxLength;
    }

    private static int dfs(int[][] matrix, int[][] dp, int m, int n, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return 0;
        }
        if (dp[i][j] != 0) {
            return dp[i][j];
        }
        int up = 0, down = 0, right = 0, left = 0;
        if (i > 0 && matrix[i][j] < matrix[i - 1][j]) {
            up = dfs(matrix, dp, m, n, i - 1, j);
        }
        if (i + 1 < m && matrix[i][j] < matrix[i + 1][j]) {
            down = dfs(matrix, dp, m, n, i + 1, j);
        }
        if (j > 0 && matrix[i][j] < matrix[i][j - 1]) {
            left = dfs(matrix, dp, m, n, i, j - 1);
        }
        if (j + 1 < n && matrix[i][j] < matrix[i][j + 1]) {
            right = dfs(matrix, dp, m, n, i, j + 1);
        }
        return dp[i][j] = 1 + Math.max(Math.max(up, down), Math.max(left, right));
    }
}
