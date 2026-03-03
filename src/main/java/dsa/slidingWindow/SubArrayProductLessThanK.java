package org.dsa.slidingWindow;

public class SubArrayProductLessThanK {
    public static void main(String[] args) {
        int[] nums = {10, 5, 2, 6};
        int k = 100;
        System.out.println(SubArrayProductLessThanK.class.getSimpleName() + " : " +
                numSubArrayProductLessThanK(nums, k));
    }

    public static int numSubArrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) {
            return 0;
        }
        int count = 0;
        int product = 1;
        for (int left = 0, right = 0; right < nums.length; right++) {
            product = product * nums[right];
            while (product >= k) {
                product = product / nums[left++];
            }
            count += right - left + 1;
        }
        return count;
    }
}
