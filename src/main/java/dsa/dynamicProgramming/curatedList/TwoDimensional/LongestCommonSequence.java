package org.dsa.dynamicProgramming.curatedList.TwoDimensional;

import java.util.Arrays;

/**
 * text1 = "ab", text2 = "ac"
 * a   c
 * 0 0 0
 * a   1 0 0
 * b   0 0 0
 */
public class LongestCommonSequence {
    public static void main(String[] args) {
        String text1 = "ab";
        String text2 = "ac";
        System.out.println("LCS by bottom up: " + lcsByIterative(text1, text2));
        System.out.println("LCS by top down: " + lcsByRecursion(text1, text2));
    }

    private static int lcsByIterative(String text1, String text2) {
        if (text1.isBlank() || text2.isBlank()) {
            return 0;
        }
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }
        return dp[0][0];
    }

    private static int lcsByRecursion(String text1, String text2) {
        if (text1.isBlank() || text2.isBlank()) {
            return 0;
        }
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return lcs(0, 0, text1, text2, dp);
    }

    private static int lcs(int i, int j, String text1, String text2, int[][] dp) {
        if (i == text1.length() || j == text2.length()) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (text1.charAt(i) == text2.charAt(j)) {
            dp[i][j] = 1 + lcs(i + 1, j + 1, text1, text2, dp);
        } else {
            int skipI = lcs(i + 1, j, text1, text2, dp);
            int skipJ = lcs(i, j + 1, text1, text2, dp);
            dp[i][j] = Math.max(skipI, skipJ);
        }
        return dp[i][j];
    }
}
