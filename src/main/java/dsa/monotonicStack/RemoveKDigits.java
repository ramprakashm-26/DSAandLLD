package org.dsa.monotonicStack;

import java.util.Arrays;
import java.util.Stack;

public class RemoveKDigits {
    public static void main(String[] args) {
        String num = "112"; //{1432219, k = 3}, {10200, k = 1}
        int k = 1;
        System.out.println(removeKdigits(num, k));
    }

    public static String removeKdigits(String num, int k) {
        int n = num.length();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            int no = num.charAt(i) - '0';
            while (!stack.isEmpty() && stack.peek() > no && k > 0) {
                stack.pop();
                k--;
            }
            stack.push(no);
        }
        while (k > 0) {
            stack.pop();
            k--;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        sb.reverse();
        int index = 0;
        while (index < sb.length() && sb.charAt(index) == '0') {
            index++;
        }
        return index == sb.length() ? "0" : sb.substring(index);
    }
}
