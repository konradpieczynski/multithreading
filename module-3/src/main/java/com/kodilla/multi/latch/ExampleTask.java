package com.kodilla.multi.latch;

import java.util.concurrent.CountDownLatch;

public class ExampleTask implements Runnable {

   private CountDownLatch theLatch;

   public ExampleTask(CountDownLatch theLatch) {
      this.theLatch = theLatch;
      new Thread(this).start();
   }

   @Override
   public void run() {
      for (int n = 0; n < 5; n++)
        doTask();
   }

   private void doTask() {
      System.out.println("Running the task");
      theLatch.countDown();
   }
}