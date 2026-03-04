package dsa.dynamicProgramming.curatedList.TwoDimensional;

import java.util.Arrays;

public class MatrixChainMultiplication {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50};
        System.out.println("Minimum cost = " + matrixChainOrder(arr));
    }

    public static int matrixChainOrder(int[] arr) {
        int n = arr.length;  // number of dimensions = matrices + 1

        // dp[i][j] = min cost to multiply matrices i..j
        int[][] dp = new int[n][n];

        // length = 2 to n-1 (because single matrix len=1 has cost = 0)
        for (int len = 2; len < n; len++) {
            for (int i = 1; i <= n - len; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;

                // try every possible partition k
                for (int k = i; k < j; k++) {
                    int cost = dp[i][k] + dp[k + 1][j] + arr[i - 1] * arr[k] * arr[j];
                    dp[i][j] = Math.min(dp[i][j], cost);
                }
            }
        }

        for (int[] row : dp) {
            System.out.println(Arrays.toString(row));
        }

        return dp[1][n - 1]; // full chain cost
    }
}
