package com.kodilla.completable.homework;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class FutureBookTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException{
        final BookReceiver bookReceiver = new BookReceiver();
        final CompletableFuture<String> futureBook = bookReceiver.receive().thenApply(book -> {
            book.setSignature("new signature");
            return book;
        }).thenApply(Book::toString);
        System.out.println(futureBook.get());
    }
}
