package org.dsa.dynamicProgramming.curatedList.OneDimensional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * valid ones: leetcode -> {"leet", "code"}, applepenapple -> {"apple", "pen"}
 * Invalid ones: catsandog -> { "cats", "dog", "sand", "and", "cat" }
 */
public class WordBreak {
    public static void main(String[] args) {
        String word = "leetcode";
        List<String> list = List.of("leet", "code");
        System.out.println("Word exists in dictionary: " + exist(word, list));
        System.out.println("solution 2: " + wordBreak(word, list));
    }

    private static boolean exist(String word, List<String> list) {
        Set<String> set = new HashSet<>(list);
        boolean[] dp = new boolean[word.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= word.length(); i++) {
            for (int j = 0; j < i; j++) {
                String subString = word.substring(j, i);
                if (dp[j] && set.contains(subString)) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[word.length()];
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (String w : wordDict) {
                int start = i - w.length();
                if (start >= 0 && dp[start] && s.substring(start, i).equals(w)) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
