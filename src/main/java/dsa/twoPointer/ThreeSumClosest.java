package dsa.twoPointer;

import java.util.Arrays;

public class ThreeSumClosest {
    public static void main(String[] args) {
        int[] nums = {-1, 2, 1, -4};
        int target = 1;
        System.out.println("Closest number: %s".formatted(threeSumClosest(nums, target)));
    }

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closestDiff = Integer.MAX_VALUE;
        int closestSum = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (Math.abs(target - sum) < closestDiff) {
                    closestDiff = Math.abs(target - sum);
                    closestSum = sum;
                }
                if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return closestSum;
    }
}
