package org.dsa.arraysAndStrings;

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] str = {"", "b"};
        System.out.println("Group Anagrams :" + groupAnagrams(str));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = new String(array);
            map.computeIfAbsent(key, k ->new ArrayList<>()).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
