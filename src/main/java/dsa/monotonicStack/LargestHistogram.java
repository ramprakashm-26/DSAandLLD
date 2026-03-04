package dsa.monotonicStack;

import java.util.Stack;

public class LargestHistogram {
    public static void main(String[] args) {
        int[] nums = {6, 2, 5, 4, 5, 1, 6};
        System.out.println(largestRectangleArea(nums));
    }

    public static int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        for (int i = 0; i <= n; i++) {
            int currentHeight = i == n ? 0 : heights[i];
            while (!stack.isEmpty() && currentHeight < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int right = i;
                int left = stack.isEmpty() ? -1 : stack.peek();
                int width = right - left - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }
        return maxArea;
    }

}
