package org.dsa.slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class PermutationInString {
    public static void main(String[] args) {
        String s1 = "ab", s2 = "eidbaooo";
        System.out.println("Are permutations: "+ checkInclusion(s1, s2));
    }
    public static boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> sMap = new HashMap<>();
        for (char ch : s1.toCharArray()) {
            sMap.put(ch, sMap.getOrDefault(ch, 0) + 1);
        }
        Map<Character, Integer> window = new HashMap<>();
        int k = s1.length();
        for (int left = 0, right = 0; right < s2.length(); right++) {
            char chRight = s2.charAt(right);
            window.put(chRight, window.getOrDefault(chRight, 0) + 1);
            if (right - left + 1 > k) {
                char chLeft = s2.charAt(left++);
                window.put(chLeft, window.get(chLeft) - 1);
                if (window.get(chLeft) == 0) {
                    window.remove(chLeft);
                }
            }
            if (window.equals(sMap)) {
                return true;
            }
        }
        return false;
    }
}
