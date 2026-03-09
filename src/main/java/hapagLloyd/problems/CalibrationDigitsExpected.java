package hapagLloyd.problems;

public class CalibrationDigitsExpected {
    public static void main(String[] args) {
        String[] strings = new String[]{
                "1abc2",
                "pqr3stu8vwx",
                "a1b2c3d4e5f",
                "treb7uchet"
        };
        System.out.println(findCalibration(strings));
    }

    private static int findCalibration(String[] strings) {
        int result = 0;
        for (String str : strings) {
            Integer firstDigit = null;
            Integer lastDigit = null;
            for (char ch : str.toCharArray()) {
                if (Character.isDigit(ch)) {
                    int num = ch - '0';
                    if (firstDigit == null) {
                        firstDigit = num;
                    }
                    lastDigit = num;
                }
            }
            if (firstDigit != null) {
                result += firstDigit * 10 + lastDigit;
            }
        }
        return result;
    }
}
