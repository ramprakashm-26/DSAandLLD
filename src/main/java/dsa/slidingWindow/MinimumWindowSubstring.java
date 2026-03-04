package dsa.slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC", t = "ABC";
        System.out.println("Minimum Window Substring: " + minWindow(s, t));
    }

    public static String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }
        Map<Character, Integer> tMap = new HashMap<>();
        for (char ch : t.toCharArray()) {
            tMap.put(ch, tMap.getOrDefault(ch, 0) + 1);
        }
        Map<Character, Integer> window = new HashMap<>();
        int m = s.length() + t.length(), need = 0, have = tMap.size(), start = 0, end = 0;
        int minLength = m;
        for (int left = 0, right = 0; right < s.length(); right++) {
            char cR = s.charAt(right);
            window.put(cR, window.getOrDefault(cR, 0) + 1);
            if (tMap.containsKey(cR) && tMap.get(cR).intValue() == window.get(cR).intValue()) {
                need++;
            }
            while (have == need) {
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    start = left;
                    end = right;
                }
                char cL = s.charAt(left++);
                window.put(cL, window.get(cL) - 1);
                if (tMap.containsKey(cL) && window.get(cL).intValue() < tMap.get(cL).intValue()) {
                    need--;
                }
            }
        }
        return minLength == m ? "" : s.substring(start, end + 1);
    }

}
