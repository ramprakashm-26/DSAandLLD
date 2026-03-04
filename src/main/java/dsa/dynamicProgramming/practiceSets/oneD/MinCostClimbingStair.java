package dsa.dynamicProgramming.practiceSets.oneD;

import java.util.Arrays;

public class MinCostClimbingStair {
    public static void main(String[] args) {
        int[] cost = {10, 15, 20}; //{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}
        System.out.println("Minimum cost of climbing stair by memo: " + memoization(cost));
        System.out.println("Minimum cost of climbing stair by tabulation: " + tabulation(cost));
        System.out.println("Minimum cost of climbing stair by space optimization: " + tabSpaceOpt(cost));
    }

    private static int memoization(int[] cost) {
        if (cost == null || cost.length == 0) {
            return 0;
        }
        int n = cost.length;
        int[] dp = new int[n + 1];
        int minCost = dfs(cost, n, dp);
        System.out.println(Arrays.toString(dp));
        return minCost;
    }

    private static int dfs(int[] cost, int n, int[] dp) {
        if (n < 0) {
            return 0;
        }
        if (dp[n] != 0) {
            return dp[n];
        }
        if (n == 0) {
            return cost[0];
        }
        dp[n] = cost[n - 1] +
                Math.min(dfs(cost, n - 1, dp), dfs(cost, n - 2, dp));
        return Math.min(dp[n - 1], dp[n]);
    }

    private static int tabulation(int[] cost) {
        if (cost == null || cost.length == 0) {
            return 0;
        }
        int n = cost.length;
        if (n == 1) {
            return cost[0];
        }
        if (n == 2) {
            return Math.min(cost[0], cost[1]);
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = cost[0];
        for (int i = 2; i <= n; i++) {
            dp[i] = cost[i - 1] + Math.min(dp[i - 1], dp[i - 2]);
        }
        System.out.println(Arrays.toString(dp));
        return Math.min(dp[n - 1], dp[n]);
    }


    //TODO This gives wrong answer!
    private static int tabSpaceOpt(int[] cost) {
        if (cost == null || cost.length == 0) {
            return 0;
        }
        int n = cost.length;
        if (n == 1) {
            return cost[0];
        }
        if (n == 2) {
            return Math.min(cost[0], cost[1]);
        }
        int first = 0, third = 0;
        int second = cost[0];
        for (int i = 1; i < n; i++) {
            third = cost[i] + Math.min(first, second);
            first = second;
            second = third;
        }
        return Math.min(second, third);
    }
}
