package org.dsa.backTracking.revision;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddress_10 {
    public static void main(String[] args) {
        String ip = "25525511135";
        System.out.println(restore(ip));
    }

    private static List<String> restore(String ipAddress) {
        List<String> result = new ArrayList<>();
        backtrack(ipAddress, 0, 0, new StringBuilder(), result);
        return result;
    }

    private static void backtrack(String ip, int segment, int index, StringBuilder sb, List<String> result) {
        if (index == ip.length() && segment == 4) {
            result.add(sb.substring(0, sb.length() - 1).toString());
            return;
        }
        if (segment > 4) {
            return;
        }
        for (int i = index; i < ip.length(); i++) {
            String subStr = ip.substring(index, i + 1);
            if (subStr.length() > 1 && subStr.startsWith("0")) {
                break;
            }
            int value = Integer.parseInt(subStr);
            if (value >255) {
                break;
            }
            int len = sb.length();
            sb.append(subStr).append(".");
            backtrack(ip, segment + 1, i + 1, sb, result);
            sb.delete(len, sb.length());
        }
    }
}
