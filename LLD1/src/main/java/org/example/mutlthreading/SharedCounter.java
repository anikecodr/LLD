package org.example.mutlthreading;


import java.util.concurrent.locks.ReentrantReadWriteLock;

class SharedCounter {

        private ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
        private static int counter = 0;


        public void increment() {
            try {
                readWriteLock.writeLock().lock();
                counter++;
                Thread.sleep(1000);
                //int x = getCounter();
               readWriteLock.writeLock().unlock();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        public synchronized int getCounter() {

            readWriteLock.readLock().lock();
            int val = counter;
            readWriteLock.readLock().unlock();
            return val;


    }




    public static void main(String[] args){

        SharedCounter sharedCounter = new SharedCounter();
      Thread t1 =
          new Thread(
              () -> {
                for (int i = 0; i < 10; i++) {
                  System.out.println("started");
                  sharedCounter.increment();
                  System.out.println(Thread.currentThread() + " " + sharedCounter.getCounter());
                }
              },
              "Thread1");

        Thread t2 = new Thread(() -> {
            for(int i=0; i<10; i++) {
                sharedCounter.increment();
                System.out.println(Thread.currentThread() +" " + sharedCounter.getCounter());
            }
        }, "Thread2");

        t1.start(); t2.start();
    }
}

