package dsa.slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStrWithKDistinctChars {
    public static void main(String[] args) {
        String s = "aabacbebebe";
        int k = 3;
        System.out.println("Longest SubString With at most K DistinctCharacters: " + longest(s, k));
    }

    private static int longest(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int maxLen = 0;
        for (int left = 0, right = 0; right < s.length(); right++) {
            char cR = s.charAt(right);
            map.put(cR, map.getOrDefault(cR, 0) + 1);
            while (map.size() > k) {
                char cL = s.charAt(left++);
                map.put(cL, map.get(cL) - 1);
                if (map.get(cL) == 0) {
                    map.remove(cL);
                }
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}
