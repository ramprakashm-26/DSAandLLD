package org.dsa.dynamicProgramming.curatedList.OneDimensional;

public class HouseRobber {
    public static void main(String[] args) {
        int[] array = {2, 7, 9, 3, 1};
        System.out.println("Maximum Money: " + getMaximumRobbedMoney(array));
        System.out.println("Maximum Money: " + rob(array));
    }

    //practiced sum
//    private static int getMaxMoney(int[] houses) {
//        if (houses == null || houses.length == 0){
//            return 0;
//        }
//        int n = houses.length;
//        if (n == 1) return houses[0];
//        if (n == 2) return Math.max(houses[0], houses[1]);
//        int[] dp = new int[n + 1];
//        dp[0] = 0;
//        dp[1] = houses[0];
//        for (int i = 2; i <= n; i++) {
//            dp[i] = Math.max(dp[i - 1], houses[i - 1] + dp[i - 2]);
//        }
//        return dp[n];
//    }

    //Space O(n)
    private static int getMaximumRobbedMoney(int[] array) {
        int n = array.length;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return array[0];
        }
        int[] dp = new int[n];
        dp[0] = array[0];
        dp[1] = Math.max(array[0], array[1]);
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], array[i] + dp[i - 2]);
        }
        return dp[dp.length - 1];
    }

    //space optimized O(1)
    public static int rob(int[] nums) {
        if (nums.length == 1) return nums[0];

        int prev2 = nums[0];
        int prev1 = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            int pick = nums[i] + prev2;
            int notPick = prev1;

            int curr = Math.max(pick, notPick);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
}
