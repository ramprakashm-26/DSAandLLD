package dsa.arraysAndStrings;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println("Longest Consecutive seq :" + longestConsecutiveBySet(nums));
    }

    public static int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        Arrays.sort(nums);
        int count = 0, max = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                continue;
            }
            if (nums[i] - nums[i - 1] > 1) {
                count = 0;
                continue;
            }
            if (nums[i] - nums[i - 1] == 1) {
                count++;
            }
            max = Math.max(max, count);
        }
        return max + 1;
    }

    public static int longestConsecutiveBySet(int[] nums) {
        if (nums.length == 0) return 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int max = 0;
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int current = num;
                int count = 1;
                while (set.contains(current + 1)) {
                    current++;
                    count++;
                }
                max = Math.max(max, count);
            }
        }
        return max;
    }
}
