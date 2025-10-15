package org.example.circuitbreaker;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicBoolean;
class CircuitBreaker {

    private final int failureThreshold;     // Y - max errors allowed
    private final long windowMillis;        // X - time window in ms
    private final long coolOffMillis;       // Z - cool-off time in ms

    private final AtomicInteger failureCount = new AtomicInteger(0);
    private final AtomicBoolean circuitOpen = new AtomicBoolean(false);

    private long lastFailureTime = 0;
    private long circuitOpenedTime = 0;

    public CircuitBreaker(int failureThreshold, long windowMillis, long coolOffMillis) {
        this.failureThreshold = failureThreshold;
        this.windowMillis = windowMillis;
        this.coolOffMillis = coolOffMillis;
    }

    public synchronized boolean allowRequest() {
        if (circuitOpen.get()) {
            long now = System.currentTimeMillis();
            // Check if cool-off period has passed
            if (now - circuitOpenedTime >= coolOffMillis) {
                System.out.println("Cool-off over. Closing circuit.");
                circuitOpen.set(false);
                failureCount.set(0);
            } else {
                return false; // still open
            }
        }
        return true;
    }

    public synchronized void recordFailure() {
        long now = System.currentTimeMillis();

        // reset if outside window
        if (now - lastFailureTime > windowMillis) {
            failureCount.set(0);
        }
        lastFailureTime = now;

        int count = failureCount.incrementAndGet();
        if (count >= failureThreshold && !circuitOpen.get()) {
            circuitOpen.set(true);
            circuitOpenedTime = now;
            System.out.println("⚠️ Circuit opened! Too many failures.");
        }
    }

    public synchronized void recordSuccess() {
        failureCount.set(0);
    }
}

public class ServiceA {
    public static void main(String[] args) throws InterruptedException {
        CircuitBreaker cb = new CircuitBreaker(
                3,          // Y = max 3 failures
                10_000,     // X = 10 seconds window
                5_000       // Z = 5 seconds cool-off
        );

        for (int i = 0; i < 10; i++) {
            if (!cb.allowRequest()) {
                System.out.println("🚫 Circuit open. Skipping call.");
                Thread.sleep(1000);
                continue;
            }

            boolean success = Math.random() > 0.7; // simulate 30% failure
            if (success) {
                System.out.println("✅ API call success");
                cb.recordSuccess();
            } else {
                System.out.println("❌ API call failed");
                cb.recordFailure();
            }

            Thread.sleep(1000);
        }
    }
}

