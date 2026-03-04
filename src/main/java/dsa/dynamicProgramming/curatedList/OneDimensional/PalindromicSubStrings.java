package dsa.dynamicProgramming.curatedList.OneDimensional;

public class PalindromicSubStrings {
    public static int count = 0;

    public static void main(String[] args) {
        String str = "aaa";
        System.out.println("Palindromic SubStrings: " + countSubStrings(str));
        //backtrack
        backtrack(str, 0);
        System.out.println("Using backtracking: " + count);
    }

    private static int countSubStrings(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            count += expandAroundCenter(i, i, str);
            count += expandAroundCenter(i, i + 1, str);
        }
        return count;
    }

    private static int expandAroundCenter(int left, int right, String s) {
        int count = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }
        return count;
    }

    //backtracking approach
    private static void backtrack(String s, int index) {
        if (index == s.length()) {
            return;
        }
        for (int i = index; i < s.length(); i++) {
            if (isPalindrome(index, i, s)) {
                count++;
                backtrack(s, i + 1);
            }
        }
    }

    private static boolean isPalindrome(int left, int right, String s) {
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }
}
