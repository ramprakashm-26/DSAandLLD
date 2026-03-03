package org.dsa.dynamicProgramming.curatedList.OneDimensional;

public class ClimbingStairs {
    public static void main(String[] args) {
        int n = 5;
        System.out.println("Unique steps to climb stairs: " + climbStairs_dp(n));
        System.out.println("Unique steps to climb stairs: " + climbStairs(n));
    }

    //o(n)
    private static int climbStairs_dp(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        int[] dp = new int[n + 1];
        dp[0] = 1; //in ground
        dp[1] = 1; // first step
        for (int i = 2; i <= n; i++) { // from 2nd step
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    //o(1)
    private static int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int previous1 = 1;
        int previous2 = 2;
        for (int i = 3; i <= n; i++) {
            int current = previous1 + previous2;
            previous1 = previous2;
            previous2 = current;
        }
        return previous2;
    }
}
