package org.example.jobscheduler;

public class Job {
    private final Runnable task;
    long executeAt; //timestamp

    public Job(Runnable task, long delayMillis) {
        this.task = task;
        this.executeAt = System.currentTimeMillis() +  delayMillis;
    }

    public Runnable getTask() {
        return task;
    }

    public long getExecuteAt() {
        return executeAt;
    }
}
