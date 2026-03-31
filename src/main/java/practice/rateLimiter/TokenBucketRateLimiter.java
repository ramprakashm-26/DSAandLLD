package practice.rateLimiter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TokenBucketRateLimiter {
    private static final int CAPACITY = 2;
    private static final double REFILL_RATE = 0.5; // tokens per unit time

    private final Map<String, Bucket> map = new ConcurrentHashMap<>();

    public boolean allowRequest(String userId, long now) {
        Bucket bucket = map.computeIfAbsent(userId, id -> new Bucket(now));

        synchronized (bucket) {
            long elapsed = now - bucket.lastRefillTime;
            double tokensToAdd = elapsed * REFILL_RATE;
            bucket.tokens = Math.min(CAPACITY, bucket.tokens + tokensToAdd);
            bucket.lastRefillTime = now;

            if (bucket.tokens >= 1) {
                bucket.tokens -= 1;
                return true;
            }
            return false;
        }
    }

    private static class Bucket {
        double tokens;
        long lastRefillTime;

        Bucket(long time) {
            this.tokens = CAPACITY;
            this.lastRefillTime = time;
        }
    }

    public static void main(String[] args) {
        TokenBucketRateLimiter tbrl = new TokenBucketRateLimiter();
        tbrl.allowRequest("user1", 0);
        tbrl.allowRequest("user1", 0);
        tbrl.allowRequest("user1", 0);

        tbrl.allowRequest("user1", 2); // after 2 seconds
        tbrl.allowRequest("user1", 2);

        tbrl.allowRequest("user1", 6);
    }
}