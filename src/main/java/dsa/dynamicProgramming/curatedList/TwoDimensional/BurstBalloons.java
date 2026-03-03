package org.dsa.dynamicProgramming.curatedList.TwoDimensional;

import java.util.Arrays;

/**
 * This is MCM DP Pattern problem
 * O/P below:
 * [3, 30, 159, 167]
 * [0, 15, 135, 159]
 * [0, 0, 40, 48]
 * [0, 0, 0, 40]
 */
public class BurstBalloons {
    public static void main(String[] args) {
        int[] array = {3, 1, 5, 8};
        System.out.println("Burst Balloons Maximum coins: " + maxCoins(array));
    }

    private static int maxCoins(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int n = array.length;
        if (n == 1) {
            return array[0];
        }
        int[][] dp = new int[n][n];
        for (int len = 1; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                for (int k = i; k <= j; k++) {
                    int left = i == k ? 0 : dp[i][k - 1];
                    int right = k == j ? 0 : dp[k + 1][j];
                    int value = (i == 0 ? 1 : array[i - 1]) * array[k] * (j == n -1 ? 1 : array[j + 1]);
                    dp[i][j] = Math.max(dp[i][j], left + value + right);
                }
            }
        }
        for (int[] row : dp) {
            System.out.println(Arrays.toString(row));
        }
        return dp[0][n - 1];
    }
}
