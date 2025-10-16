package org.example.ratelimiter;

public class RateLimiter {

    private final int maxRequests;       // max requests allowed
    private final long windowMillis;     // time window in ms
    private int requestCount;
    private long windowStart;

    public RateLimiter(int maxRequests, long windowMillis) {
        this.maxRequests = maxRequests;
        this.windowMillis = windowMillis;
        this.requestCount = 0;
        this.windowStart = System.currentTimeMillis();
    }

    // ✅ checks if request allowed or not
    public synchronized boolean allowRequest() {
        long now = System.currentTimeMillis();

        // reset counter if window passed
        if (now - windowStart >= windowMillis) {
            windowStart = now;
            requestCount = 0;
        }

        if (requestCount < maxRequests) {
            requestCount++;
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws InterruptedException {
        // Allow max 5 requests every 10 seconds
        RateLimiter limiter = new RateLimiter(5, 10_000);

        for (int i = 1; i <= 10; i++) {
            if (limiter.allowRequest()) {
                System.out.println("✅ Request " + i + " allowed");
            } else {
                System.out.println("🚫 Request " + i + " blocked (limit reached)");
            }
            Thread.sleep(1500); // 1.5 sec between requests
        }
    }
}

