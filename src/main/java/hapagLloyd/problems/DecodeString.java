package hapagLloyd.problems;

import java.util.Stack;

public class DecodeString {
    public static void main(String[] args) {
        String s = "3[a2[c]]";
        System.out.println("Decoded String: " + decodeString(s));
    }

    private static String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        StringBuilder current = new StringBuilder();
        int num = 0;
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                num = num * 10 + ch - '0';
            } else if (ch == '[') {
                countStack.push(num);
                stringStack.push(current);
                num = 0;
                current = new StringBuilder();
            } else if (ch == ']') {
                int count = countStack.pop();
                StringBuilder previous = stringStack.pop();
                for (int i = 0; i < count; i++) {
                    previous.append(current);
                }
                current = previous;
            } else {
                current.append(ch);
            }
        }
        return current.toString();
    }
}
