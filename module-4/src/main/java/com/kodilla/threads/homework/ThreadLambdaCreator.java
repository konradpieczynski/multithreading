package com.kodilla.threads.homework;

public class ThreadLambdaCreator extends Thread {

   private final int num;

   public ThreadLambdaCreator(int num) {
      this.num = num;
   }

   @Override
   public void run() {
      System.out.println("Hello from Thread number " + num);
      if (num != 50) {
         final Thread thread = new Thread(() -> {
            int temp = num+1;
            final Thread thread2 = new ThreadLambdaCreator(temp);
            thread2.start();
         });
         thread.start();
      }
   }
}