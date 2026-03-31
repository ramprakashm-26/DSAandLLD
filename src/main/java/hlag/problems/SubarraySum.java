package hlag.problems;

import java.util.HashMap;
import java.util.Map;

/*
Input
nums = [3, 4, 7, 2, -3, 1, 4, 2]
k = 7
Subarrays with sum 7:
[3, 4]
[7]
[7, 2, -3, 1]
[1, 4, 2]
So the answer is:
4
 */
public class SubarraySum {
    public static void main(String[] args) {
        int[] nums = {3, 4, 7, 2, -3, 1, 4, 2};
        int k = 7;
        System.out.println("Subarray sum count: " + subarraySum(nums, k));
    }

    public static int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // base case
        int sum = 0;
        int count = 0;
        for (int num : nums) {
            sum += num;
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
