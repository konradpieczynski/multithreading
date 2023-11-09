package com.kodilla.completable.homework;

import com.kodilla.util.SleepUtil;

import java.util.concurrent.CompletableFuture;

public class BookReceiver {
    public CompletableFuture<Book> receive() {
        return CompletableFuture.supplyAsync(() -> {
        System.out.println("Waiting for book...");
        SleepUtil.sleep(5);
        return new Book("Test Author", "Test title", 1900, "ABCD");
        });
    }
}
