package dsa.dynamicProgramming.curatedList.OneDimensional;

import java.util.Arrays;

public class PartitionEqualSubsetSum {
    public static void main(String[] args) {
        int[] nums = {1, 5, 11, 5};
        System.out.println("Partition Equal Subset sum: " + canPartition(nums));
    }

    public static boolean canPartition(int[] nums) {
        if (nums == null || nums.length == 0) {
            return true;
        }
        int total = 0;
        for (int num : nums) total += num;

        if (total % 2 != 0) return false;

        int target = total / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int num : nums) {
            for (int currentSum = target; currentSum >= num; currentSum--) {
                dp[currentSum] = dp[currentSum] || dp[currentSum - num];
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[target];
    }
}
