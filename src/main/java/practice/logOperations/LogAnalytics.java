package practice.logOperations;

import java.util.*;

public class LogAnalytics {
    private static final int WINDOW = 60;
    private final Deque<Event> eventQueue = new ArrayDeque<>();
    private final Map<String, Integer> frequency = new HashMap<>();

    public void recordEvent(long timestamp, String endpoint) {
        evictExpired(timestamp);
        eventQueue.addLast(new Event(timestamp, endpoint));
        frequency.merge(endpoint, 1, Integer::sum);
    }

    public List<String> topK(long timestamp, int k) {
        evictExpired(timestamp);
        if (frequency.isEmpty()) {
            return Collections.emptyList();
        }
        PriorityQueue<Map.Entry<String, Integer>> heap =
                new PriorityQueue<>((a, b) -> {
                    if (!a.getValue().equals(b.getValue())) {
                        return a.getValue() - b.getValue(); // smaller count first
                    }
                    return b.getKey().compareTo(a.getKey()); // lexicographically larger first
                });

        for (Map.Entry<String, Integer> entry : frequency.entrySet()) {
            heap.offer(entry);
            if (heap.size() > k) {
                heap.poll();
            }
        }

        List<String> result = new ArrayList<>();
        while (!heap.isEmpty()) {
            result.add(heap.poll().getKey());
        }
        Collections.reverse(result);
        return result;
    }

    private void evictExpired(long currentTime) {
        while (!eventQueue.isEmpty() && currentTime - eventQueue.peekFirst().timestamp >= WINDOW) {
            Event old = eventQueue.pollFirst();
            frequency.merge(old.endpoint, -1, Integer::sum);
            if (frequency.get(old.endpoint) == 0) {
                frequency.remove(old.endpoint);
            }
        }
    }

    private static class Event {
        long timestamp;
        String endpoint;

        Event(long timestamp, String endpoint) {
            this.timestamp = timestamp;
            this.endpoint = endpoint;
        }
    }

    public static void main(String[] args) {
        LogAnalytics logAnalytics = new LogAnalytics();
        logAnalytics.recordEvent(10, "/a");
        logAnalytics.recordEvent(20, "/b");
        logAnalytics.recordEvent(30, "/a");
        logAnalytics.recordEvent(40, "/c");
        logAnalytics.recordEvent(50, "/a");

        List<String> topKEndpoints = logAnalytics.topK(70, 2);
        System.out.println(topKEndpoints);
    }
}

