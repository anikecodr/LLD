package org.example.mutlthreading;

import java.util.LinkedList;
import java.util.Queue;

public class ThreadTest {

    private static class  Tester1 implements Runnable {

        @Override
        public void run() {

      System.out.println("Tester1 Class run method" + Thread.currentThread());
    }
  }

  private static class ChildThread extends Thread {

        ChildThread(String name) {
            super(name);
        }

        @Override
      public void run() {
      System.out.println("this is " + Thread.currentThread().getName());
        }

  }

//    private synchronized void add(int item) {
//        while (capacity == q.size()) {
//            q.wait();      // ❌ WRONG — you're NOT synchronized on q!
//        }
//        q.add(item);
//        q.notifyAll();     // ❌ WRONG — again, you're NOT synchronized on q!
//    }

//    Two Ways to Fix
//    Option 1 — Synchronize on q
//
//    Option 2 — Keep synchronized on Methods but Use this
    private static class BlockingQueue {
        int capacity;
        Queue<Integer> q;

        BlockingQueue(int capacity) {
            this.capacity = capacity;
            this.q = new LinkedList<>();
        }

        private synchronized void add(int item) {

            while (capacity == q.size()) {
                try {
                    wait();
                } catch (InterruptedException e) {
                }
            }

            q.add(item);
            System.out.println("Producer " + item);
            notifyAll();

        }

        private synchronized void remove() {

            while (q.isEmpty()) {
                try {
                    wait();
                } catch (InterruptedException ignored) {

                }
            }

           int item =  q.poll();
            System.out.println("Consumer " + item);
            notifyAll();
        }
    }
    public static void main(String[] args){
        Thread thread = new Thread(() -> System.out.println("Hi " + Thread.currentThread()), "Hi-Thread");
        Runnable rb = new Tester1();
        Thread thread2 = new Thread(rb);
        Thread thread3 = new Thread("Thread3");
        ChildThread childThread = new ChildThread("Child Thread 1");

        thread3.start();
        rb.run();

        thread.start();

        thread2.start();

        childThread.start();

        BlockingQueue queue = new BlockingQueue(5);

        // Producer Thread
        Thread producer = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                queue.add(i);
                try {
                    Thread.sleep(500); // simulate production delay
                } catch (InterruptedException ignored) {}
            }
        });

        // Consumer Thread
        Thread consumer = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                queue.remove();
                try {
                    Thread.sleep(1000); // simulate consumption delay
                } catch (InterruptedException ignored) {}
            }
        });

        producer.start();
        consumer.start();
    }
}
