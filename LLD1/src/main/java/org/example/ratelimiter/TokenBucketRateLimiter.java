package org.example.ratelimiter;

public class TokenBucketRateLimiter {

    private final int capacity;          // max number of tokens (burst size)
    private final int refillRate;        // tokens added per second
    private double tokens;               // current tokens
    private long lastRefillTimestamp;    // last refill time

    public TokenBucketRateLimiter(int capacity, int refillRatePerSecond) {
        this.capacity = capacity;
        this.refillRate = refillRatePerSecond;
        this.tokens = capacity; // start full
        this.lastRefillTimestamp = System.currentTimeMillis();
    }

    // ✅ Check if request is allowed
    public synchronized boolean allowRequest() {
        refillTokens();

        if (tokens >= 1) {
            tokens -= 1;
            return true;
        }
        return false;
    }

    // ♻️ Refill tokens based on elapsed time
    private void refillTokens() {
        long now = System.currentTimeMillis();
        double secondsPassed = (now - lastRefillTimestamp) / 1000.0;
        double tokensToAdd = secondsPassed * refillRate;

        if (tokensToAdd > 0) {
            tokens = Math.min(capacity, tokens + tokensToAdd);
            lastRefillTimestamp = now;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // 💡 Example: 5 requests allowed per second, burst up to 10
        TokenBucketRateLimiter limiter = new TokenBucketRateLimiter(10, 5);

        for (int i = 1; i <= 20; i++) {
            if (limiter.allowRequest()) {
                System.out.println("✅ Request " + i + " allowed");
            } else {
                System.out.println("🚫 Request " + i + " blocked");
            }
            Thread.sleep(200); // every 0.2 sec
        }
    }
}

