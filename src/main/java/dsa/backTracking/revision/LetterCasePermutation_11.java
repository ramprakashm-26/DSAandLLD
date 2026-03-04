package dsa.backTracking.revision;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation_11 {
    public static void main(String[] args) {
        String str = "a1b2";
        System.out.println(casePerm(str));
    }

    private static List<String> casePerm(String s) {
        List<String> result = new ArrayList<>();
        backtrack(s, 0, new StringBuilder(), result);
        return result;
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
        ch = Character.isLowerCase(ch) ? Character.toUpperCase(ch) : Character.toLowerCase(ch);
        sb.append(ch);
        backtrack(s, index + 1, sb, result);
        sb.deleteCharAt(sb.length() - 1);
    }
}
