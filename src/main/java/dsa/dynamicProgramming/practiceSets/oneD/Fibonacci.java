package org.dsa.dynamicProgramming.practiceSets.oneD;

import java.util.Arrays;

public class Fibonacci {
    public static void main(String[] args) {
        int n = 5;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        System.out.println("Fibonacci with memoization: " + fibMemo(n, dp));
        System.out.println("Fibonacci with tabulation: " + fibTab(n));
        System.out.println("Fibonacci with tabulation space optimized: " + fibTabSpaceOpt(n));
    }

    private static int fibMemo(int n, int[] dp) {
        if (dp[n] != -1) {
            return dp[n];
        }
        if (n <= 1) {
            return n;
        }
        return dp[n] = fibMemo(n - 1, dp) +
                fibMemo(n - 2, dp);
    }

    private static int fibTab(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    private static int fibTabSpaceOpt(int n) {
        int first = 0;
        int second = 1;
        int third = 0;
        for (int i = 2; i <= n; i++) {
            third = first + second;
            first = second;
            second = third;
        }
        return third;
    }
}
