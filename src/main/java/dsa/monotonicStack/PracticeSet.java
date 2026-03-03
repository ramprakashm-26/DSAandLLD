package org.dsa.monotonicStack;

import java.util.*;

public class PracticeSet {
    public static void main(String[] args) {
        int[] nums = {3, 1, 2, 4};
        System.out.println(solve(nums));
    }

    private static int solve(int[] nums) {
        int n = nums.length;
        int minimumSum = 0;
        int[] left = new int[n];
        int[] right = new int[n];
        int mod = 1_000_000_007;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                stack.pop();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        stack.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[i]) {
                stack.pop();
            }
            right[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }
        for (int i = 0; i < n; i++) {
            int count = (i - left[i]) * (right[i] - i);
            minimumSum += count * nums[i] % mod;
        }
        return minimumSum;
    }

}
