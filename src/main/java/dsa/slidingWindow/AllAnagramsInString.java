package dsa.slidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllAnagramsInString {
    public static void main(String[] args) {
        String s = "cbaebabacd", p = "abc";
        System.out.println("All anagrams in string indices: "+ findAnagrams(s, p));
    }

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        Map<Character, Integer> pMap = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (char ch : p.toCharArray()) {
            pMap.put(ch, pMap.getOrDefault(ch, 0) + 1);
        }
        int have = 0, need = pMap.size(), k = p.length();
        for (int left = 0, right = 0; right < s.length(); right++) {
            char cR = s.charAt(right);
            window.put(cR, window.getOrDefault(cR, 0) + 1);
            if (pMap.containsKey(cR) && pMap.get(cR).intValue() == window.get(cR).intValue()) {
                have++;
            }
            if (right - left + 1 >= k) {
                if (have == need) {
                    list.add(left);
                }
                char cL = s.charAt(left++);
                if (pMap.containsKey(cL) && window.get(cL).intValue() == pMap.get(cL).intValue()) {
                    have--;
                }
                window.put(cL, window.get(cL) - 1);
                if (window.get(cL) == 0) {
                    window.remove(cL);
                }
            }
        }
        return list;
    }

}
