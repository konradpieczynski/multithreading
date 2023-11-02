package com.kodilla.multi.semaphore.downloader;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Application {
   public static void main(String[] args) {
      ExecutorService executor = Executors.newCachedThreadPool();
      for (int n = 0; n < 100; n++) {
         executor.submit(new DownloadManager());
      }
      executor.shutdown();
   }
}