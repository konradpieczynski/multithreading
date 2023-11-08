package com.kodilla.lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.*;

import static com.kodilla.util.SleepUtil.sleep;

public class LockedWarehouse {

   private final Map<Product, Integer> products = new HashMap<>();
//   private final ReadWriteLock lock = new ReentrantReadWriteLock();
//   private final Lock writeLock = lock.writeLock();
//   private final Lock readLock = lock.readLock();

//   public void add(Product product, String by) {
//      System.out.println("I'm " + by + " and want to add " + product);
//      lock.lock();
//      try {
//         sleep(2);
//         products.merge(product, 1, Integer::sum);
//         System.out.println("Product " + product + " added by " + by + ". Now is  " + countProducts());
//      } finally {
//         lock.unlock();
//      }
//   }
//
//   public void showProducts(String inventoryWorkerName) {
//      System.out.println("I'm " + inventoryWorkerName + " and want to check INVENTORY");
//      readLock.lock();
//      try {
//         products.forEach((key, value) ->
//                 System.out.println("[" + inventoryWorkerName + "]" + "Product: " + key + " quantity: " + value));
//      } finally {
//         readLock.unlock();
//      }
//   }

   private final StampedLock lock = new StampedLock();

   public void add(Product product, String by) {
      System.out.println("I'm " + by + " and want to add " + product);
      final long stamp = lock.writeLock();
      try {
         sleep(2);
         products.merge(product, 1, Integer::sum);
         System.out.println("Product " + product + " added by " + by + ". Now is  " + countProducts());
      } finally {
         lock.unlockWrite(stamp);
      }
   }

   public void showProducts(String inventoryWorkerName) {
      System.out.println("I'm " + inventoryWorkerName + " and want to check INVENTORY");
      final long stamp = lock.readLock();
      try {
         products.forEach((key, value) ->
                 System.out.println("[" + inventoryWorkerName + "]" + "Product: " + key + " quantity: " + value));
      } finally {
         lock.unlockRead(stamp);
      }
   }

   private int countProducts() {
      return products.values().stream().reduce(0, Integer::sum);
   }
}