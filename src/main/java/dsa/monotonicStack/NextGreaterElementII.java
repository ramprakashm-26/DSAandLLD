package dsa.monotonicStack;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementII {
    public static void main(String[] args) {
        int[] nums= {3, 8, 4, 1, 2};
        System.out.println(Arrays.toString(nextGreaterElements(nums)));
    }

    public static int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < 2 * n; i++) {
            int num = nums[i % n];
            while (!st.isEmpty() && nums[st.peek()] < num) {
                result[st.pop()] = num;
            }
            if (i < n) {
                st.push(i);
            }
        }
        return result;
    }
}
