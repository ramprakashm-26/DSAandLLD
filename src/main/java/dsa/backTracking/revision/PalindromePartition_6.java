package dsa.backTracking.revision;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartition_6 {
    public static void main(String[] args) {
        String s = "abba";
        System.out.println(partition(s));
    }

    private static List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(String s, int index, List<String> current, List<List<String>> result) {
        if (index == s.length()) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = index; i < s.length(); i++) {
            if (isPalindrome(s, index, i)) {
                current.add(s.substring(index, i + 1));
                backtrack(s, i + 1, current, result);
                current.remove(current.size() - 1);
            }
        }
    }

    private static boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }
}
