package hapagLloyd.problems;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
Passport Processing

Input represents passport records.

Each passport consists of key:value pairs separated by spaces or new lines.
Passports are separated by blank lines.

Example passport:
ecl:gry pid:860033327 eyr:2020 hcl:#fffffd
byr:1937 iyr:2017 cid:147 hgt:183cm

Required fields:
byr (Birth Year)
iyr (Issue Year)
eyr (Expiration Year)
hgt (Height)
hcl (Hair Color)
ecl (Eye Color)
pid (Passport ID)

cid (Country ID) is optional.

Part 1:
A passport is valid if all required fields are present.

Part 2:
Fields must also satisfy validation rules:

byr: 1920-2002
iyr: 2010-2020
eyr: 2020-2030
hgt: 150-193cm OR 59-76in
hcl: # followed by exactly 6 hex digits
ecl: one of [amb, blu, brn, gry, grn, hzl, oth]
pid: exactly 9 digits
*/
public class PassportPolicy {
    public static void main(String[] args) {
        List<String> lines = List.of(
                "ecl:gry pid:860033327 eyr:2020 hcl:#fffffd",
                "byr:1937 iyr:2017 cid:147 hgt:183cm",
                "",
                "iyr:2013 ecl:amb cid:350 eyr:2023 pid:028048884",
                "hcl:#cfa07d byr:1929",
                "",
                "hcl:#ae17e1 iyr:2013",
                "eyr:2024",
                "ecl:brn pid:760753108 byr:1931",
                "hgt:179cm",
                "",
                "hcl:#cfa07d eyr:2025 pid:166559648",
                "iyr:2011 ecl:brn hgt:59in"
        );
        System.out.println("Valid passport counts: " + countValidPassports(lines));
    }

    /**
     * Required passport fields [birth year, issue year, expiration year,
     * height, hair color, eye color, passport id]
     * byr,iyr, eyr,hgt, hcl, ecl, pid
     */
    private static int countValidPassports(List<String> lines) {
        int validPassportCount = 0;
        Set<String> passportChecks = Set.of(
                "byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid"
        );
        Set<String> optionalChecks = Set.of("cid");
        StringBuilder builder = new StringBuilder();
        for (String str : lines) {
            if (!str.isBlank()) {
                builder.append(str).append(" ");
                continue;
            }
            validPassportCount += validatePassport(builder.toString(), passportChecks, optionalChecks);
            builder = new StringBuilder();
        }

        // FIX: process last passport if input doesn't end with blank line
        if (!builder.isEmpty()) {
            validPassportCount += validatePassport(builder.toString(), passportChecks, optionalChecks);
        }
        return validPassportCount;
    }

    private static int validatePassport(String passport,
                                        Set<String> passportChecks,
                                        Set<String> optionalChecks) {
        Map<String, String> requiredFields = new HashMap<>();
        String[] passportData = passport.trim().split(" ");
        for (String data : passportData) {
            String[] pair = data.split(":");
            if (pair.length == 2 && !optionalChecks.contains(pair[0])) {
                requiredFields.put(pair[0], pair[1]);
            }
        }
        return requiredFields.keySet().containsAll(passportChecks) ? 1 : 0;
    }
}
