package org.dsa.backTracking.practice;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {
    public static void main(String[] args) {
        String s = "a1b2";
        List<String> result = new ArrayList<>();
        backtrack(s, 0, new StringBuilder(), result);
        System.out.println(result);
    }

    private static void backtrack(String s, int index, StringBuilder sb, List<String> result) {
        if (index == s.length()) {
            result.add(sb.toString());
            return;
        }
        char ch = s.charAt(index);
        sb.append(ch);
        backtrack(s, index + 1, sb, result);
        sb.deleteCharAt(sb.length() - 1);
        if (Character.isDigit(ch)) {
            return;
        }
        ch = Character.isUpperCase(ch) ? Character.toLowerCase(ch) : Character.toUpperCase(ch);
        sb.append(ch);
        backtrack(s, index + 1, sb, result);
        sb.deleteCharAt(sb.length() - 1);
    }
}
