package com.kodilla.multi.executor.mul;

public class Task implements Runnable {

   int[] tab1 = {1,2,3,4,5,6,7,8,9,10};
   int[] tab2 = {1,2,3,4,5,6,7,8,9,10};
   int[] tabOut = new int[10];

   int n;

   public Task(int n) {
      this.n = n;
   }

   @Override
   public void run() {
      taskBody();
   }
   private void taskBody() {
      synchronized (Task.class) {
         tabOut[n]= tab1[n] * tab2[n];
         System.out.println(Thread.currentThread().getName() + " finished, number = " + (n+1) + " result: " + tabOut[n]);
      }
   }
}