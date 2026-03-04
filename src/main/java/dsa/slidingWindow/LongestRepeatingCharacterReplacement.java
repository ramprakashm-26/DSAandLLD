package dsa.slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {
        String s = "AABABBA";
        int k = 1;
        System.out.println("Array approach: " + arrayApproach(s, k));
        System.out.println("Map approach: " + mapApproach(s, k));
    }

    private static int mapApproach(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int max = 0, current = 0;
        for (int left = 0, right = 0; right < s.length(); right++) {
            char cR = s.charAt(right);
            map.put(cR, map.getOrDefault(cR, 0) + 1);
            current = Math.max(current, map.get(cR));
            while ((right - left + 1) - current > k) {
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

    private static int arrayApproach(String s, int k) {
        int[] freq = new int[26];
        int maxFreq = 0, result = 0;
        for (int left = 0, right = 0; right < s.length(); right++) {
            freq[s.charAt(right) - 'A']++;
            maxFreq = Math.max(maxFreq, freq[s.charAt(right) - 'A']);
            while ((right - left + 1) - maxFreq > k) {
                freq[s.charAt(left) - 'A']--;
                left++;
            }
            result = Math.max(result, right - left + 1);
        }
        return result;
    }
}
