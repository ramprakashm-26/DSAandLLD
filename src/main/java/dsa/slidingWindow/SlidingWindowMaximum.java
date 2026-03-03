package dsa.slidingWindow;

import java.util.*;
import java.util.stream.IntStream;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7}; //{1, 3, -1, -3, 5, 3, 6, 7}, k = 3, {1,-1}, k = 1
        int k = 3;
        System.out.println("Maximum by deque: " + Arrays.toString(maxSlidingWindow(nums, k)));
        System.out.println("Maximum by streams: " + Arrays.toString(maxSlidingWindowByStreams(nums, k)));
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[0];
        int n = nums.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> dq = new ArrayDeque<>();
        int resIndex = 0;
        for (int right = 0; right < n; right++) {
            while (!dq.isEmpty() && dq.peekFirst() <= right - k) {
                dq.pollFirst();
            }
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[right]) {
                dq.pollLast();
            }
            dq.offerLast(right);
            if (right >= k - 1) {
                result[resIndex++] = nums[dq.peekFirst()];
            }
        }
        return result;
    }

    public static int[] maxSlidingWindowByStreams(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        List<Integer> result = IntStream.range(0, list.size() - (k - 1)).mapToObj(i -> list.subList(i, i + k))
                .map(s -> s.stream()
                .mapToInt(Integer::intValue).max().getAsInt()).toList();
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
