package practice.rateLimiter;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class SlidingWindowRateLimiter {
    private static final int USER_LIMIT = 2;
    private static final int SLIDING_WINDOW_IN_SEC = 5;
    private final Map<String, Deque<Long>> bucket;

    public SlidingWindowRateLimiter() {
        bucket = new ConcurrentHashMap<>();
    }

    public boolean allowRequest(long timeStamp, String userId) {
        Deque<Long> userRequests = bucket.computeIfAbsent(userId, key -> new ArrayDeque<>());
        synchronized (userRequests) {
            while (!userRequests.isEmpty() &&
                    timeStamp - userRequests.peek() >= SLIDING_WINDOW_IN_SEC) {
                userRequests.pollFirst();
            }
            if (userRequests.size() >= USER_LIMIT) {
                System.out.printf("Not allowed for user: %s  since the request size now is: %s%n ",
                        userId, userRequests.size());
                return false;
            }
            userRequests.addLast(timeStamp);
            return true;
        }
    }

    public static void main(String[] args) {
        SlidingWindowRateLimiter slidingWindowRateLimiter = new SlidingWindowRateLimiter();
        slidingWindowRateLimiter.allowRequest(1, "A");
        slidingWindowRateLimiter.allowRequest(2, "A");
        slidingWindowRateLimiter.allowRequest(3, "A");
        slidingWindowRateLimiter.allowRequest(4, "A");
        slidingWindowRateLimiter.allowRequest(5, "A");
        slidingWindowRateLimiter.allowRequest(10, "A");
        slidingWindowRateLimiter.allowRequest(11, "A");
    }
}
