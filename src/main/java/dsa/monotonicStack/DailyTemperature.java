package dsa.monotonicStack;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperature {
    public static void main(String[] args) {
        int[] nums = {73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println(Arrays.toString(dailyTemperatures(nums)));
    }

    public static int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                result[stack.peek()] = i - stack.pop();
            }
            stack.push(i);
        }
        return result;
    }

    //brute force
    public static int[] dailyTemperatures2(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] < nums[j]) {
                    result[i] = j - i;
                    break;
                }
            }
        }
        return result;
    }
}
