package com.kodilla.future.task;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import static com.kodilla.util.SleepUtil.sleep;

public class FutureText {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        final TextProcessor textProcessor1 = new TextProcessor();
        final TextProcessor textProcessor2 = new TextProcessor();
        final Future<String> futureResult1 = textProcessor1.process("test");
        final Future<String> futureResult2 = textProcessor2.process("longer test");

        while (!futureResult1.isDone() || !futureResult2.isDone()) {
            System.out.println("Waiting");
            if (futureResult1.isDone()) System.out.println("Result 1 is ready");
            if (futureResult2.isDone()) System.out.println("Result 2 is ready");
            sleep(1);
        }

        final String result1 = futureResult1.get();
        final String result2 = futureResult2.get();
        System.out.println("Result: " + result1 + ", " + result2);
    }
}
