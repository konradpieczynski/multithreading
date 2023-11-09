package com.kodilla.threads.homework;

import com.kodilla.threads.ThreadCreator;

public class Application {

   public static void main(String[] args) {
      final ThreadLambdaCreator threadLambdaCreator = new ThreadLambdaCreator(1);
      threadLambdaCreator.start();
   }
}