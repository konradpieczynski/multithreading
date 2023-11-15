package com.kodilla.compose;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Service1 {
    public CompletableFuture<List<String>> getData() throws InterruptedException {
        Thread.sleep(1000);
        return CompletableFuture.supplyAsync(()-> Arrays.asList("a","b","c","d"));
    }
}
