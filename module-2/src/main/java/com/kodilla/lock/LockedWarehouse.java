package com.kodilla.lock;

import com.kodilla.util.SleepUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.*;

public class LockedWarehouse {

   private final Map<Product, Integer> products = new HashMap<>();
   private final StampedLock lock = new StampedLock();

   public void add(Product product, String by) {
      System.out.println("I'm " + by + " and want to add " + product);
      final long stamp = lock.writeLock();
      try {
         SleepUtil.sleep(2);
         products.merge(product, 1, Integer::sum);
         System.out.println("Product " + product + " added by " + by + ". Now is  " + countProducts());
      } finally {
         lock.unlockWrite(stamp);
      }
   }

   public void remove(Product product, String by) {
      System.out.println("I'm " + by + " and want to remove " + product);
      final long stamp = lock.writeLock();
      try {
         SleepUtil.sleep(2);
         if (products.get(product) != null) {
            if (products.get(product) > 0) {
            products.merge(product, -1, Integer::sum);
            System.out.println("Product " + product + " removed by " + by + ". Now is  " + countProducts());
      }
   }
      }
      finally {
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