package com.kodilla.multi.exchanger.book;

import java.util.concurrent.Exchanger;

public class BookApp {
    public static void main(String[] args) {
        Exchanger<Book> exchanger = new Exchanger<>();

        new BookConsumer(exchanger);
        new BookProducer(exchanger);
    }
}
