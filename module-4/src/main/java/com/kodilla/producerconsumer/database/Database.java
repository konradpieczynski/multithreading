package com.kodilla.producerconsumer.database;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.*;

class Database {
    private List<Customer> customers = new ArrayList<>();
    private Lock lock = new ReentrantLock();

    private final Condition indexExist = lock.newCondition();

    public synchronized void insert(Customer customer) {
        lock.lock();
        try {
            customers.add(customer);
            System.out.println("Customer added: " + customer.getName());
            indexExist.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void modify(int index, String modification) {
        lock.lock();
        try {
            while (index >= customers.size()) {
                System.out.println("Database wait for exist");
                indexExist.await();
            }
            Customer customer = customers.get(index);
            customer.setName(customer.getName()+modification);
            customers.remove(index);
            customers.add(index, customer);
            System.out.println("Modified: " + customer);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }
}