package org.dsa.dynamicProgramming.curatedList.TwoDimensional;

/**
 * String s = "babgbag", t = "bag"; O/P -> 5 ways
 * String s = "rabbbit", t = "rabbit"; O/P -> 3 ways
 */
public class DistinctSubsequences {
    public static void main(String[] args) {
        String s = "rabbbit", t = "rabbit";
        System.out.println("Distinct SubSeqs: " + distinctSubSeqs(s, t));
    }

    private static int distinctSubSeqs(String source, String target) {
        if (source.isEmpty() && source.isEmpty()) {
            return 1;
        }
        if (source.isEmpty()) {
            return 0;
        }
        int m = source.length(), n = target.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (source.charAt(i - 1) == target.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[m][n];
    }
}
