package org.dsa.arraysAndStrings;

import java.util.ArrayList;
import java.util.List;

/**
 * Encoded: "4#lint4#code4#love3#you"
 * Decoded Output: ["lint", "code", "love", "you"]
 */
public class EncodeAndDecode {
    public static void main(String[] args) {
        List<String> list = List.of("lint", "code", "love", "you");
        String encode = encode(list);
        System.out.println("Encode : "+ encode);
        System.out.println("Decode :" + decode(encode));
    }

    private static String encode(List<String> list) {
        StringBuilder sb = new StringBuilder();
        for (String str : list) {
            sb.append(str.length()).append("#").append(str);
        }
        return sb.toString();
    }

    private static List<String> decode(String encoded) {
        List<String> decoded = new ArrayList<>();
        int i = 0;
        while (i < encoded.length()) {
            int j = i;
            while (encoded.charAt(j) != '#') {
                j++;
            }
            int len = Integer.parseInt(encoded.substring(i, j));
            decoded.add(encoded.substring(j + 1, len + j + 1));
            i = len + j + 1;
        }
        return decoded;
    }
}
