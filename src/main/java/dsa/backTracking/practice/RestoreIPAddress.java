package org.dsa.backTracking.practice;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddress {
    public static void main(String[] args) {
        String s = "25525511135";
        List<String> result = new ArrayList<>();
        backtracking(s, 0, 0, new StringBuilder(), result);
        System.out.println(result);
    }

    private static void backtracking(String s, int index, int segment, StringBuilder sb, List<String> result) {
        if (index == s.length() && segment == 4) {
            result.add(sb.substring(0, sb.length() - 1));
            return;
        }
        for (int i = index; i < s.length(); i++) {
            String substring = s.substring(index, i + 1);
            if(substring.length() > 1 && substring.startsWith("0")) {
                break;
            }
            int value = Integer.parseInt(substring);
            if (value > 255) {
                break;
            }
            int len = sb.length();
            sb.append(substring).append(".");
            backtracking(s, i + 1, segment + 1, sb, result);
            sb.setLength(len);
        }
    }

//    private static void backtracking(String s, int index, int segment, StringBuilder sb,
//                                     List<String> result) {
//        if (index == s.length() && segment == 4) {
//            result.add(sb.substring(0, sb.length() - 1).toString());
//        }
//        if (segment > 4) {
//            return;
//        }
//        for (int i = index; i < s.length(); i++) {
//            String current = s.substring(index, i + 1);
//            int len = sb.length();
//            int value = Integer.valueOf(current);
//            if (current.length() > 1 && current.startsWith("0")) {
//                break;
//            }
//            if (value > 255) {
//                break;
//            }
//            sb.append(current).append(".");
//            backtracking(s, i + 1, segment + 1, sb, result);
//            sb.delete(len, sb.length());
//        }
//    }
}
