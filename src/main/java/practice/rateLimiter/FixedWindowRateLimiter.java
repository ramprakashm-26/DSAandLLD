package practice.rateLimiter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class FixedWindowRateLimiter {

    private static final int USER_LIMIT = 2;
    private static final long WINDOW_SIZE = 5; // seconds

    private final Map<String, UserWindow> map = new ConcurrentHashMap<>();

    public boolean allowRequest(String userId, long now) {
        long windowStart = (now / WINDOW_SIZE) * WINDOW_SIZE;

        UserWindow userWindow = map.computeIfAbsent(userId,
                id -> new UserWindow(windowStart));

        synchronized (userWindow) {
            if (userWindow.windowStart != windowStart) {
                userWindow.windowStart = windowStart;
                userWindow.requestCount = 1;
                return true;
            }

            if (userWindow.requestCount >= USER_LIMIT) {
                System.out.printf("User limit exceeded for %s with time range %s%n", userId, now);
                return false;
            }

            userWindow.requestCount++;
            return true;
        }
    }

    private static class UserWindow {
        int requestCount;
        long windowStart;

        UserWindow(long windowStart) {
            this.windowStart = windowStart;
            this.requestCount = 0;
        }
    }

    public static void main(String[] args) {
        FixedWindowRateLimiter fwrl = new FixedWindowRateLimiter();
        fwrl.allowRequest("userId1", 4);
        fwrl.allowRequest("userId1", 4);
        fwrl.allowRequest("userId1", 5);
        fwrl.allowRequest("userId1", 5);
        fwrl.allowRequest("userId1", 10);
    }
}
