package dsa.slidingWindow;

/**
 * for nums {0, 0, 0, 0, 0} and goal = 0,
 * while (sum > k && left <= right) left right comparison is important, or else
 * index out of range might occur!
 */
public class BinarySubArraysWithSum {
    public static void main(String[] args) {
        int[] nums = {1, 0, 1, 0, 1};
        int k = 2;
        int i1 = numSubarraysWithSum(nums, k);
        int i2 =numSubarraysWithSum(nums, k - 1);
        System.out.println(i1 - i2);
    }

    public static int numSubarraysWithSum(int[] nums, int k) {
        int count = 0;
        int sum = 0;
        for (int left = 0, right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum > k && left <= right) {
                sum -= nums[left++];
            }
            count += right - left + 1;
        }
        return count;
    }
}
