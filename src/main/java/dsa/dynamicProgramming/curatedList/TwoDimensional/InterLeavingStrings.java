package org.dsa.dynamicProgramming.curatedList.TwoDimensional;

import java.util.Arrays;

public class InterLeavingStrings {
    public static void main(String[] args) {
        String s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac";
        System.out.println("InterLeaving Strings? :" + isInterleave(s1, s2, s3));
    }

    public static boolean isInterleave(String s1, String s2, String s3) {
        if (s1.isEmpty() && s2.isEmpty() && s3.isEmpty()) {
            return true;
        }
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        int m = s1.length(), n = s2.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 1; i <= m; i++) {
            if (s1.charAt(i - 1) == s3.charAt(i - 1) && dp[i -1][0]) {
                dp[i][0] = true;
            }
        }
        for (int j = 1; j <= n; j++) {
            if (s2.charAt(j - 1) == s3.charAt(j - 1) && dp[0][j - 1]) {
                dp[0][j] = true;
            }
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int k = i + j - 1;
                if (s1.charAt(i - 1) == s3.charAt(k) && dp[i - 1][j]) {
                    dp[i][j] = true;
                }
                if (s2.charAt(j - 1) == s3.charAt(k) && dp[i][j - 1]) {
                    dp[i][j] = true;
                }
            }
        }
        for (boolean[] row : dp) {
            System.out.println(Arrays.toString(row));
        }
        return dp[m][n];
    }
}
