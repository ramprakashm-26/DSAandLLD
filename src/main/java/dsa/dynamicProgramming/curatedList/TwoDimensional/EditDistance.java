package dsa.dynamicProgramming.curatedList.TwoDimensional;

public class EditDistance {
    public static void main(String[] args) {
        String word1 = "ab";
        String word2 = "acb";
        System.out.println("Minimum No to convert word 1 to word 2: "+minDistance(word1, word2));
    }

    private static int minDistance(String word1, String word2) {
        if (word1.isEmpty() && word2.isEmpty()) {
            return 0;
        }
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int row = 1; row <= m; row++) {
            dp[row][0] = row;
        }
        for (int col = 1; col <= n; col++) {
            dp[0][col] = col;
        }
        for (int row = 1; row <= m; row++) {
            for (int col = 1; col <= n; col++) {
                if (word1.charAt(row - 1) == word2.charAt(col - 1)) {
                    dp[row][col] = dp[row - 1][col - 1];
                } else {
                    dp[row][col] = 1 + Math.min(
                            dp[row - 1][col], //delete
                            Math.min(
                                    dp[row][col - 1],
                                    dp[row - 1][col - 1]
                            )
                    );
                }
            }
        }
        return dp[m][n];
    }
}
