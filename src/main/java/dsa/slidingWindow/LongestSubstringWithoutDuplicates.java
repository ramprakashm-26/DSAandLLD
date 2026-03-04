package dsa.slidingWindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithoutDuplicates {
    public static void main(String[] args) {
        String s = "pwwkew";
        System.out.println("Set approach: " + longestUniqueSubstring(s));
        System.out.println("Map Approach: " + mapLogic(s));
    }

    private static int mapLogic(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        for (int left = 0, right = 0; right < s.length(); right++) {
            char cR = s.charAt(right);
            map.put(cR, map.getOrDefault(cR, 0) + 1);
            while (map.get(cR) > 1) {
                char cL = s.charAt(left++);
                map.put(cL, map.get(cL) - 1);
                if (map.get(cL) == 0) {
                    map.remove(cL);
                }
            }
            max = Math.max(max, right - left + 1);
        }
        return max;
    }

    private static int longestUniqueSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int max = 0;
        for (int left = 0, right = 0; right < s.length(); right++) {
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left++));
            }
            set.add(s.charAt(right));
            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}
