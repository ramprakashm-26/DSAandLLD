package org.dsa.dynamicProgramming.curatedList.OneDimensional;

public class MaxProductSubArray {
    public static void main(String[] args) {
        int[] nums = {-4, -3, -10}; // {2, 3, -2, 4} -> 6 {-2, 0, -1} -> 0 // {-2, 3, -4} -> 24
        System.out.println("Maximum Product: "+ getMaxProduct(nums));
    }

    private static int getMaxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        if (n == 1) return nums[0];
        int maxProduct = nums[0], minProduct = nums[0], max = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i] < 0) {
                int temp = maxProduct;
                maxProduct = minProduct;
                minProduct = temp;
            }
            maxProduct = Math.max(nums[i], nums[i] * maxProduct);
            minProduct = Math.min(nums[i], nums[i] * minProduct);
            max = Math.max(max, maxProduct);
        }
        return max;
    }
}
