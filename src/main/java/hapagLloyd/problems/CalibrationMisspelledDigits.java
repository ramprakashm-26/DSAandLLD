package hapagLloyd.problems;

import java.util.Map;

/*
Trebuchet Calibration

Each line of text contains a mixture of letters and digits.
Your task is to extract the calibration value from each line.

The calibration value is formed by combining the first digit
and the last digit found in the line.

Example:
Input:
1abc2
pqr3stu8vwx
a1b2c3d4e5f
treb7uchet

Extracted values:
12
38
15
77

Final result = sum of all calibration values.

Part 2 variation:
Digits may also appear spelled out:
one two three four five six seven eight nine

Example:
two1nine -> 29
eightwothree -> 83

Note: words can overlap:
twone -> 21
*/
public class CalibrationMisspelledDigits {
    public static void main(String[] args) {
        String[] strings = new String[] {
                "two1nine", //29
                "eightwothree",//83
                "abcone2threexyz",//13
                "xtwone3four",//24
                "4nineeightseven2",//42
                "zoneight234",//14
                "7pqrstsixteen"//76
        }; //O/P -> total 281
        System.out.println(findDigits(strings));
    }

    private static int findDigits(String[] strings) {
        Map<String, Integer> map = Map.of(
                "one", 1,
                "two", 2,
                "three", 3,
                "four", 4,
                "five", 5,
                "six", 6,
                "seven", 7,
                "eight", 8,
                "nine", 9
        );
        int result = 0;
        for (String str : strings) {
            Integer firstDigit = null;
            Integer lastDigit = null;
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                Integer num = null;

                // Case 1: numeric digit
                if (Character.isDigit(ch)) {
                    num = ch - '0';
                } else {
                    // Case 2: check spelled digits
                    for (String word : map.keySet()) {
                        if (str.startsWith(word, i)) {
                            num = map.get(word);
                            break;
                        }
                    }
                }
                if (num != null) {
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
