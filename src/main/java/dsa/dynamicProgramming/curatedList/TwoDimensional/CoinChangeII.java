package dsa.dynamicProgramming.curatedList.TwoDimensional;

public class CoinChangeII {
    public static void main(String[] args) {
        int[] coins = {1, 2, 4};
        int target = 5;
        System.out.println("No of ways to form target: " + tabulation(coins, target));
    }

    private static int tabulation(int[] coins, int target) {
        if (coins == null || coins.length == 0) {
            return 0;
        }
        int n = coins.length;
        int[][] dp = new int[n + 1][target + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target; j++) {
                //if (coins[i - 1] <= j) this also works
                if (j - coins[i - 1] >= 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]]; //take and not take current coin
                } else {
                    dp[i][j] = dp[i - 1][j]; //not take current coin
                }
            }
        }
        return dp[n][target];
    }
}
