package hapagLloyd.problems;

import java.util.List;

public class PasswordPolicyParsing {
    public static void main(String[] args) {
        List<String> list = List.of(
                "1-3 a: abcde",
                "1-3 b: cdefg",
                "2-9 c: ccccccccc"
        );
        System.out.println("Count valid passwords: " + countValidPasswords(list));
        System.out.println("Count valid password position: " + countValidPasswordsWithPositions(list));
    }

    private static int countValidPasswords(List<String> lines) {
        int count = 0;
        for (String str : lines) {
            String[] parts = str.split(" ");
            String size = parts[0];
            String letter = parts[1];
            String password = parts[2];
            String[] sizes = size.split("-");

            //data
            int min = Integer.parseInt(sizes[0]);
            int max = Integer.parseInt(sizes[1]);
            char ch = letter.charAt(0);
            int tempCount = 0;
            for (char c1 : password.toCharArray()) {
                if (c1 == ch) {
                    tempCount++;
                }
            }
            if (tempCount >= min && tempCount <= max) {
                count++;
            }
        }
        return count;
    }

    private static int countValidPasswordsWithPositions(List<String> lines) {
        int count = 0;
        for (String str : lines) {
            String[] parts = str.split(" ");
            String[] sizes = parts[0].split("-");
            int pos1 = Integer.parseInt(sizes[0]) - 1;
            int pos2 = Integer.parseInt(sizes[1]) - 1;

            char letter = parts[1].charAt(0);
            String password = parts[2];

            boolean first = password.charAt(pos1) == letter;
            boolean second = password.charAt(pos2) == letter;

            if (first ^ second) { // [true XOR true -> false. true XOR false -> true]
                count++;
            }
        }

        return count;
    }
}
