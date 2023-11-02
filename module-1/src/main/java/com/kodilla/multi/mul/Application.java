package com.kodilla.multi.mul;

import com.kodilla.multi.mul.PartialCalc;
import com.kodilla.multi.mul.Reducer;

public class Application {

   public static void main(String[] args) throws InterruptedException {

      int[] anArray = new int[10];
      for (int n = 0; n < anArray.length; n++) {
         anArray[n] = n+1;
      }

      Reducer reducer = new Reducer();

      PartialCalc p1 = new PartialCalc(reducer, anArray, 0, 5);
      PartialCalc p2 = new PartialCalc(reducer, anArray, 5, anArray.length);

      p1.start();
      p2.start();

      p1.join();
      p2.join();

      System.out.println(reducer.getCounter());
   }
}