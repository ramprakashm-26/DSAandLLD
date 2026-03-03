package dsa.slidingWindow;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class LongestSubArray {
    public static void main(String[] args) {
        List<Integer> responseTimes = List.of(8, 2, 4, 7);
        int limit = 4;
        System.out.println(longestSubarray(responseTimes.stream().mapToInt(Integer::intValue).toArray(), limit));
    }

    public static int longestSubarray(int[] nums, int limit) {
        Deque<Integer> maxQueue = new ArrayDeque<>();
        Deque<Integer> minQueue = new ArrayDeque<>();
        int result = 0;
        for (int left = 0, right = 0; right < nums.length; right++) {
            int rightVal = nums[right];
            while (!maxQueue.isEmpty() && maxQueue.peekLast() < rightVal) {
                maxQueue.pollLast();
            }
            while (!minQueue.isEmpty() && minQueue.peekLast() > rightVal) {
                minQueue.pollLast();
            }
            maxQueue.addLast(rightVal);
            minQueue.addLast(rightVal);
            while (maxQueue.peekFirst() - minQueue.peekFirst() > limit) {
                int leftVal = nums[left];
                if (maxQueue.peekFirst() == leftVal) {
                    maxQueue.pollFirst();
                }
                if (minQueue.peekFirst() == leftVal) {
                    minQueue.pollFirst();
                }
                left++;
            }
            result = Math.max(result, right - left + 1);
        }
        return result;
    }
}
