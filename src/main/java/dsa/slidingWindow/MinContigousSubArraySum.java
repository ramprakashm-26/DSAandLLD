package org.dsa.slidingWindow;

public class MinContigousSubArraySum {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        int target = 11;
        System.out.println("Minimum length of contiguous sub array sum : " + minLen(nums, target));
    }

    private static int minLen(int[] nums, int target) {
        int minLen = Integer.MAX_VALUE, sum = 0;
        for (int left = 0, right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum >= target) {
                minLen = Math.min(minLen, right - left + 1);
                sum -= nums[left++];
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
