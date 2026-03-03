package dsa.twoPointer;

public class ValidPalindrome {
    public static void main(String[] args) {
        String string = "A man, a plan, a canal: Panama";
        ValidPalindrome validPalindrome = new ValidPalindrome();
        System.out.println(validPalindrome.isPalindrome(string));
    }

    public boolean isPalindrome(String string) {
        if (null == string || string.isEmpty()) {
            return true;
        }
        long start = System.currentTimeMillis();
        int left = 0, right = string.length() - 1;
        while (left < right) {
            if (!Character.isLetterOrDigit(string.charAt(left))) {
                left++;
            } else if (!Character.isLetterOrDigit(string.charAt(right))) {
                right--;
            } else if (Character.toLowerCase(string.charAt(left)) !=
                    Character.toLowerCase(string.charAt(right))) {
                return false;
            } else {
                left++;
                right--;
            }
        }
        System.out.println("Finished execution at: " + (System.currentTimeMillis() - start));
        return true;
    }

    /**
     * @SecondApproach (not going to work for every scenario)
     * Excluded charcters from regex [-[]]
     */
    public boolean isPalindrome2(String string) {
        StringBuilder reversedString = new StringBuilder();
        if (null == string || string.isEmpty()) {
            return true;
        }
        String actualString = string.replaceAll("[.,:;!@#$%&*()=_+\\\\s]+", "");
        String[] splitStrings = string.replaceAll("[,:]+", "").split("\\s+");
        for (int i = splitStrings.length - 1; i >= 0; i--) {
            reversedString.append(reverse(splitStrings[i]));
        }
        return actualString.equalsIgnoreCase(reversedString.toString());
    }

    private String reverse(String str) {
        StringBuilder builder = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            builder.append(str.charAt(i));
        }
        return builder.toString();
    }
}
