package org.example.mutlthreading;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class PubSubMulti {

    private static final int QUEUE_CAPACITY = 5;
    private static final BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(QUEUE_CAPACITY);

    public static void main(String[] args) {

        // Multiple Producers
        Runnable producerTask = () -> {
            String name = Thread.currentThread().getName();
            for (int i = 0; i < 10; i++) {
                try {
                    queue.put(i); // blocks if queue is full
                    System.out.println(name + " produced: " + i);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    throw new RuntimeException(e);
                }
            }
        };

        Thread producer1 = new Thread(producerTask, "Producer1");
        Thread producer2 = new Thread(producerTask, "Producer2");

        // Multiple Consumers
        Runnable consumerTask = () -> {
            String name = Thread.currentThread().getName();
            for (int i = 0; i < 10; i++) {
                try {
                    int val = queue.take(); // blocks if queue is empty
                    System.out.println(name + " consumed: " + val);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    throw new RuntimeException(e);
                }
            }
        };

        Thread consumer1 = new Thread(consumerTask, "Consumer1");
        Thread consumer2 = new Thread(consumerTask, "Consumer2");

        // Start all threads
        producer1.start();
        producer2.start();
        consumer1.start();
        consumer2.start();
    }
}
