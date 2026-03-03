package practice.logOperations;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogParsing1 {
    public static void main(String[] args) {
        List<String> logs = List.of(
                "2026-02-14T10:15:23Z INFO user=123 endpoint=/api/orders status=200 time=120ms",
                "2026-02-14T10:15:24Z INFO user=222 endpoint=/api/orders status=200 time=100ms",
                "2026-02-14T10:15:25Z ERROR user=456 endpoint=/api/orders status=500 time=300ms",
                "2026-02-14T10:15:26Z INFO user=123 endpoint=/api/orders status=200 time=80ms",
                "2026-02-14T10:15:27Z INFO user=999 endpoint=/api/orders status=200 time=200ms",

                "2026-02-14T10:15:28Z INFO user=111 endpoint=/api/users status=200 time=50ms",
                "2026-02-14T10:15:29Z INFO user=222 endpoint=/api/users status=200 time=60ms",
                "2026-02-14T10:15:30Z ERROR user=333 endpoint=/api/users status=500 time=500ms",
                "2026-02-14T10:15:31Z INFO user=444 endpoint=/api/users status=200 time=70ms",
                "2026-02-14T10:15:32Z INFO user=555 endpoint=/api/users status=200 time=90ms"
        );
        //Pattern pattern = Pattern.compile("endpoint=([^ ]+) status=(\\d{3}) time=(\\d+)ms");
        Pattern pattern = Pattern.compile("endpoint=(.*?) status=(\\d{3}) time=(\\d+)ms");
        Map<String, EndpointStats> endpointAggregates = new HashMap<>();
        for (String log : logs) {
            Matcher matcher = pattern.matcher(log);
            if (!matcher.find()) continue;
            String apiPath = matcher.group(1);
            String statusStr = matcher.group(2);
            String durationStr = matcher.group(3);
            EndpointStats stats = endpointAggregates.computeIfAbsent(apiPath, key -> new EndpointStats());
            stats.setTotalRequest(stats.getTotalRequest() + 1);
            int status = Integer.parseInt(statusStr);
            if (status >= 200 && status < 300) {
                stats.setSuccessCount(stats.getSuccessCount() + 1);
            } else if (status >= 400 && status < 600) {
                stats.setErrorCount(stats.getErrorCount() + 1);
            }
            int duration = Integer.parseInt(durationStr);
            stats.getDurations().add(duration);
            stats.setSumLatency(stats.getSumLatency() + duration);
        }
        for (Map.Entry<String, EndpointStats> entry : endpointAggregates.entrySet()) {
            EndpointStats endpointStats = entry.getValue();
            double averageLatency = (double) endpointStats.getSumLatency() / endpointStats.getTotalRequest();
            endpointStats.setAverageLatency(averageLatency);
            Collections.sort(endpointStats.getDurations());
            int index = (int) Math.ceil(0.95 * endpointStats.getDurations().size());
            endpointStats.setP95Latency(endpointStats.getDurations().get(index - 1));
        }
        System.out.println(endpointAggregates);
    }

    @Getter
    @Setter
    @ToString
    static class EndpointStats {
        int totalRequest;
        int successCount;
        int errorCount;
        long sumLatency;
        double averageLatency;
        List<Integer> durations;
        int p95Latency;

        public EndpointStats() {
            durations = new ArrayList<>();
        }
    }

}
