package org.dsa.dynamicProgramming.curatedList.TwoDimensional;

public class TargetSum {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1};
        int target = 3;
        System.out.println("Target Sum ways: " + findTargetSumWays(nums, target));
    }

    public static int findTargetSumWays(int[] nums, int target) {
        if (nums == null || nums.length == 0)  {
            return 0;
        }
        return dfs(nums, 0, target);
    }

    private static int dfs(int[] nums, int index, int target) {
        if (index == nums.length) {
            return target == 0 ? 1 : 0;
        }
        int add = dfs(nums, index + 1, target + nums[index]);
        int sub = dfs(nums, index + 1, target - nums[index]);
        return add + sub;
    }
}
