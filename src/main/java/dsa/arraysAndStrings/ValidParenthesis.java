package dsa.arraysAndStrings;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class ValidParenthesis {
    public static void main(String[] args) {
        String s = "()[]{}";
        System.out.println("Is valid parenthesis: " + isValid(s));
    }

    public static boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char previous = stack.pop();
                if (!((previous == '(' && ch == ')') || (previous == '[' && ch == ']')
                        || (previous == '{' && ch == '}'))) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
