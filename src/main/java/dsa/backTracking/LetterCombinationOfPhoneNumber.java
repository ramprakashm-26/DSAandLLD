package org.dsa.backTracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LetterCombinationOfPhoneNumber {
    public static void main(String[] args) {
        String digits = "23";
        System.out.println(letterCombinations(digits));
    }

    private static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        Map<Character, String> phoneMap = Map.of(
                '2', "abc",
                '3', "def",
                '4', "ghi",
                '5', "jkl",
                '6', "mno",
                '7', "pqrs",
                '8', "tuv",
                '9', "wxyz"
        );
        dfs(digits, 0, new StringBuilder(), phoneMap, result);
        return result;
    }

    private static void dfs(String digit, int index, StringBuilder sb, Map<Character, String> phoneMap,
                     List<String> result) {
        if (sb.length() == digit.length()) {
            result.add(sb.toString());
            return;
        }
        String letters = phoneMap.get(digit.charAt(index));
        for (char ch : letters.toCharArray()) {
            sb.append(ch);
            dfs(digit, index + 1, sb, phoneMap, result);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

//    public List<String> letterCombinations(String digits) {
//        List<String> result = new ArrayList<>();
//        if (digits == null || digits.length() == 0) return result;
//
//        Map<Character, String> phone = Map.of(
//                '2', "abc", '3', "def", '4', "ghi", '5', "jkl",
//                '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz"
//        );
//
//        backtrack(result, phone, digits, 0, new StringBuilder());
//        return result;
//    }
//
//    private void backtrack(List<String> result, Map<Character, String> phone, String digits, int index, StringBuilder current) {
//        if (index == digits.length()) {
//            result.add(current.toString());
//            return;
//        }
//
//        String letters = phone.get(digits.charAt(index));
//        for (char ch : letters.toCharArray()) {
//            current.append(ch); // choose
//            backtrack(result, phone, digits, index + 1, current); // explore
//            current.deleteCharAt(current.length() - 1); // un-choose (backtrack)
//        }
//    }

}
