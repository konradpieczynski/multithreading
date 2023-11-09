package com.kodilla.future.task;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static com.kodilla.util.SleepUtil.sleep;

public class TextProcessor {
    public Future<String> process(String text) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        return executor.submit(() -> {
            System.out.println("Text processor started processing");
            sleep(text.length());
            System.out.println("Text processor ended processing");
            return "Ready " + text;
        });
    }
}

