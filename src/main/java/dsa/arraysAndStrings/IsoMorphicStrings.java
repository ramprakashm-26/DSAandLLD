package dsa.arraysAndStrings;

import java.util.HashMap;
import java.util.Map;

public class IsoMorphicStrings {
    public static void main(String[] args) {
        String s = "bbbaaaba";
        String t = "aaabbbba";
        System.out.println(isIsomorphic(s, t));
    }

    public static boolean isIsomorphic(String s, String t) {
        if (s.isEmpty() && t.isEmpty()) {
            return true;
        }
        Map<Character, Character> tMap = new HashMap<>();
        Map<Character, Character> sMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char sCh = s.charAt(i);
            char tCh = t.charAt(i);
            if (sMap.containsKey(sCh) && sMap.get(sCh) != tCh) {
                return false;
            } else {
                sMap.put(sCh, tCh);
            }

            if (tMap.containsKey(tCh) && tMap.get(tCh) != sCh) {
                return false;
            } else {
                tMap.put(tCh, sCh);
            }
        }
        return true;
    }
}
