package org.dsa.dynamicProgramming.curatedList.OneDimensional;

/**
 * int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
 * int[] cost = {10, 15, 20};
 */
public class MinimumCostClimbingStairs {
    public static void main(String[] args) {
        int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println("Minimum Cost of stairsO(n): " + findMinCost(cost));
        int[] cost2 = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println("Minimum cost of stairsO(1): " + findMinCostII(cost2));
    }

    //O(N)
    private static int findMinCost(int[] cost) {
        int n = cost.length;
        if (n == 0) return 0;
        if (n == 1) return cost[0];
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = cost[0];
        for (int i = 2; i <= n; i++) {
            dp[i] = cost[i - 1] + Math.min(dp[i - 1], dp[i - 2]);
        }
        return Math.min(dp[n], dp[n - 1]); //you can reach top either by last step or before last step
    }

    //Space optimized O(1)
    private static int findMinCostII(int[] cost) {
        int n = cost.length;
        if (n == 0) return 0;
        if (n == 1) return cost[0];
        int step1 = 0;
        int step2 = cost[0];
        for (int i = 2; i <= n; i++) {
            int current = cost[i - 1] + Math.min(step1, step2);
            step1 = step2;
            step2 = current;
        }
        return Math.min(step1, step2); //Here either step whichever is minimum
    }
}
