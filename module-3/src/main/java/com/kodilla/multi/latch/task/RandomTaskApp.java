package com.kodilla.multi.latch.task;

import java.util.concurrent.CountDownLatch;

public class RandomTaskApp {
    public static void main(String[] args) {
        CountDownLatch theLatch = new CountDownLatch(5);

        for (int i = 0; i < 5; i++) {
            new RandomTask(theLatch);
        }
        try {
            theLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("The latch has been closed");
    }
}
