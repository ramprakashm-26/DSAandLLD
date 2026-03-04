package dsa.monotonicStack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElement1 {
    public static void main(String[] args) {
        int[] nums2 = {5, 3, 8, 4, 6};
        int[] nums1 = {8, 4, 5};
        System.out.println(Arrays.toString(nextGreaterElement(nums1, nums2)));
    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[n];
        Arrays.fill(result, -1);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < m; i++) {
            while (!stack.isEmpty() && nums2[stack.peek()] < nums2[i]) {
                map.put(nums2[stack.pop()], nums2[i]);
            }
            stack.push(i);
        }
        for (int i = 0; i < n; i++) {
            if (map.get(nums1[i]) != null) {
                result[i] = map.get(nums1[i]);
            }
        }
        return result;
    }
}
