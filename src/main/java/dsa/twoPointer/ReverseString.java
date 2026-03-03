package dsa.twoPointer;

public class ReverseString {
    public static void main(String[] args) {
        ReverseString reverseString = new ReverseString();
        char[] array = {'h', 'e', 'l', 'l', 'o' };
        System.out.println(reverseString.swapEnds(array));
    }

    /**
     * Reverse String without using additonal space (in same string)
     *
     * @param char array
     * @return char array
     */
    public char[] swapEnds(char[] s) {
        if (null == s || s.length == 0) {
            return s;
        }
        int left = 0, right = s.length - 1;
        while (left < right) {
            char first = s[left], last = s[right];
            s[left] = last;
            s[right] = first;
            left++;
            right--;
        }
        return s;
    }
}
