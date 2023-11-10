package com.kodilla.producerconsumer.database;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DatabaseApp {
    public static void main(String[] args) {
        Database database = new Database();
        ExecutorService executorService = Executors.newFixedThreadPool(6);

        for (int i = 0; i < 3; i++) {
            int finalI = i;
            executorService.submit(() -> {
                for (int j = 0; j < 10; j++) {
                    Customer customer = new Customer("Customer_" + (finalI*10 + j));
                    database.insert(customer);
                }
            });
        }

        for (int i = 0; i < 3; i++) {
            int final1 = i;
            executorService.submit(() -> {
                for (int j = 0; j < 30; j++) {
                    String mod = " by " + final1 + " loop: " + j;
                    database.modify(j, mod);
                }
            });
        }
        executorService.shutdown();
    }
}