package dsa.dynamicProgramming.curatedList.OneDimensional;
//all solutions are correct
public class HouseRobber2 {
    public static void main(String[] args) {
        int[] houses = {2, 7, 9, 3, 1};
        System.out.println("Circular House Robbery: " + maxMoney(houses));
        System.out.println("Circular House Robbery: " + rob(houses));
        System.out.println("tabulation: "+ tabulation(houses));
    }

    private static int tabulation(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        if (n == 1) return nums[0];
        if (n == 2) return Math.max(nums[0], nums[1]);
        int first = rob(0,  n - 1, nums);
        int second = rob(1, n - 1, nums);

        return Math.max(first, second);
    }

    private static int rob(int start, int end, int[] nums) {
        int[] dp = new int[end];
        dp[0] = nums[start];
        dp[1] = Math.max(nums[start], nums[1 + start]);
        for (int i = 2; i <= end - 1; i++) {
            dp[i] = Math.max(nums[i + start] + dp[i - 2], dp[i - 1]);
        }
        return dp[end - 1];
    }

    private static int rob(int[] houses) {
        if (houses == null || houses.length == 0) {
            return 0;
        }
        int n = houses.length;
        if (n == 1) {
            return houses[0];
        }
        if (n == 2) {
            return Math.max(houses[0], houses[1]);
        }
        int firstNHouses = rob(houses, 0, n - 2);
        int secondNHouses = rob(houses, 1, n - 1);
        return Math.max(firstNHouses, secondNHouses);
    }

    //{2, 7, 9, 3, 1}
    private static int rob(int[] houses, int start, int end) {
        int previous1 = houses[start];
        int previous2 = Math.max(houses[start], houses[start + 1]);
        for (int i = 2; i <= end - start; i++) {
            int currentHouse = Math.max(previous2, houses[i + start] + previous1);
            previous1 = previous2;
            previous2 = currentHouse;
        }
        return previous2;
    }

    private static int maxMoney(int[] houses) {
        int n = houses.length;
        if (n == 0) return 0;
        if (n == 1) return houses[0];
        int[] dp1 = new int[n - 1];
        int[] dp2 = new int[n - 1];

        dp1[0] = houses[0];
        dp1[1] = Math.max(houses[0], houses[1]);
        for (int i = 2; i < n - 1; i++) {
            dp1[i] = Math.max(dp1[i - 1], houses[i] + dp1[i - 2]);
        }

        dp2[0] = houses[1];
        dp2[1] = Math.max(houses[1], houses[2]);
        for (int i = 2; i < n - 1; i++) {
            dp2[i] = Math.max(dp2[i - 1], houses[i + 1] + dp2[i - 2]);
        }
        return Math.max(dp1[dp1.length - 1], dp2[dp2.length - 1]);
    }
}
