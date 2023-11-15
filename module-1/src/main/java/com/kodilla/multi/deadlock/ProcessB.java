package com.kodilla.multi.deadlock;

import static com.kodilla.multi.deadlock.SharedLocks.sharedLock;

public class ProcessB implements Runnable {
   @Override
   public void run() {
      try {
         Thread.sleep(50);
         synchronized (sharedLock) {
            synchronized (ResourceB.class) {
               System.out.println("Process B, part 1");
               Thread.sleep(50);
               synchronized (ResourceA.class) {
                  System.out.println("Process B, part 2");
               }
            }
         }
      } catch (InterruptedException e) {
         e.printStackTrace();
      }
   }
}