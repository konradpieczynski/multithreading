package com.kodilla.multi.latch.task;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class RandomTask implements Runnable{

    private CountDownLatch theLatch;

    public RandomTask(CountDownLatch theLatch) {
        this.theLatch = theLatch;
        new Thread(this).start();
    }

    @Override
    public void run() {
        doTask();
    }

    private void doTask() {
        Random random = new Random();
        int randomTime = random.nextInt(1501)+500;
        try {
            Thread.sleep(randomTime);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Running the task for: " + randomTime + "ms");
        theLatch.countDown();
    }
}
