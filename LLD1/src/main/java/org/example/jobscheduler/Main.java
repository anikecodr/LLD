package org.example.jobscheduler;

import java.util.Date;

public class Main {

    public static void main(String[] args){
        JobScheduler scheduler = new JobScheduler();

    scheduler.schedule(() -> System.out.println("Task 1 @ " + new Date()), 2000);
    scheduler.schedule(() -> System.out.println("Task 2 @ " + new Date()), 1000);
    scheduler.schedule(() -> System.out.println("Task 3 @ " + new Date()), 3000);


    //shutdown after 5 sec;
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        scheduler.shutdown();


    }
}
