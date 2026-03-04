package dsa.dynamicProgramming.curatedList.OneDimensional;

import java.util.Arrays;

public class CoinChange {
    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount  = 11;
        System.out.println(getMinimumCoins(coins, amount));
    }

    private static int getMinimumCoins(int[] coins, int amount) {
        if (coins == null || coins.length == 0) {
            return 0;
        }
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1); //amount + 1,which means no coin combinations
        dp[0] = 0;
        for (int currAmount = 1; currAmount <= amount; currAmount++) {
            for (int coin : coins) {
                if (currAmount - coin >= 0) {
                    dp[currAmount] = Math.min(dp[currAmount], dp[currAmount - coin] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

}
