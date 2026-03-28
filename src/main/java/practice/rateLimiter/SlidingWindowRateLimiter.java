package practice.rateLimiter;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class SlidingWindowRateLimiter {
    private static final int PER_USER_LIMIT = 5;
    private static final int SLIDING_WINDOW_IN_SEC = 10;
    private final Map<String, Deque<Long>> bucket;

    public SlidingWindowRateLimiter() {
        bucket = new ConcurrentHashMap<>();
    }

    public boolean allowRequest(long timeStamp, String userId) {
        Deque<Long> userRequests = bucket.computeIfAbsent(userId, key -> new ArrayDeque<>());
        synchronized (userRequests) {
            while (!userRequests.isEmpty()) {
                long diff = timeStamp - userRequests.peek();
                if (diff >= SLIDING_WINDOW_IN_SEC) {
                    userRequests.pollFirst();
                } else {
                    break;
                }
            }
            if (userRequests.size() >= PER_USER_LIMIT) {
                System.out.println("Not allowed for user: "+ userId + " since the request size now is: " + userRequests.size());
                return false;
            }
            userRequests.addLast(timeStamp);
            System.out.println("Allowed: " + userId);
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
