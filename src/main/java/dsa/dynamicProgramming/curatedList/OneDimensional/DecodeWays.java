package dsa.dynamicProgramming.curatedList.OneDimensional;

public class DecodeWays {
    public static void main(String[] args) {
        String s = "226"; //i/p -> 226, 12, 06, 10
        System.out.println("No of ways to decode: " + decode(s));
        System.out.println("No of ways to decode: " + numDecodings(s));
    }

    public static int numDecodings(String s) {
        if (s.isEmpty()){
            return 0;
        }
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 2; i <= n; i++) {
            int oneDigit = s.charAt(i - 1) - '0';
            if (oneDigit >= 1 && oneDigit <= 9) {
//                dp[i] = dp[i] + dp[i - 1]; both are same!
                dp[i] = dp[i - 1];
            }
            int twoDigit = (s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0');
            if (twoDigit >= 10 && twoDigit <= 26) {
                dp[i] = dp[i] + dp[i - 2];
            }
        }
        return dp[n];
    }

    private static int decode(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 2; i <= n ; i++) {
            //one digit
            if (s.charAt(i - 1) != '0') {
                dp[i] = dp[i] + dp[i - 1];
            }
            //two digit
            int twoDigit = Integer.parseInt(s.substring(i - 2, i));
            if (twoDigit >= 10 && twoDigit <= 26) {
                dp[i] = dp[i] + dp[i - 2];
            }
        }
        return dp[n];
    }
}
