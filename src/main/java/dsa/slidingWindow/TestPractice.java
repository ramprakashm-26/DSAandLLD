package dsa.slidingWindow;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class TestPractice {
    public static void main(String[] args) {
        int[] nums = {1,2,1,0,4,2,6};
        int k = 3;
        System.out.println(Arrays.toString(maxSlidingWindow(nums, k)));
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1];
        int idx = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!deque.isEmpty() && i - deque.peekFirst() >= k) {
                deque.pollFirst();
            }
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            deque.addLast(i);
            if (i >= k - 1) {
                result[idx++] = nums[deque.peekFirst()];
            }
        }
        return result;
    }
}
