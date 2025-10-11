package org.example.jobscheduler;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ExecutorService {

    private static class JobScheduler {

        private final ScheduledExecutorService executorService;

        public JobScheduler(int poolsize) {
            executorService = Executors.newScheduledThreadPool(poolsize);
        }

        public void schedule(Runnable task, long delay, TimeUnit unit) {
            executorService.schedule(task, delay, unit);
        }

        public void shutdown() {
            executorService.shutdown();
        }
    }

    public static void main(String[] args){
        JobScheduler scheduler = new JobScheduler(2);

        //onetime job
        scheduler.schedule(() -> System.out.println("Run once: " + new Date()), 2, TimeUnit.SECONDS);

    }
}
