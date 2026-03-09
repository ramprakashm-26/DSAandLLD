package hapagLloyd.problems;

import java.util.HashMap;
import java.util.Map;

public class PolymerExpansion {
    public static void main(String[] args) {
        String template = "NNCB";
        System.out.println("Polymer expansion frequency: " + findExpansionCount(template));
    }

    private static long findExpansionCount(String input) {
        Map<String, String> rules = Map.ofEntries(
                Map.entry("CH", "B"),
                Map.entry("HH", "N"),
                Map.entry("CB", "H"),
                Map.entry("NH", "C"),
                Map.entry("HB", "C"),
                Map.entry("HC", "B"),
                Map.entry("HN", "C"),
                Map.entry("NN", "C"),
                Map.entry("BH", "H"),
                Map.entry("NC", "B"),
                Map.entry("NB", "B"),
                Map.entry("BN", "B"),
                Map.entry("BB", "N"),
                Map.entry("BC", "B"),
                Map.entry("CC", "N"),
                Map.entry("CN", "C")
        );
        String expansion = input;
        for (int i = 0; i < 10; i++) {
            StringBuilder builder = new StringBuilder();
            int n = expansion.length() - 1;
            for (int j = 0; j < n; j++) {
                String pair = expansion.substring(j, j + 2);
                String toInsert = rules.get(pair);
                if (toInsert != null) {
                    builder.append(toInsert);
                }
            }
            builder.append(expansion.charAt(n));
            expansion = builder.toString();;
        }
        Map<Character, Long> frequency = new HashMap<>();
        for (char ch : expansion.toCharArray()) {
            frequency.merge(ch, 1L, Long::sum);
        }
        long min = Long.MAX_VALUE, max = Long.MIN_VALUE;
        for (long count : frequency.values()) {
            max = Math.max(max, count);
            min = Math.min(min, count);
        }
        return max - min;
    }
}
