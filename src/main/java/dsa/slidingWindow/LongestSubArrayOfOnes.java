package org.dsa.slidingWindow;

public class LongestSubArrayOfOnes {
    public static void main(String[] args) {
        int[] nums = {0, 1, 1, 1, 0, 1, 1, 0};
        System.out.println(longestSubarray(nums));
    }

    public static int longestSubarray(int[] nums) {
        int k = 1;
        int maxLen = 0;
        for (int left = 0, right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                k--;
            }
            while (k < 0) {
                if (nums[left++] == 0) {
                    k++;
                }
            }
            maxLen = Math.max(maxLen, right - left);
        }
        return maxLen;
    }
}
