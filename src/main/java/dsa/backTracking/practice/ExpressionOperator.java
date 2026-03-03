package org.dsa.backTracking.practice;

import java.util.ArrayList;
import java.util.List;

public class ExpressionOperator {
    public static void main(String[] args) {
        String num = "123";
        int target = 6;
        List<String> result = new ArrayList<>();
        backtrack(num, target, 0, 0, 0, new StringBuilder(), result);
        System.out.println(result);
    }

    private static void backtrack(String num, int target, int index, long currentSum, long previous,
                                  StringBuilder sb, List<String> result) {
        if (index == num.length() && currentSum == target) {
            result.add(sb.toString());
            return;
        }
        for (int i = index; i < num.length(); i++) {
            if (i != index && num.charAt(index) == '0')
                break;
            String subStr = num.substring(index, i + 1);
            long current = Long.parseLong(subStr);
            int len = sb.length();
            if (index == 0) {
                sb.append(subStr);
                backtrack(num, target, i + 1, current, current, sb, result);
                sb.setLength(len);
            } else {
                sb.append("+").append(subStr);
                backtrack(num, target, i + 1, currentSum + current, current, sb, result);
                sb.setLength(len);

                sb.append("-").append(subStr);
                backtrack(num, target, i + 1, currentSum - current, -current, sb, result);
                sb.setLength(len);

                sb.append("*").append(subStr);
                backtrack(num, target, i + 1, currentSum - previous + previous * current,
                        previous * current, sb, result);
                sb.setLength(len);
            }
        }
    }
}
