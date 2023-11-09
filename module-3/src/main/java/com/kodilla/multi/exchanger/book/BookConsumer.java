package com.kodilla.multi.exchanger.book;

import java.util.concurrent.Exchanger;

public class BookConsumer implements Runnable{

    private Exchanger<Book> exchanger;

    BookConsumer(Exchanger<Book> exchanger) {
        this.exchanger = exchanger;
        new Thread(this).start();
    }

    @Override
    public void run() {
        for (int n = 0; n < 10; n++) {
            try {
                Book msg = exchanger.exchange(null);
                System.out.println(msg);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
