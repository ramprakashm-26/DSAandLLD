package dsa.backTracking.revision;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfPhoneNumber_7 {
    public static void main(String[] args) {
        String digit = "23";
        System.out.println(letterCombinations(digit));
    }

    private static List<String> letterCombinations(String digit) {
        List<String> result = new ArrayList<>();
        if (digit.isBlank()) {
            return result;
        }
        Map<Character, String> map = Map.of(
                '2', "abc",
                '3', "def",
                '4', "ghi",
                '5', "jkl",
                '6', "mno",
                '7', "pqrs",
                '8', "tuv",
                '9', "wxyz"
        );
        backtrack(digit, map, 0, new StringBuilder(), result);
        return result;
    }

    private static void backtrack(String digit, Map<Character, String> map, int index,
                                  StringBuilder sb, List<String> result) {
        if (index == digit.length()) {
            result.add(sb.toString());
            return;
        }
        String word = map.get(digit.charAt(index));
        for (char ch : word.toCharArray()) {
            sb.append(ch);
            backtrack(digit, map, index + 1, sb, result);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
