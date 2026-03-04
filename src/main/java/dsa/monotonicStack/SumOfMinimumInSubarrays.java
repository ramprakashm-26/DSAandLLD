package dsa.monotonicStack;

import java.util.Stack;

public class SumOfMinimumInSubarrays {
    public static void main(String[] args) {
        int[] array = {3, 1, 2, 4};
        System.out.println(minimumInSubarray(array));
    }

    private static int minimumInSubarray(int[] arr) {
        int n = arr.length;
        int mod = 1_000_000_007;
        Stack<Integer> stack = new Stack<>();
        int[] left = new int[n];
        int[] right = new int[n];
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        stack.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            right[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }
        long result = 0;
        for (int i = 0; i < n; i++) {
            long leftCount = i - left[i];
            long rightCount = right[i] - i;
            result = (result + arr[i] * leftCount * rightCount) % mod;
        }
        return (int) result;
    }
}
