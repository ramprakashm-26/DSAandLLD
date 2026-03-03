package org.dsa.backTracking.revision;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis_9 {
    public static void main(String[] args) {
        int n = 2;
        System.out.println(generate(n));
    }

    private static List<String> generate(int n) {
        List<String> result = new ArrayList<>();
        backtrack(n, 0, 0, new StringBuilder(), result);
        return result;
    }

    private static void backtrack(int n, int open, int close, StringBuilder sb, List<String> result) {
        if (open == n && close == n) {
            result.add(sb.toString());
            return;
        }
        if (open < n) {
            sb.append("(");
            backtrack(n, open + 1, close, sb, result);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (close < open) {
            sb.append(")");
            backtrack(n, open, close + 1, sb, result);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
