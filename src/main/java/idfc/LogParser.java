package idfc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogParser {
    public static void main(String[] args) {
        //approachI();
        approachII();
    }

    private static void approachI() {
        String str = """
                INFO [GET][/api/users][410][120ms]
                INFO [GET][/api/orders][404][60ms]
                INFO [GET][/api/users][500][95ms]
                INFO [GET][/api/orders][401][180ms]
                INFO [POST][/api/orders][200][310ms]
                DEBUG [OPTIONS][/api/orders][204][-]
                INFO [POST][/api/users][201][250ms]
                """;
        String[] logs = str.split("\n");
        StringBuilder sb = new StringBuilder();
        for (String log : logs) {
            int first = log.indexOf('[');
            int last = log.lastIndexOf(']');
            for (int i = first; i < last; i++) {
                if (log.charAt(i) != '[' && log.charAt(i) != ']') {
                    sb.append(log.charAt(i));
                } else if (log.charAt(i) == '[') {
                    sb.append(" ");
                }
            }
        }
        Map<String, Integer> reqMap = new HashMap<>();
        Map<String, Integer> responseMap = new HashMap<>();
        List<String> errorCodes = List.of("400", "403", "409", "403", "404", "410", "500", "502", "504");
        String slowest = "";
        int max = Integer.MIN_VALUE;
        int errorRate = 0;
        String[] parts = sb.toString().split("GET|POST|OPTIONS|DELETE|PATCH");
        for (int i = 1; i < parts.length; i++) {
            String req = parts[i];
            String[] s = req.split(" ");
            StringBuilder durationStr = new StringBuilder();
            for (char ch : s[3].toCharArray()) {
                if (Character.isDigit(ch)) {
                    durationStr.append(ch);
                }
            }
            int duration = Integer.parseInt(durationStr.toString().isBlank() ? "0" : durationStr.toString());
            reqMap.put(s[1], reqMap.getOrDefault(s[1], 0) + 1);
            responseMap.put(s[1], responseMap.getOrDefault(s[1], 0) + duration);
            if (duration > max) {
                max = duration;
                slowest = s[1];
            }
            if (errorCodes.contains(s[2])) {
                errorRate++;
            }
        }
        reqMap.forEach((key, value) -> responseMap.put(key, responseMap.get(key) / value));
        System.out.println("slowest: " + slowest);
        System.out.println("Request Per Endpoint" + reqMap);
        System.out.println("Average Response Time" + responseMap);
        double errorPercentage = Math.round((double) errorRate / logs.length * 100);
        System.out.println("errorPercentage: " + errorPercentage);
    }


    public static void approachII() {
            String str = """
                INFO [GET][/api/users][410][120ms]
                INFO [GET][/api/orders][404][60ms]
                INFO [GET][/api/users][500][95ms]
                INFO [GET][/api/orders][401][180ms]
                INFO [POST][/api/orders][200][310ms]
                DEBUG [OPTIONS][/api/orders][204][-]
                INFO [POST][/api/users][201][250ms]
                """;

            String[] logs = str.strip().split("\\R"); // \\R matches any line break (\n, \r\n, etc)

            Pattern pattern = Pattern.compile(
                    "\\[(GET|POST|PUT|DELETE|PATCH|OPTIONS)]" +
                            "\\[(.*?)]" +
                            "\\[(\\d{3})]" +
                            "\\[(\\d+)ms]" // or(.*?)
            );

            Map<String, Integer> requestCount = new HashMap<>();
            Map<String, Long> totalDuration = new HashMap<>();
            Map<String, Integer> durationCount = new HashMap<>();

            int totalRequests = 0;
            int errorCount = 0;

            String slowestEndpoint = "";
            long maxDuration = Long.MIN_VALUE;

            for (String log : logs) {
                Matcher matcher = pattern.matcher(log);
                if (!matcher.find()) continue;
                totalRequests++;
                String endpoint = matcher.group(2);
                String statusCode = matcher.group(3);
                String durationStr = matcher.group(4);

                // Request count per endpoint
                requestCount.merge(endpoint, 1, Integer::sum);

                // Error count (4xx & 5xx)
                int code = Integer.parseInt(statusCode);
                if (code >= 400 && code < 600) {
                    errorCount++;
                }

                // Handle duration only if present
                if (!durationStr.equals("-")) {
                    //long duration = Long.parseLong(durationStr.replace("ms", ""));
                    long duration = Long.parseLong(durationStr);
                    totalDuration.merge(endpoint, duration, Long::sum);
                    durationCount.merge(endpoint, 1, Integer::sum);
                    if (duration > maxDuration) {
                        maxDuration = duration;
                        slowestEndpoint = endpoint;
                    }
                }
            }
            // Calculate average response time
            Map<String, Double> avgResponseTime = new HashMap<>();
            for (String endpoint : totalDuration.keySet()) {
                avgResponseTime.put(
                        endpoint,
                        (double) totalDuration.get(endpoint) / durationCount.get(endpoint)
                );
            }
            double errorPercentage = Math.round((errorCount * 100.0 / totalRequests) * 100.0) / 100.0;
            System.out.println("Slowest Endpoint: " + slowestEndpoint);
            System.out.println("Requests Per Endpoint: " + requestCount);
            System.out.println("Average Response Time (ms): " + avgResponseTime);
            System.out.println("Error Percentage: " + errorPercentage + "%");
        }

}
