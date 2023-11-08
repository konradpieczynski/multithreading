package com.kodilla.completable.homework;

import java.util.concurrent.CompletableFuture;

import static com.kodilla.util.SleepUtil.sleep;

public class BookReceiver {
    public CompletableFuture<Book> receive() {
        return CompletableFuture.supplyAsync(() -> {
        System.out.println("Waiting for book...");
        sleep(5);
        return new Book("Test Author", "Test title", 1900, "ABCD");
        });
    }
}
