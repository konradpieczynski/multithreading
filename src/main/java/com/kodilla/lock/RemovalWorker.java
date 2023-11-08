package com.kodilla.lock;

import com.kodilla.util.SleepUtil;

import java.util.Random;

public class RemovalWorker implements Runnable {
    private final String workerName;
    private final LockedWarehouse warehouse;

    public RemovalWorker(String workerName, LockedWarehouse warehouse) {
        this.workerName = workerName;
        this.warehouse = warehouse;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            SleepUtil.sleep(1);
            final Random random = new Random();
            final int id = random.nextInt(3);
                if (id == 0) {
                    warehouse.remove(Product.BOOK, workerName);
                } else if (id == 1) {
                    warehouse.remove(Product.ELECTRONICS, workerName);
                } else {
                    warehouse.remove(Product.TOYS, workerName);
                }
            }
        }
    }


