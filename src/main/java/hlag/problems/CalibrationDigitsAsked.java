package hlag.problems;

public class CalibrationDigitsAsked {
    public static void main(String[] args) {
        String[] strings = new String[]{
                "a1b2c3d4",
                "x9y8z7",
                "abc246",
                "p135"
        };
        System.out.println(findCalibrationSum(strings));
    }

    private static int findCalibrationSum(String[] strings) {
        int result = 0;
        for (String str : strings) {
            Integer odd = null, even = null;
            for (char ch : str.toCharArray()) {
                if (!Character.isDigit(ch)) {
                    continue;
                }
                if (odd != null && even != null) {
                    break;
                }
                int num = Integer.parseInt(String.valueOf(ch));
                if (num % 2 != 0) {
                    odd = num;
                } else {
                    if (even == null) {
                        even = num;
                    }
                }
            }
            if (odd != null && even != null) {
                String res = even + "" + odd;
                result += Integer.parseInt(res);
            }
        }
        return result;
    }
}
