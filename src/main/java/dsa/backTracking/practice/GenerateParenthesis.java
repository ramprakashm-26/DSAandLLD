package org.dsa.backTracking.practice;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    public static void main(String[] args) {
        int n = 3;
        List<String> result = new ArrayList<>();
        generate(n, 0, 0, new StringBuilder(), result);
        System.out.println(result);
    }

    private static void generate(int n, int open, int close, StringBuilder builder, List<String> result) {
        if (open == n && close == n) {
            result.add(builder.toString());
            return;
        }
        if (open < n) {
            builder.append("(");
            generate(n, open + 1, close, builder, result);
            builder.deleteCharAt(builder.length() - 1);
        }
        if (close < open) {
            builder.append(")");
            generate(n, open, close + 1, builder, result);
            builder.deleteCharAt(builder.length() - 1);
        }
    }
}
