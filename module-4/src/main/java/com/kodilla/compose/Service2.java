package com.kodilla.compose;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Service2 {
    public CompletableFuture<List<String>> getData() throws InterruptedException {
        Thread.sleep(2000);
        return CompletableFuture.supplyAsync(()-> Arrays.asList("d","c","e","f"));
    }
}
