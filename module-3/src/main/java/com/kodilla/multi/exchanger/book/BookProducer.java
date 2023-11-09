package com.kodilla.multi.exchanger.book;

import java.util.Random;
import java.util.concurrent.Exchanger;

public class BookProducer implements Runnable{
    private Exchanger<Book> exchanger;

    BookProducer(Exchanger<Book> exchanger) {
        this.exchanger = exchanger;
        new Thread(this).start();
    }

    @Override
    public void run() {
        Random random = new Random();
        for (int n = 0; n < 10; n++) {
            try {
                int randomNumber = random.nextInt();
                exchanger.exchange(new Book("Author"+randomNumber,"Title"+randomNumber));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
