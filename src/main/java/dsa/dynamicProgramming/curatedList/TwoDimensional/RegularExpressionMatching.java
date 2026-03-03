package org.dsa.dynamicProgramming.curatedList.TwoDimensional;

import java.util.Arrays;

public class RegularExpressionMatching {
    public static void main(String[] args) {
        String s = "aab", p = "c*a*b";
        System.out.println("Regex Matching: " + isMatch(s, p));
    }

    public static boolean isMatch(String s, String p) {
        if (s.isEmpty() && p.isEmpty()) {
            return true;
        }
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int j = 1; j <= n; j++) {
            if (p.charAt(j - 1) == '*' && dp[0][j - 2]) {
                dp[0][j] = true;
            }
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 2] || (
                            dp[i - 1][j] && (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.')
                    );
                }
            }
        }
        for (boolean[] row : dp) {
            System.out.println(Arrays.toString(row));
        }
        return dp[m][n];
    }
}
