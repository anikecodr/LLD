package org.example.jobscheduler;

import java.util.PriorityQueue;

public class JobScheduler {

  PriorityQueue<Job> pq = new PriorityQueue<>((j1, j2) -> Long.compare(j1.executeAt, j2.executeAt));
  private final Object lock = new Object();

  private Thread worker;

  private boolean running = true;

  public JobScheduler() {
    worker = new Thread(this::run);
    worker.start();
  }

  public void schedule(Runnable task, long delayMillis) {
    synchronized (lock) {
      pq.offer(new Job(task, delayMillis));
      lock.notify(); //wake worker if sleeping;
    }
  }

  private void run() {
    while (running) {

      try {
        Job nextJob;

        synchronized (lock) {
          while (pq.isEmpty()) lock.wait();

          long now = System.currentTimeMillis();
          nextJob = pq.peek();
          long waitTime = nextJob.executeAt - now;

          if (waitTime > 0) {
            lock.wait(waitTime);
            continue;
          }
          pq.poll();
          }

          // execute outside the synchronized block

          nextJob.getTask().run();

      } catch (InterruptedException ignored) {

      }
    }
  }

  public void shutdown() {
    running = false;
    System.out.println("Scheduler stopped");
    synchronized (lock) {

      lock.notifyAll();
    }
  }
}
