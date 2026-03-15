package dsa.arraysAndStrings;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagrams {
    public static void main(String[] args) {
        String s = "anagram", t = "naagram";
        System.out.println("Valid Anagram :" +isAnagram(s, t));
    }

    public static boolean isAnagram(String s, String t) {
        if (s.isEmpty() && t.isEmpty()) {
            return true;
        }
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for (char ch : t.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) - 1);
        }
        for (int value :map.values()) {
            if (value != 0) {
                return false;
            }
        }
        //OR
        // char[] s1 = s.toCharArray();
        // char[] t1 = t.toCharArray();
        // Arrays.sort(s1);
        // Arrays.sort(t1);
        // for (int i = 0; i < s1.length; i++) {
        //     if (s1[i] != t1[i]) {
        //         return false;
        //     }
        // }

        //OR best version

//        int[] freq = new int[26];
//        for (int i = 0; i < s.length(); i++) {
//            freq[s.charAt(i) - 'a']++;
//            freq[t.charAt(i) - 'a']--;
//        }
//        for (int num : freq) {
//            if (num != 0) {
//                return false;
//            }
//        }
        return true;
    }
}
