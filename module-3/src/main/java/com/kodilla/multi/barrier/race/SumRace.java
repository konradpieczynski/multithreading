package com.kodilla.multi.barrier.race;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class SumRace implements Runnable{
    private final CyclicBarrier barrier;
    private final int number;

    public SumRace(CyclicBarrier barrier, int number) {
        this.barrier = barrier;
        this.number = number;
        new Thread(this).start();
    }

    @Override
    public void run() {
        task(number);
        try {
            barrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
    public void task(int number){
        int sumA = 1000;
        int sumB = 0;
        Random random = new Random();
        while (sumA > sumB){
            sumA+= random.nextInt(10);
            sumB+= random.nextInt(50);
            System.out.println("Thread: "+number+", values sumA: "+sumA +", sumB: "+sumB);
        }
    }
}
