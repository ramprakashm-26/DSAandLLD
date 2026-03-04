package dsa.dynamicProgramming.curatedList.OneDimensional;

public class LongestPalindromicSubString {
    public static void main(String[] args) {
        String str = "babad";
        System.out.println("Longest Palindromic SubString: " + find(str));
    }

    private static String find(String str) {
        if (str.isBlank()) {
            return "";
        }
        if (str.length() == 1) {
            return str;
        }
        int start = 0, end = 0;
        for (int i = 0; i < str.length(); i++) {
            int oddLen = expandAroundCenter(i, i, str);
            int eveLen = expandAroundCenter(i, i + 1, str);
            int len = Math.max(oddLen, eveLen);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + (len / 2);
            }
        }
        return str.substring(start, end + 1);
    }

    private static int expandAroundCenter(int left, int right, String str) {
        while (left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
