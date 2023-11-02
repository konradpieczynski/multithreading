package com.kodilla.multi.semaphore.downloader;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class DownloadManager implements Runnable {

   private static int counter;
   private static Semaphore semaphore = new Semaphore(10);

   @Override
   public void run() {
      try {
         semaphore.acquire();
         download();
      } catch (InterruptedException e) {
         e.printStackTrace();
      } finally {
         semaphore.release();
      }
   }

   private void download() throws InterruptedException {
      Random random = new Random();
      synchronized (DownloadManager.class) {
         counter++;
         System.out.println("There is/are " + counter + " downloads");
      }
      Thread.sleep(random.nextInt(1000));
      synchronized (DownloadManager.class) {
         counter--;
      }
   }
}