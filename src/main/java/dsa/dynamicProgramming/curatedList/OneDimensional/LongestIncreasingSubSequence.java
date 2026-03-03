package org.dsa.dynamicProgramming.curatedList.OneDimensional;

import java.util.Arrays;

/**
 * {10, 9, 2, 5, 3, 7, 101, 18}
 * {0, 1, 0, 3, 2, 3}
 * {1, 3, 6, 7, 9, 4, 10, 5, 6} - this i/p wont return max value in dp[n]
 */
public class LongestIncreasingSubSequence {
    public static void main(String[] args) {
        int[] nums = {1, 3, 6, 7, 9, 4, 10, 5, 6};
        System.out.println("LIS length: " + findLisLength(nums));
    }

    private static int findLisLength(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int maxLen = 1;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) { // can start from either 0 or 1, both are same!
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        System.out.println(Arrays.toString(dp));
        return maxLen;
    }
}
