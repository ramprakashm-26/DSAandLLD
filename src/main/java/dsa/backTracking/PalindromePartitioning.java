package dsa.backTracking;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public static void main(String[] args) {
        String s = "abba";
        List<List<String>> result = new ArrayList<>();
        dfs(s, 0, new ArrayList<>(), result);
        System.out.println(result);
    }

    private static void dfs(String s, int index, List<String> subset, List<List<String>> result) {
        if (index == s.length()) {
            result.add(new ArrayList<>(subset));
            return;
        }
        for (int i = index; i < s.length(); i++) {
            if (isPalindrome(s, index, i)) {
                subset.add(s.substring(index, i + 1));
                dfs(s, i + 1, subset, result);
                subset.remove(subset.size() - 1);
            }
        }
    }

    private static boolean isPalindrome(String s, int left, int right) {
        while(left < right) {
            if(s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }

//    private static void backtrack(String s, int start, List<String> current,
//                                  List<List<String>> result) {
//        if (start == s.length()) {
//            result.add(new ArrayList<>(current));
//            return;
//        }
//        for (int i = start; i < s.length(); i++) {
//            if (isPalindrome(s, start, i)) {
//                current.add(s.substring(start, i + 1));
//                backtrack(s, i + 1, current, result);
//                current.remove(current.size() - 1);
//            }
//        }
//    }

//    private static boolean isPalindrome(String s, int left, int right) {
//        while (left < right) {
//            if (s.charAt(left++) != s.charAt(right--)) {
//                return false;
//            }
//        }
//        return true;
//    }
}
