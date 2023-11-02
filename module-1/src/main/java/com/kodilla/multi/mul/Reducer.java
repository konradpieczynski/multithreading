package com.kodilla.multi.mul;

public class Reducer {
   private int counter = 1;

   public synchronized void add(int value) {
      counter = counter * value;
   }

   public int getCounter() {
      return counter;
   }
}