package practice.rateLimiter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TokenBucketRateLimiter {
    private static final int CAPACITY = 2;
    private static final double REFILL_RATE = 0.5; // tokens per unit time

    private final Map<String, Bucket> map = new ConcurrentHashMap<>();

    public boolean allowRequest(String userId, long time) {
        Bucket bucket = map.computeIfAbsent(userId, id -> new Bucket(time));

        synchronized (bucket) {
            refill(bucket, time);
            if (bucket.tokens >= 1) {
                bucket.tokens -= 1;
                return true;
            }
            return false;
        }
    }

    private void refill(Bucket bucket, long time) {
        long elapsed = time - bucket.lastRefillTime;
        if (elapsed > 0) {
            double tokensToAdd = elapsed * REFILL_RATE;
            bucket.tokens = Math.min(CAPACITY, bucket.tokens + tokensToAdd);
            bucket.lastRefillTime = time;
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
}