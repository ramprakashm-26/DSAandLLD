package dsa.slidingWindow;

public class LongestSubArrayWithSum {
    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 1, 3};
        int k = 4;
        System.out.println("longestSubarraySumAtMostK : " + longestSubarraySumAtMostK(nums, k));
    }

    public static int longestSubarraySumAtMostK(int[] nums, int k) {
        int left = 0;
        int sum = 0;
        int maxLen = 0;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum > k) {
                sum -= nums[left++];
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}
