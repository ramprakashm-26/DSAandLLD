package hapagLloyd.problems;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PassportValidation {
    public static void main(String[] args) {
        List<String> lines = List.of(
                "eyr:1972 cid:100",
                "hcl:#18171d ecl:amb hgt:170 pid:186cm iyr:2018 byr:1926",
                "",
                "iyr:2019",
                "hcl:#602927 eyr:1967 hgt:170cm",
                "ecl:grn pid:012533040 byr:1946",
                "",
                "hcl:#123abc eyr:2025",
                "pid:000000001 ecl:brn iyr:2015",
                "hgt:160cm byr:2000"
        );
        System.out.println("Valid passports after validations: " + countValidPassportsStrict(lines));
    }

    /**
     * Required passport fields [birth year, issue year, expiration year,
     * height, hair color, eye color, passport id]
     * byr[1920 - 2002],iyr[2010 - 2020], eyr[2020 - 2030],hgt[59 - 76 or 150-193CM],
     * hcl[start with # and should have 6 digits after #],
     * ecl[amb,blu,brn,gry, grn,hzl, oth], pid[length == 9 digits]
     */
    private static int countValidPassportsStrict(List<String> lines) {
        int validPassportCount = 0;
        Set<String> requiredChecks = Set.of(
                "byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid"
        );
        Set<String> optionalChecks = Set.of("cid");
        Set<String> eyeColors = Set.of(
                "amb", "blu", "brn", "gry", "grn", "hzl", "oth"
        );
        StringBuilder builder = new StringBuilder();
        for (String str : lines) {
            if (!str.isBlank()) {
                builder.append(str).append(" ");
                continue;
            }
            validPassportCount += validatePassport(requiredChecks, optionalChecks, eyeColors, builder.toString());
            builder = new StringBuilder();
        }
        if (!builder.isEmpty()) {
            validPassportCount += validatePassport(requiredChecks, optionalChecks, eyeColors, builder.toString());
        }
        return validPassportCount;
    }

    private static int validatePassport(Set<String> requiredChecks, Set<String> optionalChecks,
                                        Set<String> eyeColors, String passportValues) {
        Map<String, String> providedChecks = new HashMap<>();
        String[] values = passportValues.split(" ");
        for (String value : values) {
            String[] pair = value.split(":");
            if (pair.length == 2 && !optionalChecks.contains(pair[0])) {
                switch (pair[0]) {
                    case "byr" -> {
                        int year = Integer.parseInt(pair[1]);
                        if (year >= 1920 && year <= 2002) {
                            providedChecks.put(pair[0], pair[1]);
                        }
                    }
                    case "iyr" -> {
                        int year = Integer.parseInt(pair[1]);
                        if (year >= 2010 && year <= 2020) {
                            providedChecks.put(pair[0], pair[1]);
                        }
                    }
                    case "eyr" -> {
                        int year = Integer.parseInt(pair[1]);
                        if (year >= 2020 && year <= 2030) {
                            providedChecks.put(pair[0], pair[1]);
                        }
                    }
                    case "hgt" -> {
                        String height = pair[1];
                        if (height.endsWith("cm")) {
                            int h = Integer.parseInt(height.replace("cm", ""));
                            if (h >= 150 && h <= 193)
                                providedChecks.put(pair[0], pair[1]);
                        } else if (height.endsWith("in")) {
                            int h = Integer.parseInt(height.replace("in", ""));
                            if (h >= 59 && h <= 76)
                                providedChecks.put(pair[0], pair[1]);
                        }
                    }
                    case "hcl" -> {
                        String hairColor = pair[1];
                        int len = hairColor.length();
                        if (hairColor.startsWith("#") && hairColor.substring(1, len).
                                matches("^[0-9a-f]{6}$")) {
                            providedChecks.put(pair[0], pair[1]);
                        }
                    }
                    case "ecl" -> {
                        if (eyeColors.contains(pair[1])) {
                            providedChecks.put(pair[0], pair[1]);
                        }
                    }
                    case "pid" -> {
                        if (pair[1].matches("^[0-9]{9}$")) {
                            providedChecks.put(pair[0], pair[1]);
                        }
                    }
                }
            }
        }
        return providedChecks.keySet().containsAll(requiredChecks) ? 1 : 0;
    }
}
