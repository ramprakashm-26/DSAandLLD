package org.dsa.prefix_suffix;

import java.util.Arrays;

public class ShortestDistanceToChar {
    public static void main(String[] args) {
        String s = "loveleetcode";
        char c = 'e';
        System.out.println("Shortest Distance to Character: " + Arrays.toString(shortestToChar(s, c)));
        System.out.println("Shortest Distance to Character Space optimizied: " + Arrays.toString(shortestToCharSpaceOpt(s, c)));
    }

    //(O(n)
    public static int[] shortestToChar(String s, char c) {
        int n = s.length();
        int[] result = new int[n];
        int[] left = new int[n];
        int[] right = new int[n];
        for (int i = 1; i < n; i++) {
            left[i] = (s.charAt(i) == c ? 0 : Math.min(left[i], 1 + left[i - 1]));
        }
        for (int i = n - 2; i >= 0; i--) {
            right[i] = (s.charAt(i) == c ? 0 : Math.min(right[i], 1 + right[i + 1]));
        }
        for (int i = 0; i < n; i++) {
            result[i] = Math.min(left[i], right[i]);
        }
        return result;
    }

    public static int[] shortestToCharSpaceOpt(String s, char c) {
        int n = s.length();
        int[] result = new int[n];
        int prev = Integer.MIN_VALUE / 2;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == c) {
                prev = i;
            }
            result[i] = i - prev;
        }
        prev = Integer.MAX_VALUE / 2;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == c) {
                prev = i;
            }
            result[i] = Math.min(result[i], prev - i);
        }
        return result;
    }

}
