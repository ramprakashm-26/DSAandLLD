package org.dsa.dynamicProgramming.practiceSets.oneD;

import java.util.Arrays;

public class ClimbingStairs {
    public static void main(String[] args) {
        int n = 6;
        long[] dp = new long[n + 1];
        Arrays.fill(dp, -1);
        System.out.println("Count distinct ways to climb stairs by memoization: " + countDistinctWaysByMemo(n, dp));
        System.out.println("Count distinct ways to climb stairs by tabulation: " + tabulation(n));
        System.out.println("Count distinct ways to climb stairs by space optimization: " + countWaysSpaceOpt(n));
    }

    private static long countDistinctWaysByMemo(int n, long[] dp) {
        if (dp[n] != -1) {
            return dp[n];
        }
        if (n <= 2) {
            return n;
        }
        return dp[n] = countDistinctWaysByMemo(n - 1, dp) +
                countDistinctWaysByMemo(n - 2, dp);
    }

    private static int tabulation(int n) {
        if (n <= 3) return n;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    private static long countWaysSpaceOpt(int n) {
        long first = 1;
        long second = 2;
        long third = 0;
        for (int i = 3; i <= n; i++) {
            third = first + second;
            first = second;
            second = third;
        }
        return third;
    }
}
