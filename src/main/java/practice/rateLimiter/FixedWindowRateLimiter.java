package practice.rateLimiter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class FixedWindowRateLimiter {
    private static final int USER_LIMIT = 5;
    private static final long WINDOW_SIZE = 5;

    private final Map<String, UserWindow> map = new ConcurrentHashMap<>();

    public boolean allowRequest(String userId, long time) {
        UserWindow userWindow = map.computeIfAbsent(userId,
                id -> new UserWindow(time / WINDOW_SIZE));

        synchronized (userWindow) {
            long currentWindow = time / WINDOW_SIZE;
            if (currentWindow != userWindow.windowId) {
                userWindow.windowId = currentWindow;
                userWindow.requestCount = 0;
            }
            if (userWindow.requestCount < USER_LIMIT) {
                userWindow.requestCount++;
                return true;
            }
            return false;
        }
    }

    private static class UserWindow {
        long windowId;
        int requestCount;

        UserWindow(long windowId) {
            this.windowId = windowId;
        }
    }
}
