package org.dsa.dynamicProgramming.curatedList.OneDimensional;

public class MaxSumSubArray {
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Maximum Sum of sub array: " + getMaxSum(nums));
    }

    private static int getMaxSum(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int currentSum = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            max = Math.max(max, currentSum);
        }
        return max;
    }
}
